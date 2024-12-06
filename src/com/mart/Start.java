package com.mart;

import java.util.Scanner;

public class Start {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ViewCart viewCart = new ViewCart();

        printWelcomeMessage();

        int choice;
        do {
            displayMenu();
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline
            handleUserChoice(choice, scanner, viewCart);
        } while (choice != 5);

        scanner.close();
    }

    private static void printWelcomeMessage() {
        System.out.println("\n" + "\u001B[34m" + "=============================" + "\u001B[0m");
        System.out.println("\u001B[32m" + "       WELCOME TO FRESHMARTFOODIE" + "\u001B[0m");
        System.out.println("\u001B[34m" + "=============================" + "\u001B[0m");
        System.out.println("\u001B[33m" + "Where Freshness Meets Foodies!" + "\u001B[0m");
        System.out.println("\u001B[34m" + "=============================" + "\u001B[0m");
    }

    private static void displayMenu() {
        System.out.println("\nPlease choose an option:");
        System.out.println("1. View Food Menu and Add Items");
        System.out.println("2. View Cart");
        System.out.println("3. Remove Item from Cart");
        System.out.println("4. Checkout");
        System.out.println("5. Exit");
        System.out.println("\u001B[34m" + "=============================" + "\u001B[0m");
    }

    private static void handleUserChoice(int choice, Scanner scanner, ViewCart viewCart) {
        switch (choice) {
            case 1:
                System.out.println("Viewing food menu...");
                viewMenu(scanner, viewCart);
                break;
            case 2:
                System.out.println("Viewing cart...");
                viewCart.displayCart();
                break;
            case 3:
                System.out.println("Removing an item from cart...");
                System.out.print("Enter item name to remove: ");
                String itemName = scanner.nextLine();
                viewCart.removeItem(itemName);
                break;
            case 4:
                System.out.println("Proceeding to checkout...");
                viewCart.confirmOrder(scanner);
                break;
            case 5:
                System.out.println("Exiting. Thank you for visiting FreshMartFoodie!");
                break;
            default:
                System.out.println("Invalid choice. Please try again.");
                break;
        }
    }

    public static void viewMenu(Scanner scanner, ViewCart viewCart) {
        int itemChoice;
        do {
            System.out.println("\nPlease choose a food category:");
            System.out.println("1. Pizza");
            System.out.println("2. Burger");
            System.out.println("3. Beverages");
            System.out.println("4. Desserts");
            System.out.println("5. Back to Main Menu");
            System.out.print("Enter your choice: ");
            itemChoice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            if (itemChoice >= 1 && itemChoice <= 4) {
                choiceMenu(itemChoice, viewCart, scanner);
            }
        } while (itemChoice != 5);
    }

    private static void choiceMenu(int itemChoice, ViewCart viewCart, Scanner scanner) {
        switch (itemChoice) {
            case 1:
                Menu.displayPizzaMenu();
                break;
            case 2:
                Menu.displayBurgerMenu();
                break;
            case 3:
                Menu.displayBeveragesMenu();
                break;
            case 4:
                Menu.displayDessertsMenu();
                break;
            default:
                System.out.println("Returning to Main Menu...");
                return;
        }
        System.out.print("Enter the item name to add: ");
        String itemName = scanner.nextLine();
        System.out.print("Enter the quantity: ");
        int quantity = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        viewCart.addItem(itemName, quantity);
    }
}
