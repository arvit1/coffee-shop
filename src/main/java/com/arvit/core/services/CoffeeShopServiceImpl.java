package com.arvit.core.services;

import com.arvit.core.domain.Item;
import com.arvit.core.domain.Product;
import com.arvit.core.domain.Receipt;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

public class CoffeeShopServiceImpl implements  CoffeeShopService{

    @Override
    public Receipt get(List<Product> listProduct) {

        //has Extra(E) for a discount
        boolean bDiscountable;
        List<Product> productDiscountable = new ArrayList<Product>();
        for (Product p : listProduct){
            if("E".equals(p.getTypeProduct())){
                bDiscountable = true;
                productDiscountable.add(p);
            }
        }

        //If a customer orders a beverage(B) and a snack(S), one of the extra's(E) is free.

        //Count for the beverage(B)
        long iCountBeverage = listProduct
                .stream()
                .filter(p-> "B".equals(p.getTypeProduct()))
                .count();

        //Count for the snack(S)
        long iCountSnack = listProduct
                .stream()
                .filter(p-> "S".equals(p.getTypeProduct()))
                .count();

        //Get the minor
        long lMinimalDiscount = getMinimalDiscount(iCountBeverage, iCountSnack);
        List<Item> itemsForDiscount = new ArrayList<>();
        if(!productDiscountable.isEmpty() && lMinimalDiscount >0){
            if( lMinimalDiscount > productDiscountable.size()){
                //add all element for discount
                itemsForDiscount = getItemsFromProductsForDiscount(productDiscountable);
            }else{
                //add the minimal element for discount
                List<Product> productDiscountableTmp = new ArrayList<>();

                for (int i = 0; i < lMinimalDiscount; i++) {
                    productDiscountableTmp.add(productDiscountable.get(i));
                }
                itemsForDiscount = getItemsFromProductsForDiscount(productDiscountableTmp);
            }
        }

        Receipt receipt = new Receipt();
        receipt.setDate(new Date());
        List<Item> items = getItemsFromProducts(listProduct);

        //put the items
        receipt.setItems(items);

        //add the discountable item
        receipt.getItems().addAll(itemsForDiscount);

        //generate the id
        UUID uuid = UUID.randomUUID();
        receipt.setId(uuid.toString());

        //calculate the total
        Double total = 0.00;
        for(Item i : receipt.getItems()){
            total = total + i.getPrice();
        }
        receipt.setTotal(total);
        return receipt;
    }

    //Get Item from Products
    private List<Item> getItemsFromProducts(List<Product> listProduct) {
        List<Item> items = new ArrayList<>();

        for (Product p : listProduct){
            Item i = new Item();
            i.setIdProduct(p.getId());
            i.setDescription(p.getDescription());
            i.setPrice(p.getPrice());
            i.setCurrency(p.getCurrency());
            i.setTypeProduct(p.getTypeProduct());
            items.add(i);
        }
        return items;
    }

    //Get Item from Products for Discount
    private List<Item> getItemsFromProductsForDiscount(List<Product> listProduct) {
        List<Item> items = new ArrayList<>();

        for (Product p : listProduct){
            Item i = new Item();
            i.setIdProduct(p.getId());
            i.setDescription(p.getDescription());
            i.setPrice(p.getPrice()*(-1));
            i.setCurrency(p.getCurrency());
            i.setTypeProduct(p.getTypeProduct());
            items.add(i);
        }
        return items;
    }

    //get minimal combination for discount
    private long getMinimalDiscount(long iCountBeverage, long iCountSnack) {
        long minor;
        minor = iCountBeverage;
        if(minor > iCountSnack){
            minor = iCountSnack;
        }
           return minor;

    }
}
