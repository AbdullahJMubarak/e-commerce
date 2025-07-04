import java.util.*;

public class DeliveryManager {
    public static void ship(List<Transportable> items) {
        if (items.isEmpty())
            return;

        System.out.println("\n** Shipping Details **");

        double totalWeight = 0.0;
        Map<String, Integer> counts = new HashMap<>();
        Map<String, Double> weights = new HashMap<>();

        for (Transportable item : items) {
            String name = item.getName();
            counts.put(name, counts.getOrDefault(name, 0) + 1);
            weights.put(name, item.getWeight());
            totalWeight += item.getWeight();
        }

        for (String name : counts.keySet()) {
            System.out.printf("%dx %s (%.0fg each)\n", counts.get(name), name, weights.get(name) * 1000);
        }

        System.out.printf("Total weight: %.2f kg\n", totalWeight);
    }
}
