package me.tony.practice.tostringbenchmark;

import com.google.gson.Gson;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Map;
import java.util.stream.IntStream;

@Data
@AllArgsConstructor
public class Foo {

    static Gson gson = new Gson();

    private String str1;
    private String str2;
    private String str3;
    private String str4;

    public static void main(String[] args) {
        var foos = IntStream.rangeClosed(1, 1_000_000).mapToObj(String::valueOf).map(idx -> new Foo(idx, idx, idx, idx)).toList();

        var s1 = System.currentTimeMillis();
        var l3 = foos.stream().map(Foo::toStringManual).toList();
        var s2 = System.currentTimeMillis();
        var l2 = foos.stream().map(Foo::toStringGson).toList();
        var s3 = System.currentTimeMillis();
        var l1 = foos.stream().map(Foo::toString).toList();
        var s4 = System.currentTimeMillis();
        System.out.println(STR."l1 size: \{l1.size()}, cost:\{s2 - s1}, l2 size:\{l2.size()}, cost:\{s3 - s2}, l3 size:\{l3.size()}, cost:\{s4 - s3}");
    }

    @Override
    public String toString() {
        return STR."""
                {
                "str1": \{str1},
                "str2": \{str2},
                "str3": \{str3},
                "str4": \{str4},
                }
                """;
    }

    public String toStringManual() {
        return "{\"str1\":" + str1 + "\"str2\":" + str2 + "\"str3\":" + str3 + "\"str4\":" + str4 + "}";
    }

    public String toStringGson() {
        var map = Map.of("str1", str1, "str2", str2, "str3", str3, "str4", str4);
        return gson.toJson(map);
    }
}
