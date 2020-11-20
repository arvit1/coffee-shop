package com.cognizant.core.domain;
import lombok.Getter;
import lombok.Setter;


@Getter @Setter
public class Item {
    String id;
    String idProduct;
    String description;
    Double price;
    String currency;
    String typeProduct;


    public String toString() { return "" + description + ", " + price+ ", " + currency + ""  +"\n"; }

}
