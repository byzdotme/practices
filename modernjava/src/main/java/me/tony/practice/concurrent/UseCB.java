package me.tony.practice.concurrent;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Slf4j
public class UseCB {

    public static void main(String[] args) {
        final var total = new AtomicLong(0);
        final var cnt = new AtomicInteger(0);
        var cb = new CyclicBarrier(5, () -> log.info("{} done. used: {}ms", cnt.addAndGet(1), total.getAndSet(0)));
        try (var es = Executors.newFixedThreadPool(100)) {
            var ts = IntStream.range(0, 100).mapToObj(idx -> es.submit(() -> {
                final var begin = System.currentTimeMillis();
                try {
                    var millis = ThreadLocalRandom.current().nextLong(1000);
                    log.info("idx:{} sleep for:{} cb:{} {} {}", idx, millis, cb.getParties(), cb.getNumberWaiting(), cb.isBroken());
                    Thread.sleep(millis);
                    return System.currentTimeMillis() - begin;
                } catch (InterruptedException _) {
                    return System.currentTimeMillis() - begin;
                } finally {
                    total.getAndAdd(System.currentTimeMillis() - begin);
                    try {
                        cb.await();
                    } catch (InterruptedException | BrokenBarrierException _) {
                    }
                }
            })).toList();

            ts.forEach(f -> {
                try {
                    f.get();
                } catch (ExecutionException | InterruptedException _) {

                }
            });
        }
    }
}
