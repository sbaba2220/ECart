package Products;

public class Electronics extends Product{
    public Electronics(String name, String description, double price) {
        super(name, description, price, ProductCategory.ELECTRONICS);
    }
}
