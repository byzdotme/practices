package test;

import org.junit.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class CommonTest {

    @Test
    public void test() {
        String str = "20220907";

        LocalDateTime dateTime = LocalDate.from(DateTimeFormatter.ofPattern("yyyyMMdd").parse(str)).atTime(LocalTime.MAX);
        System.out.println(dateTime);
    }
}
