package services;

import java.util.*;

import model.Cart;
import model.CartItem;
import model.Order;

public class OrderService {

    private List<Order> orders = new ArrayList<>();
    private int orderCounter = 1;

    public Order placeOrder(Cart cart, PaymentService paymentService) {

        if (cart.isEmpty()) {
            System.out.println("Cart is empty!");
            return null;
        }

        double total = cart.getTotal();
        List<CartItem> items = new ArrayList<>(cart.getItems());

        Order order = new Order(orderCounter++, items, total);

        boolean paymentSuccess = paymentService.processPayment();

        if (!paymentSuccess) {
            System.out.println("Payment Failed! Rolling back...");
            for (CartItem item : items) {
                item.getProduct().increaseStock(item.getQuantity());
            }
            order.setStatus("FAILED");
            return order;
        }

        order.setStatus("PAID");
        orders.add(order);
        return order;
    }

    public void viewOrders() {
        for (Order o : orders) {
            System.out.println(o);
        }
    }
}