package Products;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ProductCatalog {
    private List<Product> products;
    private static final String productsFile = "products.txt";
    public ProductCatalog() {
        this.products = new ArrayList<>();
        this.loadProductsFromFile();
    }

    public void addProduct(Product product) {
        this.products.add(product);
    }

    public void showProducts() {
        for (Product product : products) {
            System.out.println("Product: " + product.getProductName() + " - $" + product.getProductPrice());
        }
    }
    private void loadProductsFromFile() {
        try (BufferedReader reader = new BufferedReader(new FileReader(productsFile))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 4) {
                    String name = parts[0].trim();
                    String description = parts[1].trim();
                    double price = Double.parseDouble(parts[2].trim());
                    String type = parts[3].trim();
                    Product product = ProductFactory.createProduct(type, name, description, price);
                    this.products.add(product);
                }
            }
        } catch (IOException | NumberFormatException e) {
            System.err.println("Error loading products from file: " + e.getMessage());
        }
    }
    public Product getProductByName(String name) {
        for (Product product :
                products) {
            if (product.getProductName().equalsIgnoreCase(name)) {
                return product;
            }
        }
        System.out.println("No product found with the given name");
        return null;
    }
}
