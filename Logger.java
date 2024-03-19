import Order.Cart;
import Products.Product;
import User.User;

import java.io.*;

public class Logger {
    private static final String recieptFile = "logOrder.txt";
    public void logEvent(String event) {
        System.out.println("Event logged " + event);
    }
    public void logOrder(Cart cart) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(recieptFile, true))) {
            writer.write("Customer Name (Username) : "+cart.getCustomerName());
            writer.write("Customer Address: "+cart.getCustomerAddress());
            writer.write("\n");
            for (Product item : cart.getProductsList()) {
                writer.write(item.getProductName() + ", " + item.getProductDescription() + ", " + item.getProductPrice());
                writer.newLine();
            }
        } catch (IOException e) {
            System.err.println("Error writing ordered items to file: " + e.getMessage());
        }
    }
}
