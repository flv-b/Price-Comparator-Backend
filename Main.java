import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import store.Discount;
import store.Product;

public class Main {
    public static void main(String[] args) {

        Path folderPath = Paths.get("dataSamples");
        List<String> myStores = ReadFilesFromFolderNIO.readStoresNameFrom(folderPath);    
        // List<Product> products = new ArrayList<>();
        // List<Discount> discounts = new ArrayList<>();
        
        // for (String store : myStores) {
        //     discounts = ReadFilesFromFolderNIO.readDiscountsFromFolder(folderPath);
        //     // products = ReadFilesFromFolderNIO.readProductsFromFolder(folderPath, store);
        // }   
        
        List<Discount> discounts = DoOnDiscounts.getBestDiscountsAcrossStores(folderPath);
        
        for (Discount discount : discounts){
            System.out.println("Best Discount at " + discount.getStoreName() + " is of " + discount.getPercentageOfDiscount() + "% for " + discount.getName());
        }

    }

}