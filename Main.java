package services;



import model.Cart;
import model.Order;
import model.Product;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        ProductService productService = new ProductService();
        CartService cartService = new CartService();
        OrderService orderService = new OrderService();
        PaymentService paymentService = new PaymentService();

        String user = "user1"; // simple user simulation

        while (true) {

            System.out.println("\n===== CLI MENU =====");
            System.out.println("1. Add Product");
            System.out.println("2. View Products");
            System.out.println("3. Add to Cart");
            System.out.println("4. Remove from Cart");
            System.out.println("5. View Cart");
            System.out.println("6. Apply Coupon");
            System.out.println("7. Place Order");
            System.out.println("8. Cancel Order");
            System.out.println("9. View Orders");
            System.out.println("10. Low Stock Alert");
            System.out.println("11. Return Product");
            System.out.println("12. Simulate Concurrent Users");
            System.out.println("13. View Logs");
            System.out.println("14. Trigger Failure Mode");
            System.out.println("0. Exit");

            System.out.print("Enter choice: ");
            int choice = sc.nextInt();

            switch (choice) {

                case 1:
                    System.out.print("ID: ");
                    int id = sc.nextInt();
                    System.out.print("Name: ");
                    String name = sc.next();
                    System.out.print("Price: ");
                    double price = sc.nextDouble();
                    System.out.print("Stock: ");
                    int stock = sc.nextInt();

                    productService.addProduct(new Product(id, name, price, stock));
                    break;

                case 2:
                    productService.viewProducts();
                    break;

                case 3:
                    System.out.print("Product ID: ");
                    Product p = productService.getProduct(sc.nextInt());

                    if (p != null) {
                        System.out.print("Quantity: ");
                        int qty = sc.nextInt();
                        cartService.addToCart(user, p, qty);
                    }
                    break;

                case 4:
                    System.out.print("Enter Product ID to remove: ");
                    int removeId = sc.nextInt();
                    cartService.getCart(user).removeItem(removeId);
                    System.out.println("Item removed from cart.");
                    break;

                case 5:
                    cartService.viewCart(user);
                    break;

                case 6:
                    System.out.println("Apply Coupon (Feature coming soon)");
                    break;

                case 7:
                    Cart cart = cartService.getCart(user);
                    Order order = orderService.placeOrder(cart, paymentService);

                    if (order != null) {
                        System.out.println(order);
                        cart.clear();
                    }
                    break;

                case 8:
                    System.out.println("Cancel Order (Feature coming soon)");
                    break;

                case 9:
                    orderService.viewOrders();
                    break;

                case 10:
                    System.out.println("Low Stock Alert (Feature coming soon)");
                    break;

                case 11:
                    System.out.println("Return Product (Feature coming soon)");
                    break;

                case 12:
                    System.out.println("Simulating concurrent users...");
                    System.out.println("(Will implement with threads later)");
                    break;

                case 13:
                    System.out.println("Logs (Feature coming soon)");
                    break;

                case 14:
                    System.out.println("Failure Mode Triggered (Demo)");
                    break;

                case 0:
                    System.out.println("Exiting...");
                    return;

                default:
                    System.out.println("Invalid choice!");
            }
        }
    }
}