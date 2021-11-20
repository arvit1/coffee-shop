package com.arvit.core.repository;

import com.arvit.core.domain.Customer;

import java.util.Date;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class CustomerRepository {
    List<Customer> customers = new CopyOnWriteArrayList<>();

    public CustomerRepository() {
        Customer customer = new Customer("1", "John", "Doe", new Date(1506404935902L));
        Customer customer1 = new Customer("2", "Tom", "Fox", new Date(1406404935902L));
        Customer customer2 = new Customer("3", "Aron", "Jager", new Date(1516404935902L));
        Customer customer3 = new Customer("4", "Jerry", "Bald", new Date(1496404935902L));
        customers.add(customer);
        customers.add(customer1);
        customers.add(customer2);
        customers.add(customer3);
    }

    public List<Customer> getAll(){
        return customers;
    }

    public void create(Customer customer){
        customers.add(customer);
    }

    public Customer find(String id) {
        int byId = this.findById(id);
        if (byId != -1){
            return customers.get(byId);
        }
        return null;
    }

    public void update(Customer customer) {
        int byId = this.findById(customer.getId());
        if (byId != -1){
            customers.set(byId, customer);
        }
    }

    public void delete(String id){
        Customer customer = this.find(id);
        if (customer != null){
            customers.remove(customer);
        }
    }

    public int findById(String id) {
        for (int i = 0; i < customers.size(); i++) {
            if (customers.get(i).getId().equals(id)){
                return i;
            }
        }
        return -1;
    }
}
