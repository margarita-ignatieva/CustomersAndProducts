package by.intexsoft.customers.products;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class MapToList {
    public static List<List<String>> transformMapToList(
            Map<String, Long> customersProducts, long threshold) {
        if (customersProducts == null) {
            throw new IllegalArgumentException("Map can't be null!");
        }
        List<List<String>> listOfCustomers = new ArrayList<>();
        final List<String> tempCustomersList = new ArrayList<>();
        long currentSum = 0;
        for (final Map.Entry<String, Long> entry : customersProducts.entrySet()) {
            tempCustomersList.add(entry.getKey());
            currentSum += entry.getValue();
            if (currentSum > threshold && tempCustomersList.size() > 1) {
                listOfCustomers.add(new ArrayList<String>() {{
                    addAll(0, tempCustomersList.subList(0, tempCustomersList.size() -1));}});
                tempCustomersList.clear();
                tempCustomersList.add(entry.getKey());
                currentSum = entry.getValue();
            }
            if (entry.getValue() >= threshold) {
                listOfCustomers.add(new ArrayList<String>() {{add(entry.getKey());}});
                tempCustomersList.remove(entry.getKey());
                currentSum = 0;
            }
        }
        return listOfCustomers;
    }
}
