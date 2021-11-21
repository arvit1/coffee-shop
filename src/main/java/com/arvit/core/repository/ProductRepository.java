package com.arvit.core.repository;

import com.arvit.core.domain.Product;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class ProductRepository {
    private static List<Product> products = new CopyOnWriteArrayList<>();
    public static int id = 1;
    static {
        Product p1 = new Product(id++,"small coffee", 2.50,"CHF","B");
        Product p2 = new Product(id++,"medium coffee", 3.00,"CHF","B");
        Product p3 = new Product(id++,"large coffee", 3.50,"CHF","B");
        Product p4 = new Product(id++,"Bacon Roll", 4.50,"CHF","S");
        Product p5 = new Product(id++, "Extra milk", 0.30,"CHF","E");
        Product p6 = new Product(id++, "Foamed milk", 0.50,"CHF","E");
        Product p7 = new Product(id++, "Special roast", 0.90,"CHF","E");
        products.add(p1);
        products.add(p2);
        products.add(p3);
        products.add(p4);
        products.add(p5);
        products.add(p6);
        products.add(p7);
    }
    public ProductRepository() { }

    public List<Product> getAll(){
        return products;
    }

    public void create(Product Product){
        products.add(Product);
    }

    public Product find(int id) {
        int byId = this.findById(id);
        if (byId != -1){
            return products.get(byId);
        }
        return null;
    }

    public void update(Product Product) {
        int byId = this.findById(Product.getId());
        if (byId != -1){
            products.set(byId, Product);
        }
    }

    public void delete(int id){
        Product Product = this.find(id);
        if (Product != null){
            products.remove(Product);
        }
    }

    public int findById(int id) {
        for (int i = 0; i < products.size(); i++) {
            if (products.get(i).getId() == id){
                return i;
            }
        }
        return -1;
    }
}
