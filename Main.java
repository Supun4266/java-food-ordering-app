import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        Food[] menu = {
            new Food("Burger", 500),
            new Food("Pizza", 800),
            new Food("Fried Rice", 650),
            new Food("Fries", 300),
            new Food("Ice Cream", 250)
        };

        int total = 0;
        boolean ordering = true;

        System.out.println("=== Welcome to QuickBite ===");

        while (ordering) {
            // Show the menu
            System.out.println();
            System.out.println("--- Menu ---");
            for (int i = 0; i < menu.length; i++) {
                System.out.println((i + 1) + ". " + menu[i].name + " - " + menu[i].price);
            }
            System.out.println("0. Finish order");

            // Ask the customer
            System.out.print("Choose a food number: ");
            int choice = scanner.nextInt();

            if (choice == 0) {
                ordering = false;
            } else if (choice >= 1 && choice <= menu.length) {
                System.out.print("How many? ");
                int quantity = scanner.nextInt();

                Food food = menu[choice - 1];
                int cost = food.priceFor(quantity);
                total += cost;

                System.out.println("Added " + quantity + " x " + food.name + " = " + cost);
            } else {
                System.out.println("Sorry, that number is not on the menu.");
            }
        }

        // Print the bill
        System.out.println();
        System.out.println("=== Your Bill ===");
        System.out.println("Subtotal: " + total);

        if (total > 2000) {
            total -= 200;
            System.out.println("Big order discount: -200");
        }

        System.out.println("Please pay: " + total);
        System.out.println("Thank you for ordering!");

        scanner.close();
    }
}