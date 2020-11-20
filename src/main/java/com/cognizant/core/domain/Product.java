package com.cognizant.core.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter @AllArgsConstructor @ToString
public class Product {
    String id;
    String description;
    Double price;
    String currency;
    String typeProduct;

}
