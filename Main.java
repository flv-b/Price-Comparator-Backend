import java.util.List;
import store.Product;

public class Main {
    public static void main(String[] args) {

        List<Product> storeData = CSVReaderDemo.GetProductsFromFile("kaufland_2025-05-01.csv");

        for (Product product : storeData) {
            System.out.println(product.getName());
        }

    }
}