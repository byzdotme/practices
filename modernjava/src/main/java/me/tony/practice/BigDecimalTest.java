package me.tony.practice;

import java.math.BigDecimal;

public class BigDecimalTest {

    public static void main(String[] args) {
        BigDecimal a = new BigDecimal("1.0");
        BigDecimal b = new BigDecimal("1.00");
        System.out.println(a.compareTo(b));

        BigDecimal.valueOf(1.0);
    }
}
