package javacore.StreamAPI;

import java.util.ArrayList;
import java.util.Set;

public class InitialCustomersList {
    public ArrayList<Customer> getCustomersList() {
        InitialOrderList initialOrderList = new InitialOrderList();
        ArrayList<Order> orders = initialOrderList.getOrdersList();
        ArrayList<Customer> customers = new ArrayList<>();
        Customer customer1 = new Customer(1L, "alex", 2L, Set.of(orders.get(1), orders.get(5), orders.get(7),orders.get(2), orders.get(0)));
        Customer customer2 = new Customer(2L, "bob", 4L, Set.of(orders.get(2), orders.get(7), orders.get(10),orders.get(1), orders.get(9)));
        Customer customer3 = new Customer(3L, "tom", 1L, Set.of(orders.get(3), orders.get(6), orders.get(9),orders.get(2),orders.get(1)));
        Customer customer4 = new Customer(4L, "fred", 4L, Set.of(orders.get(4), orders.get(5), orders.get(8),orders.get(1), orders.get(7)));
        Customer customer5 = new Customer(5L, "ken", 5L, Set.of(orders.get(0), orders.get(7), orders.get(10),orders.get(2), orders.get(9)));
        Customer customer6 = new Customer(6L, "kevin", 3L, Set.of(orders.get(2), orders.get(6), orders.get(9),orders.get(1), orders.get(3)));
        Customer customer7 = new Customer(7L, "todd", 3L, Set.of(orders.get(3), orders.get(5), orders.get(7),orders.get(0), orders.get(10)));
        Customer customer8 = new Customer(8L, "ann", 2L, Set.of(orders.get(4), orders.get(7), orders.get(8),orders.get(6), orders.get(9)));
        Customer customer9 = new Customer(9L, "amily", 3L, Set.of(orders.get(1), orders.get(6), orders.get(9),orders.get(2), orders.get(7)));
        Customer customer10 = new Customer(10L, "anabiel", 1L, Set.of(orders.get(2), orders.get(5), orders.get(10),orders.get(1), orders.get(7)));
        customers.add(customer1);
        customers.add(customer2);
        customers.add(customer3);
        customers.add(customer4);
        customers.add(customer5);
        customers.add(customer6);
        customers.add(customer7);
        customers.add(customer8);
        customers.add(customer9);
        customers.add(customer10);
        return customers;
    }
}
