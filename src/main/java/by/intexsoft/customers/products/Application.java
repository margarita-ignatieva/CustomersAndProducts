package by.intexsoft.customers.products;

import java.util.HashMap;
import java.util.Map;

public class Application {
    public static void main(String args[]) {
        Map<String, Long> mapUnOrdered = new HashMap<>();
        mapUnOrdered.put("a", 1L);
        mapUnOrdered.put("b", 10L);
        mapUnOrdered.put("c", 3L);
        mapUnOrdered.put("d", 1L);
        mapUnOrdered.put("e", 12L);
        System.out.println(MapToList.transformMapToList(mapUnOrdered, 10));
    }
}
