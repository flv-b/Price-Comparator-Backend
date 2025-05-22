import java.io.IOException;
import java.nio.file.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import store.Discount;
import store.Product;

public class ReadFilesFromFolderNIO {

    public static List<String> getValidFilesFromFolder(Path folderPath) {
        List<String> absolutePaths = new ArrayList<String>();

        try (Stream<Path> paths = Files.list(folderPath)) {
            paths.filter(Files::isRegularFile).forEach(path -> absolutePaths.add(path.getFileName().toString()));
        } catch (IOException e) {
            System.err.println("Error reading files: " + e.getMessage());
        }
        return absolutePaths;
    }

    public static List<String> readStoresNameFrom(Path folderPath) {
        List<String> storeNames = new ArrayList<>();
        List<String> validFiles = getValidFilesFromFolder(folderPath);

        validFiles
                .forEach(path -> {
                    String[] fileNameStrings = path.split("_");
                    if (!storeNames.contains(fileNameStrings[0]))
                        storeNames.add(fileNameStrings[0]);
                });

        return storeNames;
    }

    public static List<Discount> readDiscountsFromFolder(Path folderPath) {
        List<Discount> storeDiscounts = new ArrayList<>();

        List<String> validFiles = getValidFilesFromFolder(folderPath);

        validFiles.forEach(path -> {

            if (path.contains("discounts")) {
                List<Discount> discounts = CSVReader.GetDiscountsFromFile(path);
                storeDiscounts.addAll(discounts);
            }
        });

        return storeDiscounts;
    }

    public static List<Product> readProductsFromFolder(Path folderPath) {
        List<Product> storeProducts = new ArrayList<>();

        List<String> validFiles = getValidFilesFromFolder(folderPath);

        validFiles.forEach(path -> {
            if (!(path.contains("discounts"))) {
                System.out.println(path);
                List<Product> products = CSVReader.GetProductsFromFile(path);
                storeProducts.addAll(products);
            }
        });

        return storeProducts;
    }
}
