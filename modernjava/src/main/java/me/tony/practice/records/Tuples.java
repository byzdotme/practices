package me.tony.practice.records;

import java.util.List;
import java.util.Map;

/**
 * @author tony.zhuby
 */
public class Tuples {

    public static <K, V> List<Tuple<K, V>> toTuples(Map<K, V> map) {
        return map.entrySet().stream().map(it -> new Tuple<>(it.getKey(), it.getValue())).toList();
    }

    public static <LEFT, RIGHT> Tuple<LEFT, RIGHT> of(LEFT left, RIGHT right) {
        return new Tuple<>(left, right);
    }
}
