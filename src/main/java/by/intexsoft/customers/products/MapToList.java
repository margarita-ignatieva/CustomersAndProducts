package by.intexsoft.customers.products;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class MapToList {
    public static List<List<String>> transformMapToList(
            Map<String, Long> customersProducts, long threshold) {
        if (customersProducts == null) {
            throw new IllegalArgumentException("Map can't be null!");
        }
        List<List<String>> listOfCustomers = new ArrayList<>();
        List<String> tempCustomersList = new ArrayList<>();
        long currentSum = 0;
        int step = 0;
        Iterator<Map.Entry<String, Long>> entries = customersProducts.entrySet().iterator();
        long sum = customersProducts.entrySet().stream().map(x -> x.getValue()).mapToLong(x -> x).sum();
        List<String> customersDef = customersProducts.entrySet().stream().map(x -> x.getKey()).collect(Collectors.toList());
        while (entries.hasNext()) {
            step++;
            Map.Entry<String, Long> entry = entries.next();
            tempCustomersList.add(entry.getKey());
            currentSum += entry.getValue();
            if (currentSum > threshold && tempCustomersList.size() > 1) {
                listOfCustomers.add(new ArrayList<>() {{
                    addAll(0, tempCustomersList.subList(0, tempCustomersList.size() -1));}});
                tempCustomersList.clear();
                tempCustomersList.add(entry.getKey());
                currentSum = entry.getValue();
            }
            if (entry.getValue() >= threshold) {
                listOfCustomers.add(new ArrayList<>() {{add(entry.getKey());}});
                tempCustomersList.remove(entry.getKey());
                currentSum = 0;
            }
            if (sum <= threshold) {
                listOfCustomers.add(customersDef.subList(step - 1, customersDef.size()));
                break;
            }
            sum -= entry.getValue();
        }
        return listOfCustomers;
    }
}
