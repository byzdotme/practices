package me.tony.practice;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Base64;
import java.util.Map;
import java.util.SortedMap;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentSkipListMap;
import java.util.function.Function;

public class Foo {
    public static void main(String[] args) throws IOException, InterruptedException {
//        var cmd = STR."\{System.getProperty("java.home")}\{File.separator}bin\{File.separator}java";
//        System.out.println(cmd);
//        var process = Runtime.getRuntime().exec(new String[]{cmd, "-version"});
//        try (var reader = new BufferedReader(new InputStreamReader(process.getInputStream()))) {
//            reader.lines().forEach(System.out::println);
//        }
//        var exit = process.waitFor();
//        System.out.println(STR."process exit with \{exit}");
//        var s = "eyJsb2FuVGVybSI6MywibG9hbk5vIjoiMjQxMDMxMTEyMzQyMjUzMjAxMDgwMDE3OTM0MCIsImRpc2NvdW50UHJpY2UiOjU3LCJiaXpUcmFkZXJObyI6IjI0MTAzMDE1MzQ0MDc3MTQwMTA0MjMwMzkzNDAiLCJ0cmFkZVByaWNlIjoxOTAwLCJhY3R1YWxJbnRlcmVzdCI6MCwiZGVhbEluZm8iOiJ7fSIsInRyYWRlQml6VGltZSI6MTczMDI3MzY4MDQ1NCwibWVyY2hhbnRObyI6IjExMDAwMDEzNTIwMjE1In0=";
//        var str = new String(Base64.getDecoder().decode(s));
//        System.out.println(str);
//        FE a = FE.A;
//        FE b = FE.B;
//        FE n = null;
//        FE n1 = null;
//        System.out.println(a == b);
//        System.out.println(a == n);
//        System.out.println(n == n1);
//        System.out.println(n == b);

//        Map<String, Object> map = new ConcurrentHashMap<>();
//        Function<String, Object> f = _ -> {
//            System.out.println("in compute");
//            throw new RuntimeException("e");
//        };
//        try {
//            map.computeIfAbsent("a", f);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        try {
//            map.computeIfAbsent("a", f);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        try {
//            map.computeIfAbsent("a", f);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }

        var map = new ConcurrentSkipListMap<Long, Foo>();
        map.put(1L, new Foo());
        map.put(2L, new Foo());
        map.put(3L, new Foo());
        map.put(4L, new Foo());
        map.put(5L, new Foo());
        map.put(6L, new Foo());
        map.put(7L, new Foo());
        map.put(8L, new Foo());
        map.put(9L, new Foo());
        map.put(10L, new Foo());
        map.put(11L, new Foo());

        while (map.size() > 2) {
            Long key = map.firstKey();
            var removed = map.remove(key);
            System.out.println(STR."remove \{key}, value \{removed}");
        }


    }

    static enum FE {
        A,B,C
    }
}
