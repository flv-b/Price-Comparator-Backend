import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import store.Product;

public class CSVReaderDemo {
    public static List<Product> GetProductsFromFile(String fileName) {

        // Path to our CSV file
        String csvFile = "dataSamples\\" + fileName;

        // List to store our data
        List<Product> storeData = new ArrayList<>();

        // Try-with-resources to ensure the reader gets closed automatically
        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
            String line;
            String[] productKeys = br.readLine().split(";");
            // Read each line from the file
            while ((line = br.readLine()) != null) {
                // Split the line by comma and convert to a List
                String[] productValues = line.split(";");
                Product product = new Product(productValues);

                // Add the line data to our main list
                storeData.add(product);
            }
        } catch (IOException e) {
            System.err.println("Error reading the CSV file: " + e.getMessage());
            e.printStackTrace();
        }
        return storeData;
    }
}