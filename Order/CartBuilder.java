package Order;

import Products.Product;

public class CartBuilder {
    private Cart cart;
    private String customerName;
    private String customerAddress;
    public CartBuilder() {
        this.cart = Cart.getInstance();
    }
    public CartBuilder addItem(Product product) {
        cart.addItem(product);
        return this;
    }
    public CartBuilder removeItem(Product product) {
        cart.removeItem(product);
        return this;
    }
    public CartBuilder setCustomerName(String customerName) {
        this.customerName = customerName;
        return this;
    }

    public CartBuilder setCustomerAddress(String customerAddress) {
        this.customerAddress = customerAddress;
        return this;
    }

    public Cart build() {
        if (customerName != null) {
            cart.setCustomerName(customerName);
        }
        if (customerAddress != null) {
            cart.setCustomerAddress(customerAddress);
        }
        return cart;
    }
}
