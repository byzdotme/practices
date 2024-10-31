package me.tony.practice;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Base64;

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
        FE a = FE.A;
        FE b = FE.B;
        FE n = null;
        FE n1 = null;
        System.out.println(a == b);
        System.out.println(a == n);
        System.out.println(n == n1);
        System.out.println(n == b);
    }

    static enum FE {
        A,B,C
    }
}
