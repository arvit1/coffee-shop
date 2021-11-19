package com.arvit.core;

import java.util.Scanner;

public class StartApplication {
    private static double itemPrice;
    static Scanner input = new Scanner(System.in);
    static double j = 0.0;
    static double runningTotal = 0;

    public static void main(String[] args) {
        input = new Scanner(System.in);
        switchCase(StartApplication.runningTotal);
    }

    private static void switchCase(double runningTotal) {
        int foodItem;
        int menuOption;
        while (true) {
            menu();
            menuOption = input.nextInt();
            switch (menuOption) {
                case 1:
                    foodItem = 1;
                    StartApplication.runningTotal += ItemPrice(foodItem);
                    break;
                case 2:
                    foodItem = 2;
                    StartApplication.runningTotal += ItemPrice(foodItem);
                    break;
                case 3:
                    foodItem = 3;
                    StartApplication.runningTotal += ItemPrice(foodItem);
                    break;
                case 4:
                    foodItem = 4;
                    StartApplication.runningTotal += ItemPrice(foodItem);
                    break;
                case 5:
                    foodItem = 5;
                    StartApplication.runningTotal += ItemPrice(foodItem);
                    break;
                case 6:
                    foodItem = 6;
                    StartApplication.runningTotal += ItemPrice(foodItem);
                    break;
                case 7:
                    foodItem = 7;
                    StartApplication.runningTotal += ItemPrice(foodItem);
                    break;
                case 8:
                    foodItem = 8;
                    StartApplication.runningTotal += ItemPrice(foodItem);
                    break;
                case 9:
                    done(StartApplication.runningTotal);
                    break;
                case 10:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid option.");
            }
        }
    }

    public static void menu() {
        System.out.println("Welcome \n1. small coffee (2.50 CHF) " +
                "\n2. medium coffee (3.00 CHF)\n3. large coffee (3.50 CHF) \n4. Bacon Roll (4.50 CHF) " +
                "\n5. orange juice (3.95 CHF) \n6. Extra milk (0.30 CHF) \n7. Foamed milk (0.50 CHF) " +
                "\n8. roast coffee (0.90 CHF) \n9. Done \n10. exit");
    }

    public static double ItemPrice(int foodItem) {
        if (foodItem == 1) {
            // small coffee= 2.50 CHF
            System.out.println("You've ordered a small coffee");
            itemPrice = 2.50;
        }
        if (foodItem == 2) {
            // medium coffee = 3.00 CHF
            System.out.println("You've ordered medium coffee");
            itemPrice = 3.00;
        }
        if (foodItem == 3) {
            // large coffee = 3.50 CHF
            System.out.println("You've ordered a large coffee");
            itemPrice = 3.50;
        }
        if (foodItem == 4) {
            // Bacon Roll = 4.50 CHF
            System.out.println("You've ordered a Bacon Roll");
            itemPrice = 4.50;
        }
        if (foodItem == 5) {
            // orange juice = 3.95 CHF
            System.out.println("You've ordered a orange juice");
            itemPrice = 3.95;
        }
        if (foodItem == 6) {
            // Extra milk = 0.30 CHF
            System.out.println("You've ordered a Extra milk");
            itemPrice = 0.30;
        }
        if (foodItem == 7) {
            // Foamed milk = 0.50 CHF
            System.out.println("You've ordered a Foamed milk");
            itemPrice = 0.50;
        }
        if (foodItem == 8) {
            // roast coffee = 0.90 CHF
            System.out.println("You've ordered a roast coffee");
            itemPrice = 0.90;
        }
        quantity();
        return j;
    }

    public static double quantity() {
        System.out.println("Enter quantity");
        double quantity = input.nextDouble();
        subTotal(quantity, itemPrice);
        return quantity;
    }

    public static double subTotal(double quantity, double itemPrice) {
        double subTotal = quantity * itemPrice;
        System.out.println("Subtotal: " + subTotal + " CHF");
        j = subTotal;
        return subTotal;
    }

    public static void done(double runningTotal) {
        System.out.println("Total amount: " + runningTotal + " CHF");
        System.out.println("Enjoy your meal");
        StartApplication.runningTotal = 0;
    }
}
