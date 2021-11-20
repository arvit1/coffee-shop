package com.arvit.core;

import com.arvit.core.domain.Customer;
import com.arvit.core.domain.Product;
import com.arvit.core.domain.Receipt;
import com.arvit.core.repository.CustomerRepository;
import com.arvit.core.services.CoffeeShopService;
import com.arvit.core.services.CoffeeShopServiceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StartApplication {
    List<Product> productList = new ArrayList<>();
    CoffeeShopService coffeeShopService = new CoffeeShopServiceImpl();
    CustomerRepository customerRepository = new CustomerRepository();
    Customer customer = new Customer();

    public static void main(String[] args) {
        Scanner input;
        input = new Scanner(System.in);
        StartApplication application = new StartApplication();
        application.switchCase(input);
    }

    private void switchCase(Scanner input) {
        int menuOption;
        menu1(input);
        while (true) {
            menu();
            menuOption = input.nextInt();
            switch (menuOption) {
                case 1:
                    Product p = new Product("C", "small coffee", 2.50, "CHF", "B");
                    System.out.println("You've ordered a small coffee");
                    quantity(input, p);
                    break;
                case 2:
                    Product p1 = new Product("B", "medium coffee", 3.00, "CHF", "B");
                    System.out.println("You've ordered medium coffee");
                    quantity(input, p1);
                    break;
                case 3:
                    Product p2 = new Product("A", "large coffee", 3.50, "CHF", "B");
                    System.out.println("You've ordered a large coffee");
                    quantity(input, p2);
                    break;
                case 4:
                    Product p3 = new Product("D", "Bacon Roll", 4.50, "CHF", "S");
                    System.out.println("You've ordered a Bacon Roll");
                    quantity(input, p3);
                    break;
                case 5:
                    Product p4 = new Product("E", "orange juice", 3.95, "CHF", "E");
                    System.out.println("You've ordered a orange juice");
                    quantity(input, p4);
                    break;
                case 6:
                    Product p5 = new Product("F", "Extra milk", 0.30, "CHF", "E");
                    System.out.println("You've ordered a small coffee");
                    quantity(input, p5);
                    break;
                case 7:
                    Product p6 = new Product("G", "Foamed milk", 0.50, "CHF", "E");
                    System.out.println("You've ordered a Foamed milk");
                    quantity(input, p6);
                    break;
                case 8:
                    Product p7 = new Product("H", "roast coffee", 0.90, "CHF", "E");
                    System.out.println("You've ordered a roast coffee");
                    quantity(input, p7);
                    break;
                case 9:
                    done();
                    switchCase(input);
                    break;
                case 10:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid option.");
            }
        }
    }

    public void menu1(Scanner input) {
        System.out.println("Select Customer");
        for (Customer customer1 : customerRepository.getAll()){
            System.out.println(customer1);
        }
        String idCustomer = input.nextLine();
        this.customer = customerRepository.find(idCustomer);
        System.out.println("Hello customer : " + customer.getFirstName());
    }

    public void menu() {

        System.out.println("Welcome \n1. small coffee (2.50 CHF) " +
                "\n2. medium coffee (3.00 CHF)\n3. large coffee (3.50 CHF) \n4. Bacon Roll (4.50 CHF) " +
                "\n5. orange juice (3.95 CHF) \n6. Extra milk (0.30 CHF) \n7. Foamed milk (0.50 CHF) " +
                "\n8. roast coffee (0.90 CHF) \n9. Done \n10. exit");
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
