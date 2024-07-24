package me.tony.practice.vthread;

import java.util.ArrayList;
import java.util.List;

public class SublistTest {

    public static void main(String[] args) {
        var list = new ArrayList<>(List.of(1,2,3,4,5));
        var sub = list.subList(1,3);
        list.add(6);
        sub.add(7);
    }
}
