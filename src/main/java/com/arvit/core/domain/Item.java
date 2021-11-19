package com.arvit.core.domain;

public class Item {
    String id;
    String idProduct;
    String description;
    Double price;
    String currency;
    String typeProduct;

    public String getId() { return id; }

    public void setId(String id) { this.id = id; }

    public String getIdProduct() { return idProduct; }

    public void setIdProduct(String idProduct) { this.idProduct = idProduct; }

    public String getDescription() { return description; }

    public void setDescription(String description) { this.description = description; }

    public Double getPrice() { return price; }

    public void setPrice(Double price) { this.price = price; }

    public String getCurrency() { return currency; }

    public void setCurrency(String currency) { this.currency = currency; }

    public String getTypeProduct() { return typeProduct; }

    public void setTypeProduct(String typeProduct) { this.typeProduct = typeProduct; }

    public String toString() { return "" + description + ", " + price+ ", " + currency + ""  +"\n"; }

}
