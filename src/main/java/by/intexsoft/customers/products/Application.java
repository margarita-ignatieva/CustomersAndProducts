package by.intexsoft.customers.products;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class Application {
    public static void main(String args[]) {
        Map<String, Long> mapUnOrdered = new HashMap<>();
        mapUnOrdered.put("a", 1L);
        mapUnOrdered.put("b", 10L);
        mapUnOrdered.put("c", 3L);
        mapUnOrdered.put("d", 1L);
        mapUnOrdered.put("e", 12L);
        System.out.println(MapToList.transformMapToList(mapUnOrdered, 10));
        Map<String, Long> mapUnOrdered2 = new HashMap<>();
        mapUnOrdered2.put("a", 101L);
        mapUnOrdered2.put("b", 101L);
        mapUnOrdered2.put("c", 500L);
        mapUnOrdered2.put("d", 9000L);
        mapUnOrdered2.put("e", 98L);
        mapUnOrdered2.put("f", 98L);
        System.out.println(MapToList.transformMapToList(mapUnOrdered2, 200));
        Map<String, Long> mapOrdered = new TreeMap<>();
        mapOrdered.put("a", 17L);
        mapOrdered.put("b", 10L);
        mapOrdered.put("c", 38L);
        mapOrdered.put("d", 17L);
        mapOrdered.put("e", 13L);
        mapOrdered.put("f", 12L);
        mapOrdered.put("g", 56L);
        System.out.println(MapToList.transformMapToList(mapOrdered, 1));
    }
}
