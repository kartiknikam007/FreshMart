package com.mart;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ViewCart {
    private Map<String, Integer> cartItems = new HashMap<>();
    private Map<String, Integer> itemPrices = new HashMap<>();

    public ViewCart() {
        // Initialize item prices (add only valid items here)
        itemPrices.put("Chicago Deep-Dish Pizza", 300);
        itemPrices.put("New York-style Pizza", 500);
        // (Continue adding other items as in Order class)
    }

    public void addItem(String item, int quantity) {
        if (itemPrices.containsKey(item)) {
            cartItems.put(item, cartItems.getOrDefault(item, 0) + quantity);
            System.out.println(quantity + " " + item + "(s) added to cart.");
        } else {
            System.out.println("Invalid item. Please enter a valid item from the menu.");
        }
    }

    public void removeItem(String item) {
        if (cartItems.containsKey(item)) {
            cartItems.remove(item);
            System.out.println(item + " removed from cart.");
        } else {
            System.out.println(item + " is not in your cart.");
        }
    }

    public void displayCart() {
        System.out.println("\nYour Cart:");
        System.out.println("=========================");
        int totalAmount = 0;
        for (Map.Entry<String, Integer> entry : cartItems.entrySet()) {
            String item = entry.getKey();
            int quantity = entry.getValue();
            int price = itemPrices.get(item);
            int itemTotal = price * quantity;
            totalAmount += itemTotal;
            System.out.println(item + " x " + quantity + " = $" + itemTotal);
        }
        System.out.println("=========================");
        System.out.println("Total Amount: $" + totalAmount);
    }

    public void confirmOrder(Scanner scanner) {
        System.out.println("\nPlease provide your details to confirm the order.");
        System.out.print("Customer Name: ");
        String customerName = scanner.nextLine();

        System.out.print("Delivery Address: ");
        String address = scanner.nextLine();

        System.out.print("Contact Number: ");
        String contactNumber = scanner.nextLine();

        System.out.println("\nOrder Summary:");
        displayCart();

        System.out.print("Confirm payment (yes/no): ");
        String paymentConfirmation = scanner.nextLine();

        if (paymentConfirmation.equalsIgnoreCase("yes")) {
            System.out.println("\nThank you, " + customerName + "! Your order is confirmed.");
            System.out.println("It will be delivered to " + address + ".");
        } else {
            System.out.println("\nOrder not confirmed. Returning to menu.");
        }
    }
}
