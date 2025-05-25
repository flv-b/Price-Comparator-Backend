package features;

import utils.CSVReader;
import utils.ReadFilesFromFolderNIO;

import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import model.Product;

public class DoOnShoppingBasket {

    public static List<String> getUserShoppingBasketList() {
        System.out.println("Enter your shopping list items, separated by commas:");
        System.out.print("For example: lapte, oua, iaurt\n> ");
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        List<String> shoppingList = Arrays.asList(input.split("\\s*,\\s*"));
        return shoppingList;
    }

    public static List<Product> getBestOffersForUser(List<String> shoppingList, Path folderPath) {
        List<String> validFiles = ReadFilesFromFolderNIO.getValidFilesFromFolder(folderPath);
        List<Product> productsAvailableList = new ArrayList<>();
        validFiles
                .forEach(path -> {
                    List<Product> fileProducts = CSVReader.GetProductsFromFile(path);
                    productsAvailableList.addAll(fileProducts);
                });

        List<Product> bestOffersAcrossStores = new ArrayList<>();
        Product bestOffer = null;

        for (String item : shoppingList) {
            for (Product product : productsAvailableList) {
                if (product.compareProductName(item)
                        && (bestOffer == null || product.getPrice() < bestOffer.getPrice())) {
                    bestOffer = product;
                }
            }
            bestOffersAcrossStores.add(bestOffer);
            bestOffer = null;
        }
        return bestOffersAcrossStores;
    }

    public static void printBestOffersForUser(Path folderPath) {
        List<String> userShoppingList = DoOnShoppingBasket.getUserShoppingBasketList();
        List<Product> bestOffersAcrossStores = DoOnShoppingBasket.getBestOffersForUser(userShoppingList, folderPath);
        for (Product product : bestOffersAcrossStores) {
            if (product == null) {
                System.out.println("Product not found!");
            } else {
                System.out.println("Best offer for " + product.getName() + " is of " + product.getPrice()
                        + product.getCurrency() + " at " + product.getStoreName());
            }
        }
    }
}