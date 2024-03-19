import Order.Cart;
import Order.CartBuilder;
import Order.OrderProcessor;
import Order.PaymentProcessor;
import Products.Clothing;
import Products.Electronics;
import Products.Product;
import Products.ProductCatalog;
import User.UserAuthentication;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Welcome to e-cart application!");
        Scanner scanner = new Scanner(System.in);
        UserAuthentication userAuth = new UserAuthentication();
        ProductCatalog productCatalog = new ProductCatalog();
        Cart cart = Cart.getInstance();
        OrderProcessor orderProcessor = new OrderProcessor(cart);
        Logger logger = new Logger();
        String loginUsername = "";
        PaymentProcessor paymentProcessor = new PaymentProcessor();

        System.out.println("Welcome to the Shopping App!");
        System.out.println("Are you an existing user? (YES/no)");
        String isExistingUser = scanner.nextLine();
        if(isExistingUser.equalsIgnoreCase("yes")) {
            loginUsername = LoginProcess(scanner, userAuth);
            if(loginUsername==null) {
                System.exit(0);
            }
        } else {
            if(!RegisterProcess(scanner, userAuth)) {
                System.exit(0);
            }
        }
        logger.logEvent("User logged in: " + loginUsername);
        System.out.println("Available Products:");
        productCatalog.showProducts();

        CartBuilder cartBuilder = new CartBuilder();

        System.out.println("Add products to the cart (enter product name to add, 'done' to finish):");
        String input;
        while (!(input = scanner.nextLine()).equals("done")) {
            Product product = productCatalog.getProductByName(input);
            if (product != null) {
                cartBuilder = cartBuilder.addItem(product);
                System.out.println(input + " added to cart.");
            } else {
                System.out.println("Product not found.");
            }
        }
        System.out.println("Enter the address");
        String customerAddress = scanner.nextLine();
        cartBuilder = cartBuilder.setCustomerName(loginUsername);
        cartBuilder = cartBuilder.setCustomerAddress(customerAddress);
        cart = cartBuilder.build();

        System.out.println("Cart Contents:");
        cart.showCartItems();

        double totalAmount = cart.calculateTotal();

        System.out.println("Place order? (yes/no):");
        String placeOrderInput = scanner.nextLine();
        if (placeOrderInput.equals("yes")) {
            System.out.println("Simulating payment processing...");
            paymentProcessor.processPayment(totalAmount);
            orderProcessor.placeOrder();
            System.out.println("Order placed successfully!");
        } else {
            System.out.println("Order not placed.");
        }

        logger.logEvent("Order placed by: " + loginUsername);
        logger.logOrder(cart);
    }
    public static String LoginProcess(Scanner scanner, UserAuthentication userAuth) {
        System.out.println("Login (case sensitive):");
        System.out.print("Enter username: ");
        String loginUsername = scanner.nextLine();
        System.out.print("Enter password: ");
        String loginPassword = scanner.nextLine();
        if (userAuth.validateUser(loginUsername, loginPassword)) {
            System.out.println("Login successful!");
            return loginUsername;
        } else {
            System.out.println("Invalid username or password. Exiting...");
            return null;
        }
    }
    public static boolean RegisterProcess(Scanner scanner, UserAuthentication userAuth) {
        System.out.println("Register a new user (case sensitive):");
        System.out.print("Enter username: ");
        String username = scanner.nextLine();
        System.out.print("Enter password: ");
        String password = scanner.nextLine();
        return userAuth.registerAUser(username, password);
    }
}
