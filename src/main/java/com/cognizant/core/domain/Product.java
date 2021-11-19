package com.cognizant.core.domain;

public class Product {
    String id;
    String description;
    Double price;
    String currency;
    String typeProduct;

    public Product() { }

    public Product(String id, String description, Double price, String currency, String typeProduct) {
        this.id = id;
        this.description = description;
        this.price = price;
        this.currency = currency;
        this.typeProduct = typeProduct;
    }

    public String getId() { return id; }

    public void setId(String id) { this.id = id; }

    public String getDescription() { return description; }

    public void setDescription(String description) { this.description = description; }

    public Double getPrice() { return price; }

    public void setPrice(Double price) { this.price = price; }

    public String getCurrency() { return currency; }

    public void setCurrency(String currency) { this.currency = currency; }

    public String getTypeProduct() { return typeProduct; }

    public void setTypeProduct(String typeProduct) { this.typeProduct = typeProduct; }
}
