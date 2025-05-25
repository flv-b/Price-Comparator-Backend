package model;

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

    String storeName;

    // Constructor Declaration of Class
    public Product(String[] productValues, String storeName)
    {
        this.product_id = productValues[0];
        this.product_name = productValues[1];
        this.product_category = productValues[2];
        this.brand = productValues[3];
        this.package_quantity = Float.valueOf(productValues[4]);
        this.package_quantity = Float.parseFloat(productValues[4]);
        this.package_unit = productValues[5];
        this.price = Float.valueOf(productValues[6]);
        this.currency = productValues[7];
        
        this.storeName = storeName;

    }

    public String getId() { 
      return product_id; 
    }

    public String getName() { 
      return product_name; 
    }

    public String getCategory() { 
      return product_category; 
    }

    public String getBrand() { 
      return brand; 
    }

    public Float getPackageQuantity() { 
      return package_quantity; 
    }

    public String getPackageUnit() { 
      return package_unit; 
    }

    public Float getPrice() { 
      return price; 
    }

    public String getCurrency() { 
      return currency; 
    }

    public String getStoreName() {
        return storeName;
    }

    private String removeDiacritics(String word){
      return word.replace('ă','a').replace('â','a').replace('î','i')
                .replace('ș','s').replace('ş','s').replace('ț','t').replace('ţ','t')
                .replace('Ă','A').replace('Â','A').replace('Î','I')
                .replace('Ș','S').replace('Ş','S').replace('Ț','T').replace('Ţ','T');
    }
    public boolean compareProductName(String nameToCompare){
      return removeDiacritics(product_name).contains( removeDiacritics(nameToCompare));
    }
    
}