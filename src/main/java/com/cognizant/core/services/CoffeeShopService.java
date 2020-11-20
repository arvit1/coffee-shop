package com.cognizant.core.services;

import com.cognizant.core.domain.Product;
import com.cognizant.core.domain.Receipt;

import java.util.List;

public interface CoffeeShopService {

    Receipt get(List<Product> list);

}
