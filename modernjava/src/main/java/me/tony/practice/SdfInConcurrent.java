package me.tony.practice;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Objects;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;

public class SdfInConcurrent {

    public static void main(String[] args) {
        final var size = 1000;
        var localDateTimes = IntStream.range(0, size)
                .mapToObj(_ -> LocalDateTime.of(rand(1999, 2024), rand(1, 12), rand(1, 28), rand(0, 23), rand(0, 59), rand(0, 59)))
                .toList();
        var dates = localDateTimes.stream().map(d -> Date.from(d.atZone(ZoneId.systemDefault()).toInstant())).toList();

        final var pattern = "yyyy-MM-dd HH:mm:ss";
        final var formatter = DateTimeFormatter.ofPattern(pattern);
        final var simpleDateFormat = new SimpleDateFormat(pattern);

        var cnt = new AtomicInteger(0);
        var tasks = IntStream.range(0, size).mapToObj( index ->
            Thread.startVirtualThread(() -> {
                var str1 = formatter.format(localDateTimes.get(index));
                var str2 = simpleDateFormat.format(dates.get(index));
                if (!Objects.equals(str1, str2)) {
                    System.out.println(STR."\{str1} != \{str2}");
                    cnt.addAndGet(1);
                }
            })
        ).toList();
        tasks.forEach(SdfInConcurrent::join);

        System.out.println(STR."bad cases count:\{cnt.get()}");

    }

    static int rand(int from, int to) {
        return ThreadLocalRandom.current().nextInt(from, to + 1);
    }

    static void join(Thread t) {
        try {
            t.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
