package me.tony.practice.java21.vthread;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Base64;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.IntStream;

public class VThreadBench implements AutoCloseable {

    static Logger log = LoggerFactory.getLogger(VThreadBench.class);
    final HttpClient http = HttpClient.newHttpClient();

    public static void main(String[] args) throws Exception {
        log.info("cpu cores count:{}", Runtime.getRuntime().availableProcessors());
        try (var bench = new VThreadBench()) {
            // 预热
            IntStream.range(1, 100).forEach(ignore -> {
                try {
                    bench.http.send(HttpRequest.newBuilder().uri(URI.create("https://www.baidu.com/")).GET().build(), HttpResponse.BodyHandlers.ofString());
                } catch (IOException | InterruptedException ignored) {
                }
            });
            bench.benchmark(Executors.newVirtualThreadPerTaskExecutor(), "virtual thread");
            bench.benchmark(Executors.newWorkStealingPool(), "fork join pool");
            bench.benchmark(Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors()), "pool cpu count");
            bench.benchmark(Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors() * 2), "pool 2 x cpu count");
            bench.benchmark(Executors.newFixedThreadPool(100), "pool 100 threads");
            bench.benchmark(Executors.newThreadPerTaskExecutor(Thread.ofPlatform().factory()), "new thread");
        }
    }

    @Override
    public void close() throws Exception {
        http.close();
    }

    private void benchmark(ExecutorService es, String flag) throws InterruptedException {
        final var num = 1_000;
        final var cdl = new CountDownLatch(num);
        final var cnt = new AtomicInteger(0);
        final var costs = new AtomicLong(0);
        final var begin = System.currentTimeMillis();
        try (final var executor = es) {
            IntStream.range(1, num + 1).forEach(idx -> executor.submit(() -> {
                var start = System.currentTimeMillis();
                try {
//            log.info("idx:{} before request", idx);
                    HttpResponse<String> resp = http.send(HttpRequest.newBuilder().uri(URI.create("https://www.baidu.com/")).GET().build(), HttpResponse.BodyHandlers.ofString());
                    byte[] encode = Base64.getEncoder().encode(resp.body().getBytes());
//            log.info("idx:{} after request. resp status:{}. cost:{}", idx, resp.statusCode(), System.currentTimeMillis() - start);
                } catch (IOException | InterruptedException e) {
//            log.error("idx:{} request fail. cost:{}", idx, System.currentTimeMillis() - start, e);
                } finally {
                    final var cost = System.currentTimeMillis() - start;
                    cnt.addAndGet(1);
                    costs.addAndGet(cost);
                    cdl.countDown();
                }
            }));
            cdl.await();
            var t = System.currentTimeMillis() - begin;
            log.info("[{}]total cost:{} ms. sum cost:{} ms. avg:{} ms. parallelism:{}", flag, t, costs.get(), (double) costs.get() / cnt.get(), (double) costs.get() * num / cnt.get() / t);
        }
    }
}
