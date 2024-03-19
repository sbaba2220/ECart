package Products;

public class Clothing extends Product{
    public Clothing(String name, String description, double price) {
        super(name, description, price, ProductCategory.CLOTHING);
    }
}
