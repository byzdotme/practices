package me.tony.practice.vthread;

import lombok.extern.slf4j.Slf4j;

import java.util.stream.IntStream;

@Slf4j
public class LargeAmountVThreads {
    public static void main(String[] args) {
//        try (var es = Executors.newVirtualThreadPerTaskExecutor()) {
//            IntStream.range(1, 100_000_000).forEach(idx -> es.submit(() -> System.out.println(STR."\{idx}")));
//        }
        // 内存会跑干，vt啥时候回收啊我艹。。。
        IntStream.range(1, 100_000_000).forEach(_ -> Thread.startVirtualThread(() -> System.out.println("tick")));
    }
}
