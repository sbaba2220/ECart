package Products;

public class Product {
    private String name;
    private String description;
    private double price;
    public Product(String name, String description, double price) {
        this.name = name;
        this.description = description;
        this.price = price;
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
}
