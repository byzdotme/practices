package me.tony.practice.java21.asm;

import java.util.List;

public interface IFoo {

    int foo = 1;

    void foo(String foo);

    String foo(List<String> foos);

    default String bar(int bar) {
        return "bar_" + bar;
    }

    static String bars(String bar) {
        return bar;
    }
}
