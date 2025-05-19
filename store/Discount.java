package store;

public class Discount {
    String product_id;
    String product_name;
    String brand;
    float package_quantity;
    String package_unit;
    String product_category;
    String from_date;
    String to_date;
    int percentage_of_discount;

    String storeName;

    // Constructor Declaration of Class
    public Discount(String[] discountValues, String storeName) {
        this.product_id = discountValues[0];
        this.product_name = discountValues[1];
        this.brand = discountValues[2];
        this.package_quantity = Float.valueOf(discountValues[3]);
        this.package_unit = discountValues[4];
        this.product_category = discountValues[5];
        this.from_date = discountValues[6];
        this.to_date = discountValues[7];
        this.percentage_of_discount = Integer.valueOf(discountValues[8]);

        this.storeName = storeName;

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

    public Float getPackageQuantity() {
        return package_quantity;
    }

    public String getPackageUnit() {
        return package_unit;
    }

    public String getProductCategory() {
        return product_category;
    }

    public String getFromDate() {
        return from_date;
    }

    public String getToDate() {
        return to_date;
    }

    public int getPercentageOfDiscount() {
        return percentage_of_discount;
    }

    public String getStoreName() {
        return storeName;
    }

}
