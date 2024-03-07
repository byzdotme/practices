package me.tony.practice.web.test.jackson;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import me.tony.practice.web.AppMain;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashMap;
import java.util.Map;

//@SpringBootTest(classes = AppMain.class)
public class TestJackson {

    private static final Logger log = LoggerFactory.getLogger(TestJackson.class);

//    @Autowired
    private final ObjectMapper om = new ObjectMapper();

    @Test
    public void test() throws JsonProcessingException {
        Map<Long, String> map = new HashMap<>();
        map.put(1L, "abc");
        String json = om.writeValueAsString(map);
        log.info("{}", json);
    }

    @Test
    public void testMap() throws JsonProcessingException {
        var json = "{\"foo\":\"abc\",\"bar\":123,\"baz\":true,\"qux\":{\"a\":1,\"b\":2}}";
//        var map = om.readValue(json, new TypeReference<Map<String, Object>>() {
//        });
//        map.forEach((k,v) -> System.out.println(v.getClass()));
        var node = om.readTree(json);
        if (node.isObject()) {
            node.fields().forEachRemaining(e -> {
                System.out.println(e.getKey() + " : " + e.getValue().getNodeType().name());
            });
        }
    }
}
