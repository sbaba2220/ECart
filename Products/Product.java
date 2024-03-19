package Products;

public class Product {
    private String name;
    private String description;
    private double price;
    private ProductCategory productCategory;

    public Product(String name, String description, double price, ProductCategory category) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.productCategory = category;
    }

    public void setProductName(String name) {
        this.name = name;
    }

    public void setProductDescription(String description) {
        this.description = description;
    }

    public void setProductPrice(double price) {
        this.price = price;
    }

    public String getProductName() {
        return this.name;
    }

    public String getProductDescription() {
        return this.description;
    }

    public double getProductPrice() {
        return this.price;
    }

    public void showProductInformation() {
        System.out.println("Product Information");
        System.out.println("Name: " + this.name);
        System.out.println("Description: " + this.description);
        System.out.println("Price: " + this.price);
        System.out.println("Category: " + this.productCategory);
    }
}
