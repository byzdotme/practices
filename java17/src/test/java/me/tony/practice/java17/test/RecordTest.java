package me.tony.practice.java17.test;

import me.tony.practice.java17.records.User;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author tony.zhuby
 */
public class RecordTest {

    static Logger log = LoggerFactory.getLogger(RecordTest.class);

    @Test
    void useUser() {
        var user = new User(123L, "zhangsan", "1234");
        var user1 = new User(123L, "zhangsan", "1234");
        var user2 = new User(124L, "lisi", "4321");
        log.info("user: {}", user);
        log.info("user1: {}", user1);
        log.info("user2: {}", user2);
        log.info("hashcode of user:{} user1:{} user2:{}", user.hashCode(), user1.hashCode(), user2.hashCode());
        Assertions.assertThat(user)
                .isEqualTo(user1)
                .isNotEqualTo(user2);
    }

    @Test
    void testInnerRecord() {
        record Tuple<LEFT, RIGHT>(LEFT left, RIGHT right) {
        }
        var map = Map.of("k1", "v1", "k2", "v2", "k3", "v3");
        var list = map.entrySet().stream().map(it -> new Tuple<>(it.getKey(), it.getValue())).collect(Collectors.toList());
        list.forEach(it -> log.info("key:{}, value:{}", it.left(), it.right));
        Assertions.assertThat(map).hasSameSizeAs(list);
    }

    @Test
    void testInnerRecordDuplicateName() {
        record Tuple(String left, String right) {
        }
        var tuple = new Tuple("", "");
        log.info("tuple: {}", tuple);
        Assertions.assertThat(tuple).isNotNull();
    }
}
