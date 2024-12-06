package com.mart;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Order {
    // Store ordered items and their quantities
    private Map<String, Integer> orderedItems = new HashMap<>();
    private Map<String, Integer> itemPrices = new HashMap<>();

    public Order() {
        // Initialize item prices
        itemPrices.put("Chicago Deep-Dish Pizza", 300);
        itemPrices.put("New York-style Pizza", 500);
        itemPrices.put("Detroit-style Pizza", 420);
        itemPrices.put("California-style Pizza", 590);
        itemPrices.put("Miami / Cuban Pizza", 745);
        itemPrices.put("Milan-style Pizza", 650);
        itemPrices.put("Roman Pizza", 520);
        itemPrices.put("Sicilian Pizza", 390);
        itemPrices.put("Hamburger", 100);
        itemPrices.put("Turkey Burger", 250);
        itemPrices.put("Classic Burger", 300);
        itemPrices.put("Lamb Burger", 400);
        itemPrices.put("Chicken Burger", 210);
        itemPrices.put("Specialty Burger", 280);
        itemPrices.put("Cheese Burger", 650);
        itemPrices.put("Bacon Burger", 490);
        itemPrices.put("Assam Tea", 100);
        itemPrices.put("Sweet Lassi", 50);
        itemPrices.put("Masala Chai", 70);
        itemPrices.put("South Indian Coffee", 80);
        itemPrices.put("Mango Lassi", 90);
        itemPrices.put("Darjeeling Tea", 75);
        itemPrices.put("Pie", 500);
        itemPrices.put("Cobblers and Crumbles", 600);
        itemPrices.put("Cheesecake", 450);
        itemPrices.put("Banana Pudding", 250);
        itemPrices.put("Cakes and Cupcakes", 360);
        itemPrices.put("Brownies", 900);
        itemPrices.put("Ice Cream", 450);
    }

    public void orderFood(Scanner scanner) {
        String itemName;
        int quantity;

        do {
            System.out.print("Enter the name of the food item to order (or type 'done' to finish): ");
            itemName = scanner.nextLine();

            if (!itemName.equalsIgnoreCase("done")) {
                if (itemPrices.containsKey(itemName)) {
                    System.out.print("Enter the quantity for " + itemName + ": ");
                    quantity = scanner.nextInt();
                    scanner.nextLine(); // Consume newline

                    // Add item to ordered items with cumulative quantity
                    orderedItems.put(itemName, orderedItems.getOrDefault(itemName, 0) + quantity);
                } else {
                    System.out.println("Item not found in menu. Please enter a valid item name.");
                }
            }
        } while (!itemName.equalsIgnoreCase("done"));

        // Display the order summary
        displayOrderSummary();
    }

    private void displayOrderSummary() {
        int totalAmount = 0;
        System.out.println("\nOrder Summary:");
        System.out.println("====================================");

        for (Map.Entry<String, Integer> entry : orderedItems.entrySet()) {
            String item = entry.getKey();
            int quantity = entry.getValue();
            int price = itemPrices.get(item);
            int itemTotal = price * quantity;
            totalAmount += itemTotal;

            System.out.println(item + " x " + quantity + " = $" + itemTotal);
        }

        System.out.println("====================================");
        System.out.println("Total Amount: $" + totalAmount);
    }
}

