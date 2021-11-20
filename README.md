# Coding Assignment: Charlene's Coffee Corner - Details

Recently, Charlene decided to open her very own little coffee shop on a busy street corner.
Being the careful entrepreneur, she decided to start off with a limited offering, with the option to expand her
choice of products, as business goes.
Her Offering
• Coffee (small, medium, large) 2.50 CHF, 3.00 CHF, 3.50 CHF
• Bacon Roll 4.50 CHF
• Freshly squeezed orange juice (0.25l) 3.95 CHF
Extras:
• Extra milk 0.30 CHF
• Foamed milk 0.50 CHF
• Special roast coffee 0.90 CHF
Bonus Program
• Charlene's idea is to attract as many regular‘s as possible to have a steady turnaround.
• She decides to offer a customer stamp card, where every 5th beverage is for free.
• If a customer orders a beverage and a snack, one of the extra's is free.


## 1. Input the element in the test

        list of products the shopper wants to purchase (large coffee with extra milk, small
            coffee with special roast, bacon roll, orange juice)

        Product p1 = new Product("A","large coffee", 3.50,"CHF","B");
        Product p2 = new Product("B", "Extra milk", 0.30,"CHF","E");

        Product p3 = new Product("C","small coffee", 2.50,"CHF","B");
        Product p4 = new Product("D", "Special roast", 0.90,"CHF","E");

        Product p5 = new Product("E","Bacon Roll", 4.50,"CHF","S");
        Product p6 = new Product("F", "orange juice", 3.95,"CHF","E");            
         
## 2. Run the test
```
$ mvn test
```
## 2. Expected result 

Id Receipt: 26e8928a-1a9b-4d25-9e76-438ffec64023
Date      : Fri Nov 20 14:44:32 CET 2020
large coffee, 3.5, CHF
Extra milk, 0.3, CHF
small coffee, 2.5, CHF
Special roast, 0.9, CHF
Bacon Roll, 4.5, CHF
orange juice, 3.95, CHF
Extra milk, -0.3, CHF  --> discount generated
Total     : 15.35 CHF


