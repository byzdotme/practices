package me.tony.practice.jackson;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import lombok.Data;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;

public class TryJackson {

    private static final Logger log = LoggerFactory.getLogger(TryJackson.class);

    static ObjectMapper om = new ObjectMapper();
    static Gson gson = new GsonBuilder().create();

    public static void main(String[] args) throws JsonProcessingException {

//        var foo = new Foo();
//        var bar = new Bar();
//        bar.setBar("abc");
//        foo.setData((Map)Map.of("a", bar));
//        String fooJson = om.writeValueAsString(foo);
//        log.info("{}", fooJson);
//        var json = "{\"data\":{\"a\":{\"bar\":\"abc\"}}}";
//        var foo = gson.fromJson(json, Foo.class);
//        log.info("{}", foo);
//        om.readValue(json, Foo.class);

        var json = "{\"foo\":\"bar\",\"baz\":1}";
        Map<String, Object> map = om.readValue(json, new TypeReference<Map<String, Object>>() {
        });
        System.out.println(map);
    }

    @Data
    public static class Foo {
        private Map<Long, Bar> data;
    }

    @Data
    public static class Bar {
        private String bar;
    }
}
