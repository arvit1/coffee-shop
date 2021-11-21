package com.arvit.core;

import com.arvit.core.domain.Customer;
import com.arvit.core.domain.Product;
import com.arvit.core.domain.Receipt;
import com.arvit.core.repository.CustomerRepository;
import com.arvit.core.repository.ProductRepository;
import com.arvit.core.services.CoffeeShopService;
import com.arvit.core.services.CoffeeShopServiceImpl;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StartApplication {
    List<Product> productList = new ArrayList<>();
    CoffeeShopService coffeeShopService = new CoffeeShopServiceImpl();
    CustomerRepository customerRepository = new CustomerRepository();
    ProductRepository productRepository = new ProductRepository();
    Customer customer = new Customer();

    public static void main(String[] args) throws ParseException {
        Scanner input;
        input = new Scanner(System.in);
        StartApplication application = new StartApplication();
        application.switchCase(input);
    }

    private void switchCase(Scanner input) throws ParseException {
        int menuOption;
        menu1(input);
        while (true) {
            menu();
            menuOption = input.nextInt();
            switch (menuOption) {
                case 1:
                    Product p1 = productRepository.find(menuOption);
                    System.out.println("You've ordered a " + p1.getDescription());
                    quantity(input, p1);
                    break;
                case 2:
                    Product p2 = productRepository.find(menuOption);
                    System.out.println("You've ordered a " + p2.getDescription());
                    quantity(input, p2);
                    break;
                case 3:
                    Product p3 = productRepository.find(menuOption);
                    System.out.println("You've ordered a " + p3.getDescription());
                    quantity(input, p3);
                    break;
                case 4:
                    Product p4 = productRepository.find(menuOption);
                    System.out.println("You've ordered a " + p4.getDescription());
                    quantity(input, p4);
                    break;
                case 5:
                    Product p5 = productRepository.find(menuOption);
                    System.out.println("You've ordered a " + p5.getDescription());
                    quantity(input, p5);
                    break;
                case 6:
                    Product p6 = productRepository.find(menuOption);
                    System.out.println("You've ordered a " + p6.getDescription());
                    quantity(input, p6);
                    break;
                case 7:
                    Product p7 = productRepository.find(menuOption);
                    System.out.println("You've ordered a " + p7.getDescription());
                    quantity(input, p7);
                    break;
                case 9:
                    done();
                    switchCase(input);
                    break;
                default:
                    System.out.println("Invalid option.");
            }
        }
    }

    public void menu1(Scanner input) throws ParseException {
        System.out.println("Select Customer by id or press 0 te create a new");
        for (Customer customer1 : customerRepository.getAll()){
            System.out.println(customer1);
        }
        int idCustomer = input.nextInt();
        if (idCustomer == 0){
            System.out.println("create a new customer comma delimited firstName, lastName, birthDate (example \"2013-09-18\")");
            input.nextLine();
            String s = input.nextLine();
            String[] tokens=s.split(",");
            customer = new Customer(CustomerRepository.id++, tokens[0], tokens[1], tokens[2]);
        } else {
            this.customer = customerRepository.find(idCustomer);
        }
        System.out.println("Hello customer : " + customer);
    }

    public void menu() {

        System.out.println("Welcome \n1. small coffee (2.50 CHF) " +
                "\n2. medium coffee (3.00 CHF)\n3. large coffee (3.50 CHF) \n4. Bacon Roll (4.50 CHF) " +
                "\n5. orange juice (3.95 CHF) \n6. Extra milk (0.30 CHF) \n7. Foamed milk (0.50 CHF) " +
                "\n8. roast coffee (0.90 CHF) \n9. Done");
    }

    public void quantity(Scanner input, Product p) {
        System.out.println("Enter quantity");
        double quantity = input.nextDouble();
        for (int i = 1; i <= quantity; i++) {
            productList.add(p);
        }
    }

    public void done() {
        Receipt receipt = coffeeShopService.get(productList);
        System.out.println(receipt);
        System.exit(0);
    }
}
