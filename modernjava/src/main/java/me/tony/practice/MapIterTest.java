package me.tony.practice;

import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class MapIterTest {


    public static void main(String[] args) {
        Map<String, Object> map = new ConcurrentHashMap<>();
        map.put("a", "A");
        map.put("c", "C");
        map.put("b", "B");
        Iterator<Map.Entry<String, Object>> iterator = map.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<String, Object> entry = iterator.next();
            System.out.println(STR."\{entry.getKey()}: " + entry.getValue());
            iterator.remove();
        }
        System.out.println(map.size());


    }
}
