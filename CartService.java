package services;


import java.util.*;

import model.Cart;
import model.CartItem;
import model.Product;

public class CartService {
    private Map<String, Cart> userCarts = new HashMap<>();

    public Cart getCart(String user) {
        return userCarts.computeIfAbsent(user, k -> new Cart());
    }

    public void addToCart(String user, Product product, int qty) {
        if (product.getStock() < qty) {
            System.out.println("Not enough stock!");
            return;
        }

        product.reduceStock(qty); // reserve stock
        getCart(user).addItem(product, qty);
    }

    public void viewCart(String user) {
        Cart cart = getCart(user);
        for (CartItem item : cart.getItems()) {
            System.out.println(item.getProduct().getName() + " x " + item.getQuantity());
        }
        System.out.println("Total: ₹" + cart.getTotal());
    }

    public Cart clearCart(String user) {
        Cart cart = getCart(user);
        userCarts.put(user, new Cart());
        return cart;
    }
}