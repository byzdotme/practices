package me.tony.practice;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;

public class Foo {
    public static void main(String[] args) throws IOException, InterruptedException {
        var cmd = STR."\{System.getProperty("java.home")}\{File.separator}bin\{File.separator}java";
        System.out.println(cmd);
        var process = Runtime.getRuntime().exec(new String[]{cmd, "-version"});
        try (var reader = new BufferedReader(new InputStreamReader(process.getInputStream()))) {
            reader.lines().forEach(System.out::println);
        }
        var exit = process.waitFor();
        System.out.println(STR."process exit with \{exit}");
    }
}
