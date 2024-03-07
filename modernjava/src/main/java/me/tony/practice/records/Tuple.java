package me.tony.practice.records;

import java.util.Map;

/**
 * @author tony.zhuby
 */
public record Tuple<LEFT, RIGHT>(LEFT left, RIGHT right) implements Map.Entry<LEFT, RIGHT> {
    @Override
    public LEFT getKey() {
        return left;
    }

    @Override
    public RIGHT getValue() {
        return right;
    }

    @Override
    public RIGHT setValue(RIGHT value) {
        throw new UnsupportedOperationException();
    }
}
