package Rokia;
import java.util.List;
import java.util.ArrayList;

public class Shipping {

    public static void shipItems(List<Shippable> items) {
        if (items.isEmpty()) {
            return;
        }

        System.out.println("Shipment Notice ");
        System.out.println("---------------- ");

        List<String> added = new ArrayList<>();
        double totalWeight = 0;

        for (Shippable item : items) {
            if (!added.contains(item.getName())) {
                int count = 0;
                double weightSum = 0;

                for (Shippable other : items) {
                    if (other.getName().equals(item.getName())) {
                        count++;
                        weightSum += other.getWeight();
                    }
                }

                added.add(item.getName());
                int grams = (int)(weightSum * 1000);  // convert to grams
                String message = count + "x " + item.getName() + "\t" + grams + "g";
                System.out.println(message);
                totalWeight += weightSum;
            }
        }

        System.out.printf("Total package weight %.1fkg\n", totalWeight);
    }
}
