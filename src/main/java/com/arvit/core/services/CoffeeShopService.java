package com.arvit.core.services;

import com.arvit.core.domain.Customer;
import com.arvit.core.domain.Product;
import com.arvit.core.domain.Receipt;

import java.util.List;

public interface CoffeeShopService {

    Receipt get(List<Product> list, Customer customer);

}
