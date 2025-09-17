package me.tony.practice;

import java.math.BigDecimal;

public class BigDecimalTest {

    void main() {
        BigDecimal a = new BigDecimal("1.0");
        BigDecimal b = new BigDecimal("1.00");
        IO.println(a.compareTo(b));
    }
}
