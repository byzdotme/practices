package me.tony.practice;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class RangeExpander {
    // 匹配第一个出现的范围表达式，例如 [001,100]
    private static final Pattern RANGE_PATTERN = Pattern.compile("(.*?)\\[(\\d+),(\\d+)](.*)");

    /**
     * 流式展开（内存友好，适合大范围）
     */
    public static Stream<String> expandStream(String input) {
        Matcher matcher = RANGE_PATTERN.matcher(input);
        if (!matcher.find()) {
            return Stream.of(input);
        }

        String prefix = matcher.group(1);
        String startStr = matcher.group(2);
        String endStr = matcher.group(3);
        String suffix = matcher.group(4);

        try {
            int start = parseNumber(startStr);
            int end = parseNumber(endStr);
            validateRange(start, end);
            int padding = startStr.length();

            // 生成当前范围的所有可能值，并递归处理后续范围
            return IntStream.rangeClosed(start, end)
                    .mapToObj(i -> String.format("%0" + padding + "d", i))
                    .map(num -> prefix + num + suffix)
                    .flatMap(RangeExpander::expandStream);
        } catch (InvalidRangeException e) {
            throw new InvalidRangeException("Invalid range in: " + input, e);
        }
    }

    /**
     * 直接返回列表（适合小范围）
     */
    public static List<String> expand(String input) {
        return expandStream(input).toList();
    }

    //------------------------ 工具方法 ------------------------
    private static int parseNumber(String str) {
        try {
            return Integer.parseInt(str);
        } catch (NumberFormatException e) {
            throw new InvalidRangeException("Invalid number format: " + str);
        }
    }

    private static void validateRange(int start, int end) {
        if (start < 0 || end < 0) {
            throw new InvalidRangeException("Negative values not allowed");
        }
        if (start > end) {
            throw new InvalidRangeException("Start must be <= end");
        }
    }

    //------------------------ 测试用例 ------------------------
    public static void main(String[] args) {
        // 单范围
        System.out.println(expand("my_table_[1,3]"));       // [my_table_1, my_table_2, my_table_3]

        // 多范围
        System.out.println(expand("data_[01,02]_[1,10]"));   // [data_01_A, data_01_B, data_02_A, data_02_B]

        // 大范围（流式处理演示）
        expandStream("log_[00001,10000]")
                .limit(5)
                .forEach(System.out::println);  // 输出 log_00001 到 log_00005（不占满内存）
    }

    // 自定义异常
    public static class InvalidRangeException extends RuntimeException {
        public InvalidRangeException(String message) {
            super(message);
        }

        public InvalidRangeException(String message, Throwable cause) {
            super(message, cause);
        }
    }
}
