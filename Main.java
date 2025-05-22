import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Path folderPath = Paths.get("dataSamples");
        boolean running = true;
        Scanner scanner = new Scanner(System.in);

        while (running) {
            System.out.println("Please choose a feature to access it:");
            System.out.println("1. Daily Shopping Basket Monitoring");
            System.out.println("2. Best Discounts");
            System.out.println("3. Feature Three - Not Available");
            System.out.println("4. Feature Four - Not Available");
            System.out.println("5. Feature Five - Not Available");
            System.out.println("0. Exit");

            System.out.print("Enter the number of the feature you want to access (1-5): ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("You selected Daily Shopping Basket Monitoring.");
                    DoOnShoppingBasket.printBestOffersForUser(folderPath);
                    break;
                case 2:
                    System.out.println("You selected Best Discounts.");
                    DoOnDiscounts.printBestDiscount(folderPath);
                    break;
                case 3:
                    System.out.println("You selected Feature Three - Not Available.");
                    break;
                case 4:
                    System.out.println("You selected Feature Four - Not Available.");
                    break;
                case 5:
                    System.out.println("You selected Feature Five - Not Available.");
                    break;
                case 0:
                    System.out.println("Thank you for using this program. Goodbye!");
                    running = false;
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a number between 1 and 5.");
            }
            if (running) {
                System.out.println("\nPress Enter to return to the main menu...");
                scanner.nextLine(); // Consume newline left-over
                scanner.nextLine(); // Wait for user to press Enter
            }
        }

        scanner.close();

    }

}