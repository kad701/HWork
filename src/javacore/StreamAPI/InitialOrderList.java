package javacore.StreamAPI;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Set;

public class InitialOrderList {
    public ArrayList<Order> getOrdersList() {
        InitialProductList initialProductList = new InitialProductList();

        ArrayList<Product> products = initialProductList.getProductList();
        ArrayList<Order> orders = new ArrayList<>();

        Order order1 = new Order(1, LocalDate.of(2025, 8, 25),
                LocalDate.of(2025, 8, 31), "delivered",
                Set.of(products.get(1), products.get(6), products.get(7), products.get(8), products.get(11)));
        Order order2 = new Order(2, LocalDate.of(2025, 7, 25),
                LocalDate.of(2025, 8, 31), "delivered",
                Set.of(products.get(5), products.get(6), products.get(3), products.get(12), products.get(19)));
        Order order3 = new Order(3, LocalDate.of(2025, 8, 25),
                LocalDate.of(2025, 12, 31), "ordered",
                Set.of(products.get(4), products.get(5), products.get(17), products.get(19), products.get(18)));
        Order order4 = new Order(4, LocalDate.of(2025, 7, 19),
                LocalDate.of(2025, 10, 22), "ordered",
                Set.of(products.get(8), products.get(9), products.get(2), products.get(4), products.get(15)));
        Order order5 = new Order(5, LocalDate.of(2021, 3, 15),
                LocalDate.of(2025, 11, 30), "ordered",
                Set.of(products.get(7), products.get(2), products.get(4), products.get(12), products.get(11)));
        Order order6 = new Order(6, LocalDate.of(2021, 3, 14),
                LocalDate.of(2025, 12, 11), "ordered",
                Set.of(products.get(2), products.get(3), products.get(7), products.get(10), products.get(11)));
        Order order7 = new Order(7, LocalDate.of(2021, 3, 15),
                LocalDate.of(2025, 8, 26), "delivered",
                Set.of(products.get(1), products.get(5), products.get(7), products.get(8), products.get(14)));
        Order order8 = new Order(8, LocalDate.of(2021, 3, 25),
                LocalDate.of(2025, 8, 31), "delivered",
                Set.of(products.get(3), products.get(4), products.get(5), products.get(6), products.get(12)));
        Order order9 = new Order(9, LocalDate.of(2025, 8, 25),
                LocalDate.of(2025, 8, 27), "delivered",
                Set.of(products.get(5), products.get(6), products.get(9), products.get(8), products.get(13)));
        Order order10 = new Order(10, LocalDate.of(2021, 2, 14),
                LocalDate.of(2021, 2, 17), "delivered",
                Set.of(products.get(2), products.get(4), products.get(5), products.get(9), products.get(18)));
        Order order11 = new Order(11, LocalDate.of(2025, 7, 25),
                LocalDate.of(2026, 1, 5), "ordered",
                Set.of(products.get(5), products.get(8), products.get(9), products.get(11), products.get(16)));
        orders.add(order1);
        orders.add(order2);
        orders.add(order3);
        orders.add(order4);
        orders.add(order5);
        orders.add(order6);
        orders.add(order7);
        orders.add(order8);
        orders.add(order9);
        orders.add(order10);
        orders.add(order11);
        return orders;
    }
}
