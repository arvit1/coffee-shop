package com.arvit.core.repository;

import com.arvit.core.domain.Customer;

import java.util.Date;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class CustomerRepository {
    List<Customer> customers = new CopyOnWriteArrayList<>();
    public static int id = 1;
    public CustomerRepository() {
        Customer customer = new Customer(id++, "John", "Doe", new Date(1506404935902L), 3);
        Customer customer1 = new Customer(id++, "Tom", "Fox", new Date(1406404935902L), 4);
        Customer customer2 = new Customer(id++, "Aron", "Jager", new Date(1516404935902L), 5);
        Customer customer3 = new Customer(id++, "Jerry", "Bald", new Date(1496404935902L), 8);
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

    public Customer find(int id) {
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

    public void delete(int id){
        Customer customer = this.find(id);
        if (customer != null){
            customers.remove(customer);
        }
    }

    public int findById(int id) {
        for (int i = 0; i < customers.size(); i++) {
            if (customers.get(i).getId() == id){
                return i;
            }
        }
        return -1;
    }
}
