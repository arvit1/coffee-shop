package com.arvit.core.services;

import com.arvit.core.domain.Product;
import com.arvit.core.domain.Receipt;
import org.junit.Assert;
import org.junit.Test;
import java.util.ArrayList;
import java.util.List;

public class CoffeeShopServiceTest {

    CoffeeShopService coffeeShopService = new CoffeeShopServiceImpl();

    @Test
    public void discount1() {
        List<Product> productList = new ArrayList<Product>();

        /*

        Her Offering
        • Coffee (small, medium, large) 2.50 CHF, 3.00 CHF, 3.50 CHF --> BEVERAGE(B)
        • Bacon Roll 4.50 CHF --> SNACK(S)
        • Freshly squeezed orange juice (0.25l) 3.95 CHF --> BEVERAGE(B)
        Extras(E):
        • Extra milk 0.30 CHF
        • Foamed milk 0.50 CHF
        • Special roast coffee 0.90 CHF

        */


        /*
        list of products the shopper wants to purchase (large coffee with extra milk, small
            coffee with special roast, bacon roll, orange juice)
         */
        Product p1 = new Product("A","large coffee", 3.50,"CHF","B");
        Product p2 = new Product("B", "Extra milk", 0.30,"CHF","E");

        Product p3 = new Product("C","small coffee", 2.50,"CHF","B");
        Product p4 = new Product("D", "Special roast", 0.90,"CHF","E");

        Product p5 = new Product("E","Bacon Roll", 4.50,"CHF","S");
        Product p6 = new Product("F", "orange juice", 3.95,"CHF","E");

        productList.add(p1);
        productList.add(p2);
        productList.add(p3);
        productList.add(p4);
        productList.add(p5);
        productList.add(p6);

        Receipt receipt = coffeeShopService.get(productList);

        System.out.println(receipt);

        Assert.assertNotNull(receipt);

    }

    @Test
    public void discount2() {
        List<Product> productList = new ArrayList<Product>();

        /*

        Her Offering
        • Coffee (small, medium, large) 2.50 CHF, 3.00 CHF, 3.50 CHF --> BEVERAGE(B)
        • Bacon Roll 4.50 CHF --> SNACK(S)
        • Freshly squeezed orange juice (0.25l) 3.95 CHF --> BEVERAGE(B)
        Extras(E):
        • Extra milk 0.30 CHF
        • Foamed milk 0.50 CHF
        • Special roast coffee 0.90 CHF

        */


        /*
        list of products the shopper wants to purchase (large coffee with extra milk, small
            coffee with special roast, bacon roll 2, orange juice)
         */
        Product p1 = new Product("A","large coffee", 3.50,"CHF","B");
        Product p2 = new Product("B", "Extra milk", 0.30,"CHF","E");

        Product p3 = new Product("C","small coffee", 2.50,"CHF","B");
        Product p4 = new Product("D", "Special roast", 0.90,"CHF","E");

        Product p5 = new Product("E","Bacon Roll", 4.50,"CHF","S");
        Product p7 = new Product("E","Bacon Roll", 4.50,"CHF","S");
        Product p6 = new Product("F", "orange juice", 3.95,"CHF","E");

        productList.add(p1);
        productList.add(p2);
        productList.add(p3);
        productList.add(p4);
        productList.add(p5);
        productList.add(p6);
        productList.add(p7);

        Receipt receipt = coffeeShopService.get(productList);

        System.out.println(receipt);

        Assert.assertNotNull(receipt);

    }

}
