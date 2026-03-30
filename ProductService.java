package services;

import java.util.HashMap;
import java.util.Map;

import model.Product;

public class ProductService {
    private Map<Integer, Product> products = new HashMap<>();

    public void addProduct(Product product) {
        if (products.containsKey(product.getId())) {
            System.out.println("Product ID already exists!");
            return;
        }
        products.put(product.getId(), product);
    }

    public Product getProduct(int id) {
        return products.get(id);
    }

    public void viewProducts() {
        for (Product p : products.values()) {
            System.out.println(p);
        }
    }
}