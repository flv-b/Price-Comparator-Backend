package store;

public class Product {
    // Instance Variables
    String product_id;
    String product_name;
    String product_category;
    String brand;
    float package_quantity;
    String package_unit;
    float price;
    String currency;

    // Constructor Declaration of Class
    public Product(String[] productValues)
    {
        this.product_id = productValues[0];
        this.product_name = productValues[1];
        this.product_category = productValues[2];
        this.brand = productValues[3];
        this.package_quantity = Float.valueOf(productValues[4]);
        this.package_unit = productValues[5];
        this.price = Float.valueOf(productValues[6]);
        this.currency = productValues[7];
    }

    public String getId() { 
      return product_id; 
    }

    public String getName() { 
      return product_name; 
    }

    public String getBrand() { 
      return brand; 
    }

    public Float getPrice() { 
      return price; 
    }
}