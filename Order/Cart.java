package Order;

import Products.Product;

import java.util.ArrayList;
import java.util.List;

public class Cart {
    private static Cart instance;
    private String customerName;
    private String customerAddress;
    private List<Product> productsList;

    private Cart() {
        this.productsList = new ArrayList<>();
    }

    public static Cart getInstance() {
        if(instance==null) {
            instance = new Cart();
        }
        return instance;
    }
    public void addItem(Product product) {
        this.productsList.add(product);
    }
    public void removeItem(Product product) {
        this.productsList.remove(product);
    }
    public void showCartItems() {
        for (Product p :
                productsList) {
            p.showProductInformation();
        }
    }
    public List<Product> getProductsList() {
        return productsList;
    }

    public double calculateTotal() {
        double totalCost = 0;
        for (Product p :
                productsList) {
            totalCost += p.getProductPrice();
        }
        return totalCost;
    }
    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }
    public void setCustomerAddress(String customerAddress) {
        this.customerAddress = customerAddress;
    }
    public String getCustomerName() {
        return this.customerName;
    }
    public String getCustomerAddress() {
        return this.customerAddress;
    }
}
