package com.arvit.core.services;

import com.arvit.core.domain.Customer;
import com.arvit.core.domain.Product;
import com.arvit.core.domain.Receipt;
import com.arvit.core.repository.CustomerRepository;
import com.arvit.core.repository.ProductRepository;
import org.junit.Assert;
import org.junit.Test;
import java.util.ArrayList;
import java.util.List;

public class CoffeeShopServiceTest {

    CoffeeShopService coffeeShopService = new CoffeeShopServiceImpl();
    ProductRepository productRepository = new ProductRepository();
    CustomerRepository customerRepository = new CustomerRepository();

    @Test
    public void discount1() {
        List<Product> productList = new ArrayList<Product>();

        /*

        Her Offering
        • Coffee (small, medium, large) 2.50 CHF, 3.00 CHF, 3.50 CHF --> BEVERAGE(B)
        • Bacon Roll 4.50 CHF --> SNACK(S)
        Extras(E):
        • Extra milk 0.30 CHF
        • Foamed milk 0.50 CHF
        • Special roast coffee 0.90 CHF
        */


        /*
        list of products the shopper wants to purchase (large coffee with extra milk, small
            coffee with special roast, bacon roll)
         */
        Customer c = customerRepository.find(1);
        c.setNrBeverages(3);
        Product p1 = productRepository.find(3);
        Product p2 = productRepository.find(5);

        Product p3 = productRepository.find(1);
        Product p4 = productRepository.find(7);

        Product p5 = productRepository.find(4);
        Product p6 = productRepository.find(6);

        productList.add(p1);
        productList.add(p2);
        productList.add(p3);
        productList.add(p4);
        productList.add(p5);
        productList.add(p6);

        Receipt receipt = coffeeShopService.get(productList, c);

        System.out.println(receipt);

        Assert.assertTrue(receipt.toString().contains("Total     : 8.40 CHF"));

    }

    @Test
    public void discount2() {
        List<Product> productList = new ArrayList<Product>();

        /*

        Her Offering
        • Coffee (small, medium, large) 2.50 CHF, 3.00 CHF, 3.50 CHF --> BEVERAGE(B)
        • Bacon Roll 4.50 CHF --> SNACK(S)
        Extras(E):
        • Extra milk 0.30 CHF
        • Foamed milk 0.50 CHF
        • Special roast coffee 0.90 CHF
        */


        /*
        list of products the shopper wants to purchase (large coffee with extra milk, small
            coffee with special roast, bacon roll 2)
         */
        Customer c = customerRepository.find(1);
        c.setNrBeverages(8);
        Product p1 = productRepository.find(3);
        Product p11 = productRepository.find(3);
        Product p12 = productRepository.find(3);
        Product p13 = productRepository.find(3);
        Product p14 = productRepository.find(3);
        Product p2 = productRepository.find(5);

        Product p3 = productRepository.find(1);
        Product p4 = productRepository.find(7);

        Product p5 = productRepository.find(4);
        Product p6 = productRepository.find(4);
        Product p7 = productRepository.find(6);


        productList.add(p1);
        productList.add(p11);
        productList.add(p12);
        productList.add(p13);
        productList.add(p14);
        productList.add(p2);
        productList.add(p3);
        productList.add(p4);
        productList.add(p5);
        productList.add(p6);
        productList.add(p7);

        Receipt receipt = coffeeShopService.get(productList, c);

        System.out.println(receipt);

        Assert.assertTrue(receipt.toString().contains("Total     : 26.00 CHF"));

    }

}
