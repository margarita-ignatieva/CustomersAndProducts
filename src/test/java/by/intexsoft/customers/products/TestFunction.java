package by.intexsoft.customers.products;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import org.junit.Assert;
import org.junit.Test;

public class TestFunction {


    @Test
    public void testOrderedMap() {
        Map<String, Long> mapOrdered = new TreeMap<>();
        mapOrdered.put("a", 100L);
        mapOrdered.put("b", 100L);
        mapOrdered.put("c", 3L);
        mapOrdered.put("d", 123L);
        mapOrdered.put("e", 12L);
        mapOrdered.put("f", 12L);
        mapOrdered.put("g", 100L);
        mapOrdered.put("h", 5L);
        mapOrdered.put("i", 3L);
        mapOrdered.put("j", 12L);
        mapOrdered.put("k", 12L);
        mapOrdered.put("l", 120L);
        List<List<String>> transormedList = MapToList.transformMapToList(mapOrdered, 100);
        List<List<String>> compareList = new ArrayList<>();
        compareList.add(new ArrayList<>() {{add("a");}});
        compareList.add(new ArrayList<>() {{add("b");}});
        compareList.add(new ArrayList<>() {{add("c");}});
        compareList.add(new ArrayList<>() {{add("d");}});
        compareList.add(new ArrayList<>() {{add("e");add("f");}});
        compareList.add(new ArrayList<>() {{add("g");}});
        compareList.add(new ArrayList<>() {{add("h");add("i");add("j");add("k");}});
        compareList.add(new ArrayList<>() {{add("l");}});
        System.out.println(transormedList);
        Assert.assertTrue(transormedList.equals(compareList));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testNullMap() {
        MapToList.transformMapToList(null, 100);
    }

    @Test
    public void testSmallThreshold() {
        Map<String, Long> mapOrdered = new TreeMap<>();
        mapOrdered.put("a", 17L);
        mapOrdered.put("b", 10L);
        mapOrdered.put("c", 38L);
        mapOrdered.put("d", 17L);
        mapOrdered.put("e", 13L);
        mapOrdered.put("f", 12L);
        mapOrdered.put("g", 56L);
        List<List<String>> transormedList = MapToList.transformMapToList(mapOrdered, 1);
        List<List<String>> compareList = new ArrayList<>();
        compareList.add(new ArrayList<>() {{add("a");}});
        compareList.add(new ArrayList<>() {{add("b");}});
        compareList.add(new ArrayList<>() {{add("c");}});
        compareList.add(new ArrayList<>() {{add("d");}});
        compareList.add(new ArrayList<>() {{add("e");}});
        compareList.add(new ArrayList<>() {{add("f");}});
        compareList.add(new ArrayList<>() {{add("g");}});
        System.out.println(transormedList);
        Assert.assertTrue(transormedList.equals(compareList));
    }
}
