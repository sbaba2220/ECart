package Products;

import java.util.ArrayList;
import java.util.List;

public class ProductCatalog {
    private List<Product> products;

    public ProductCatalog() {
        this.products = new ArrayList<>();
    }

    public void addProduct(Product product) {
        this.products.add(product);
    }

    public void showProducts() {
        for (Product product : products) {
            System.out.println("Product: " + product.getProductName() + " - $" + product.getProductPrice());
        }
    }
}
