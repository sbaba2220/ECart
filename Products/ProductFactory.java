package Products;

public class ProductFactory {
    public static Product createProduct(String type, String name, String description, double price) {
        if(type.equalsIgnoreCase("Electronics")) {
            return new Electronics(name, description, price);
        } else if(type.equalsIgnoreCase("Clothing")) {
            return new Clothing(name, description, price);
        } else {
            System.out.println("Invalid product type: "+type);
        }
        return null;
    }
}
