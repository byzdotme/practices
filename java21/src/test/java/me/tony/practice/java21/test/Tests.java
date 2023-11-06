package me.tony.practice.java21.test;

import me.tony.practice.java21.Gender;
import me.tony.practice.java21.WorkCard;
import me.tony.practice.java21.job.Engineer;
import me.tony.practice.java21.job.Job;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.LocalDate;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.IntStream;

public class Tests {

    static Logger log = LoggerFactory.getLogger(Tests.class);

    static HttpClient http = HttpClient.newHttpClient();

    static void sleep(long millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            log.error("sleep fail", e);
        }
    }

    @Test
    public void virtualThread() {
        try (ExecutorService es = Executors.newVirtualThreadPerTaskExecutor()) {
            IntStream.range(1, 1_000_000).forEach(idx -> es.submit(() -> {
                System.out.println(STR. "\{ idx } - \{ Thread.currentThread().getName() }" );
            }));
        }
    }

    @Test
    public void sleepInVThread() {
        try (ExecutorService es = Executors.newVirtualThreadPerTaskExecutor()) {
            var num = 1_000;
            var cdl = new CountDownLatch(num);
            var begin = System.currentTimeMillis();
            IntStream.range(1, num + 1).forEach(idx -> {
                es.submit(() -> {
//                    log.info("idx:{} before sleep", idx);
//                    var start = System.currentTimeMillis();
                    sleep(1);
                    cdl.countDown();
//                    log.info("idx:{} after sleep. cost:{}", idx, System.currentTimeMillis() - start);
                });
            });
            try {
                cdl.await();
                log.info("total cost:{} ms", System.currentTimeMillis() - begin);
            } catch (InterruptedException e) {
                log.error("cdl await fail", e);
            }
        }
    }

    @Test
    public void httpRequestInVThread() throws InterruptedException {
        final var num = 1_000;
        final var cdl = new CountDownLatch(num);
        final var cnt = new AtomicInteger(0);
        final var costs = new AtomicLong(0);
        final var begin = System.currentTimeMillis();
        IntStream.range(1, num + 1).forEach(idx -> Thread.startVirtualThread(() -> doRequest(idx, http, cdl, cnt, costs)));
        cdl.await();
        //[virtual thread]total cost:3949 ms. sum cost:1465312 ms. avg:1465.312 ms.
        log.info("[virtual thread]total cost:{} ms. sum cost:{} ms. avg:{} ms.", System.currentTimeMillis() - begin, costs.get(), (double) costs.get() / cnt.get());
    }

    @Test
    public void httpRequestInPool() throws InterruptedException {
        final var num = 1_000;
        final var cdl = new CountDownLatch(num);
        final var cnt = new AtomicInteger(0);
        final var costs = new AtomicLong(0);
        final var begin = System.currentTimeMillis();
        final var es = Executors.newWorkStealingPool();
        IntStream.range(1, num + 1).forEach(idx -> es.submit(() -> doRequest(idx, http, cdl, cnt, costs)));
        cdl.await();
        //[thread pool]total cost:2040 ms. sum cost:405243 ms. avg:405.243 ms.
        log.info("[thread pool]total cost:{} ms. sum cost:{} ms. avg:{} ms.", System.currentTimeMillis() - begin, costs.get(), (double) costs.get() / cnt.get());
    }

    private void doRequest(int idx, HttpClient client, CountDownLatch cdl, AtomicInteger cnt, AtomicLong costs) {
        var start = System.currentTimeMillis();
        try {
//            log.info("idx:{} before request", idx);
            HttpResponse<String> resp = client.send(HttpRequest.newBuilder().uri(URI.create("https://www.baidu.com/")).GET().build(), HttpResponse.BodyHandlers.ofString());
//            log.info("idx:{} after request. resp status:{}. cost:{}", idx, resp.statusCode(), System.currentTimeMillis() - start);
        } catch (IOException | InterruptedException e) {
//            log.error("idx:{} request fail. cost:{}", idx, System.currentTimeMillis() - start, e);
        } finally {
            final var cost = System.currentTimeMillis() - start;
            cnt.addAndGet(1);
            costs.addAndGet(cost);
            cdl.countDown();
        }
    }


    @Test
    public void recordPattern() {
        Object obj = new WorkCard(1100L, "tony", Gender.MALE, "tony@work", new Engineer.Senior());
        if (obj instanceof WorkCard(Long stuffId, String stuffName, Gender gender, String contact, Job job)) {
            log.info("find {},s work card:\n{}", stuffName, ((WorkCard) obj).card());
        }
    }

    @Test
    public void fun() {
        final var i = new AtomicInteger(10);
        if (LocalDate.now().isAfter(LocalDate.of(2023, 10, 31))) {
            i.set(20);
        }
        IntStream.range(0, 10).forEach(idx -> {
            System.out.println(STR."\{idx}- \{i.get()}");
        });
    }

}
