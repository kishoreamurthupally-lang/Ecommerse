package model;

import java.util.*;

public class Cart {
    private Map<Integer, CartItem> items = new HashMap<>();

    public void addItem(Product product, int qty) {
        if (items.containsKey(product.getId())) {
            CartItem item = items.get(product.getId());
            item.setQuantity(item.getQuantity() + qty);
        } else {
            items.put(product.getId(), new CartItem(product, qty));
        }
    }

    public void removeItem(int productId) {
        items.remove(productId);
    }

    public Collection<CartItem> getItems() {
        return items.values();
    }

    public double getTotal() {
        double total = 0;
        for (CartItem item : items.values()) {
            total += item.getTotal();
        }
        return total;
    }

    public void clear() {
        items.clear();
    }

    public boolean isEmpty() {
        return items.isEmpty();
    }
}