package me.tony.practice.java21.test;

import me.tony.practice.java21.Gender;
import me.tony.practice.java21.WorkCard;
import me.tony.practice.java21.job.Engineer;
import me.tony.practice.java21.job.Job;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.IntStream;

public class Tests {

    static Logger log = LoggerFactory.getLogger(Tests.class);

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
    public void recordPattern() {
        Object obj = new WorkCard(1100L, "tony", Gender.MALE, "tony@work", new Engineer.Senior());
        if (obj instanceof WorkCard(Long stuffId, String stuffName, Gender gender, String contact, Job job)) {
            log.info("find {},s work card:\n{}", stuffName, ((WorkCard) obj).card());
        }
    }

}
