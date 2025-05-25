package features;
import utils.CSVReader;
import utils.ReadFilesFromFolderNIO;

import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

import model.Discount;

public class DoOnDiscounts {

    public static List<Discount> getDiscountsForStoreName(List<String> validFiles, String storeName) {
        List<Discount> discounts = new ArrayList<>();
        validFiles
                .forEach(path -> {
                    if (path.startsWith(storeName + "_discounts")) {
                        List<Discount> fileDiscounts = CSVReader.GetDiscountsFromFile(path);
                        discounts.addAll(fileDiscounts);
                    }
                });
        return discounts;
    }

    public static List<Discount> getBestDiscountsAcrossStores(Path folderPath) {
        List<String> storeNames = ReadFilesFromFolderNIO.readStoresNameFrom(folderPath);
        List<String> validFiles = ReadFilesFromFolderNIO.getValidFilesFromFolder(folderPath);
        List<Discount> bestDiscountAcrossStores = new ArrayList<>();
        Discount bestDiscount = null;

        for (String store : storeNames) {
            List<Discount> thiStoreDiscounts = getDiscountsForStoreName(validFiles, store);
            for (Discount discount : thiStoreDiscounts) {
                if (bestDiscount == null || discount.getPercentageOfDiscount() > bestDiscount.getPercentageOfDiscount())
                    bestDiscount = discount;
            }
            bestDiscountAcrossStores.add(bestDiscount);
            bestDiscount = null;
        }
        return bestDiscountAcrossStores;
    }

    public static void printBestDiscount(Path folderPath) {
        List<Discount> discounts = DoOnDiscounts.getBestDiscountsAcrossStores(folderPath);
        for (Discount discount : discounts) {
            System.out.println("Best Discount at " + discount.getStoreName() + " is of "
                    + discount.getPercentageOfDiscount() + "% for " + discount.getName());
        }
    }

}