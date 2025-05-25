package utils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import store.Product;
import store.Discount;

public class CSVReader {
    public static String readCurrentStoresName(String[] folderNameStrings) {
        String CurrentFileStoreName = folderNameStrings[0];

        return CurrentFileStoreName;
    }

    public static List<Product> GetProductsFromFile(String fileName) {
        // List to store our data
        List<Product> storeData = new ArrayList<>();

        if (fileName.contains("discounts")) {
            return storeData;
        }

        // Path to our CSV file
        String csvFile = "data\\" + fileName;

        // Get store name from File
        String storeName = readCurrentStoresName(fileName.split("_"));

        // Try-with-resources to ensure the reader gets closed automatically
        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
            String line;
            String[] productKeys = br.readLine().split(";");
            // Read each line from the file
            while ((line = br.readLine()) != null) {
                // Split the line by comma and convert to a List
                String[] productValues = line.split(";");
                // System.out.println(productValues[3] + fileName);

                Product product = new Product(productValues, storeName);

                // Add the line data to our main list
                storeData.add(product);
            }
        } catch (IOException e) {
            System.err.println("Error reading the CSV file: " + e.getMessage());
            e.printStackTrace();
        }
        return storeData;
    }

    public static List<Discount> GetDiscountsFromFile(String fileName) {

        // Path to our CSV file
        String csvFile = "data\\" + fileName;

        // List to store our data
        List<Discount> storeDiscounts = new ArrayList<>();

        // Get store name from File
        String storeName = readCurrentStoresName(fileName.split("_"));

        // Try-with-resources to ensure the reader gets closed automatically
        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
            String line;
            String[] discountKeys = br.readLine().split(";");
            // Read each line from the file
            while ((line = br.readLine()) != null) {
                // Split the line by comma and convert to a List
                String[] discountValues = line.split(";");
                Discount discount = new Discount(discountValues, storeName);

                // Add the line data to our main list
                storeDiscounts.add(discount);
            }
        } catch (IOException e) {
            System.err.println("Error reading the CSV file: " + e.getMessage());
            e.printStackTrace();
        }
        return storeDiscounts;
    }
}