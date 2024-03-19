package Order;

import Products.Product;

import java.util.List;

public class OrderProcessor {
    private Cart cart;
    public OrderProcessor(Cart cart) {
        this.cart = cart;
    }
    public void placeOrder() {
        this.cart = null;
    }
}