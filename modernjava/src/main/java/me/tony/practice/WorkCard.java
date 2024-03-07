package me.tony.practice;

import me.tony.practice.job.Job;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.security.SecureRandom;

public record WorkCard(Long stuffId, String stuffName, Gender gender, String contact, Job job) {

    static Logger log = LoggerFactory.getLogger(WorkCard.class);
    static SecureRandom random = new SecureRandom();

    public WorkCard {
        log.info("stuff info:{} init. data:{}", stuffName, this);
    }

    public String named() {
        Object obj = "hello";
        String name = switch (obj) {
            case String str -> STR."string: \{ str }";
            case Integer i -> STR."integer: \{ i }";
            case null -> "null";
            default -> STR."object \{ obj.toString() }";
        };

        return switch (gender) {
            case MALE -> STR. "Mr. \{ stuffName }" ;
            case FEMALE -> STR. "Mrs. \{ stuffName }" ;
            case null, default -> stuffName;
        };
    }

    public String card() {
        return STR. """
                \{ named() } No.\{ stuffId }
                \{ job.named() }
                contact:\{ contact }
                """ ;
    }
}
