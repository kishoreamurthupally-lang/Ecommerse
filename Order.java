package model;

import java.util.*;

public class Order {
    private int orderId;
    private List<CartItem> items;
    private double total;
    private String status;

    public Order(int orderId, List<CartItem> items, double total) {
        this.orderId = orderId;
        this.items = items;
        this.total = total;
        this.status = "CREATED";
    }

    public int getOrderId() { return orderId; }
    public double getTotal() { return total; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    @Override
    public String toString() {
        return "Order#" + orderId + " | ₹" + total + " | Status: " + status;
    }
}