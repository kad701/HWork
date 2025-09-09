package javacore.StreamAPI;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;
import java.util.function.BinaryOperator;

public class Main {
    public static void main(String[] args) {
        InitialProductList initialProductList = new InitialProductList();
        InitialOrderList initialOrderList = new InitialOrderList();
        InitialCustomersList initialCustomersList = new InitialCustomersList();
        ArrayList<Product> products = initialProductList.getProductList();
        ArrayList<Order> orders = initialOrderList.getOrdersList();
        ArrayList<Customer> customers = initialCustomersList.getCustomersList();

        //1. Получите список продуктов из категории "Books" с ценой более 100.

        List<Product> task1 = customers.stream()
                .flatMap(customer -> customer.getOrders().stream())
                .flatMap(order -> order.getProducts().stream())
                .filter(product -> product.getCategory().equalsIgnoreCase("Books"))
                .filter(product -> product.getPrice().compareTo(BigDecimal.valueOf(100)) > 0)
                .toList();

        // System.out.println(task1);

        // 2. Получите список заказов с продуктами из категории "Children's products".
        List<Order> task2 = customers.stream()
                .flatMap(customer -> customer.getOrders().stream())
                .filter(order -> order.getProducts().stream()
                        .anyMatch(product -> "Children's products".equalsIgnoreCase(product.getCategory())))
                .toList();

        // System.out.println(task2);

        //3. Получите список продуктов из категории "Toys" и примените скидку 10% и получите сумму всех продуктов.

        BigDecimal task3 = customers.stream()
                .flatMap(customer -> customer.getOrders().stream())
                .flatMap(order -> order.getProducts().stream())
                .filter(product -> product.getCategory().equalsIgnoreCase("Toy"))
                .map(product -> product.getPrice().multiply(new BigDecimal("0.9")))
                .reduce(BigDecimal.ZERO, BigDecimal::add);

        // System.out.println(task3);

        //4. Получите список продуктов, заказанных клиентом второго уровня между 01-фев-2021 и 01-апр-2021.

        List<Product> task4 = customers.stream()
                .filter(c -> c.getLevel() == 2)
                .flatMap(c -> c.getOrders().stream())
                .filter(order -> !order.getOrderDate().isBefore(LocalDate.of(2021, 2, 1))
                        && !order.getOrderDate().isAfter(LocalDate.of(2021, 4, 1)))
                .flatMap(order -> order.getProducts().stream()).distinct()
                .toList();
        //System.out.println(task4);


        // 5. Получите топ 2 самые дешевые продукты из категории "Books".

        List<Product> task5 = customers.stream()
                .flatMap(customer -> customer.getOrders().stream())
                .flatMap(order -> order.getProducts().stream())
                .filter(product -> product.getCategory().equalsIgnoreCase("Books"))
                .sorted(Comparator.comparing(Product::getPrice))
                .limit(2)
                .toList();
        //System.out.println(task5);

        //6. Получите 3 самых последних сделанных заказа.
        List<Order> task6 = customers.stream()
                .flatMap(customer -> customer.getOrders().stream())
                .sorted(Comparator.comparing(Order::getOrderDate).reversed())
                .limit(3)
                .toList();
        //System.out.println(task6);

        // 7. Получите список заказов, сделанных 15-марта-2021, выведите id заказов в консоль и затем верните
        //список их продуктов.

        List<Order> ordersOnDate = customers.stream()
                .flatMap(customer -> customer.getOrders().stream())
                .filter(order -> LocalDate.of(2021, 3, 15).equals(order.getOrderDate()))
                .toList();

        // Выводим id заказов
        List<Long> idLstTask7 = customers.stream()
                .flatMap(customer -> customer.getOrders().stream())
                .filter(order -> LocalDate.of(2021, 3, 15).equals(order.getOrderDate()))
                .map(Order::getId)
                .toList();

        //  System.out.println("IDs заказов от 15 марта 2021: " + idLstTask7);

        // Получаем список всех продуктов из этих заказов
        List<Product> productsFromOrders = customers.stream()
                .flatMap(customer -> customer.getOrders().stream())
                .filter(order -> LocalDate.of(2021, 3, 15).equals(order.getOrderDate()))
                .flatMap(order -> order.getProducts().stream())
                .toList();
        //   System.out.println("Список продуктов от 15 марта 2021: " + productsFromOrders);


        // 8. Рассчитайте общую сумму всех заказов, сделанных в феврале 2021.
        BigDecimal totalSum = customers.stream()
                .flatMap(customer -> customer.getOrders().stream())
                .filter(order -> {
                    LocalDate date = order.getOrderDate();
                    return !date.isBefore(LocalDate.of(2021, 2, 1)) && !date.isAfter(LocalDate.of(2021, 2, 28));
                })
                .flatMap(order -> order.getProducts().stream())
                .map(Product::getPrice)
                .reduce(BigDecimal.ZERO, BigDecimal::add);

        //   System.out.println("Общая сумма заказов за февраль 2021: " + totalSum);

        //9. Рассчитайте средний платеж по заказам, сделанным 14-марта-2021.

        LocalDate targetDate = LocalDate.of(2021, 3, 14);

        List<BigDecimal> orderTotalsOnDate = customers.stream()
                .flatMap(customer -> customer.getOrders().stream())
                .filter(order -> order.getOrderDate().equals(targetDate))
                .map(order -> order.getProducts().stream()
                        .map(Product::getPrice)
                        .reduce(BigDecimal.ZERO, BigDecimal::add))
                .toList();

        BigDecimal totalSumTask9 = orderTotalsOnDate.stream()
                .reduce(BigDecimal.ZERO, BigDecimal::add);

        int numberOfOrders = orderTotalsOnDate.size();

        BigDecimal avgPayment = numberOfOrders > 0
                ? totalSum.divide(BigDecimal.valueOf(numberOfOrders), 2, RoundingMode.HALF_UP)
                : BigDecimal.ZERO;

        //System.out.println("Средний платёж по заказам 14 марта 2021: " + avgPayment);


        // 10. Получите набор статистических данных (сумма, среднее, максимум, минимум, количество) для всех
        //продуктов категории "Книги"

        List<Product> books = customers.stream()
                .flatMap(customer -> customer.getOrders().stream())
                .flatMap(order -> order.getProducts().stream())
                .filter(product -> product.getCategory().equalsIgnoreCase("books"))
                .toList();

        long count = books.size();

        BigDecimal sum = books.stream()
                .map(Product::getPrice)
                .reduce(BigDecimal.ZERO, BigDecimal::add);

        BigDecimal average = count > 0
                ? sum.divide(BigDecimal.valueOf(count), 2, RoundingMode.HALF_UP)
                : BigDecimal.ZERO;

        BigDecimal min = books.stream()
                .map(Product::getPrice)
                .min(Comparator.naturalOrder())
                .orElse(null);

        BigDecimal max = books.stream()
                .map(Product::getPrice)
                .max(Comparator.naturalOrder())
                .orElse(null);

//  результаты
//        System.out.println("Книг всего: " + count);
//        System.out.println("Суммарная стоимость: " + sum);
//        System.out.println("Средняя цена: " + average);
//        System.out.println("Минимальная цена: " + min);
//        System.out.println("Максимальная цена: " + max);

        //11. Получите данные Map<Long, Integer> → key - id заказа, value - кол-во товаров в заказе
        Map<Long, Integer> task11 = customers.stream()
                .flatMap(customer -> customer.getOrders().stream())
                .collect(Collectors.toMap(
                        Order::getId,
                        order -> order.getProducts().size(),
                        (existing, duplicate) -> existing
                ));

        // System.out.println(task11);

        // 12. Создайте Map<Customer, List<Order>> → key - покупатель, value - список его заказов
        Map<Customer, Set<Order>> task12 = customers.stream()
                .collect(Collectors.toMap(
                        customer -> customer,
                        Customer::getOrders
                ));
        // System.out.println(task12);

        // 13. Создайте Map<Order, Double> → key - заказ, value - общая сумма продуктов заказа.
        Map<Order, Double> task13 = customers.stream()
                .flatMap(customer -> customer.getOrders().stream())
                .collect(Collectors.toMap(
                        order -> order,
                        order -> order.getProducts().stream()
                                .map(Product::getPrice)
                                .reduce(BigDecimal.ZERO, BigDecimal::add)
                                .doubleValue(),
                        (existing, duplicate) -> existing
                ));

        // System.out.println(task13);

        //14. Получите Map<String, List<String>> → key - категория, value - список названий товаров в категории
        Map<String, List<String>> task14 = customers.stream()
                .flatMap(customer -> customer.getOrders().stream())
                .flatMap(order -> order.getProducts().stream())
                .collect(Collectors.groupingBy(
                        Product::getCategory,
                        Collectors.mapping(
                                Product::getName,
                                Collectors.toList()
                        )
                ));

        //System.out.println(task14);

        // 15. Получите Map<String, Product> → самый дорогой продукт по каждой категории.
        Map<String, Product> task15 = customers.stream()
                .flatMap(customer -> customer.getOrders().stream())
                .flatMap(order -> order.getProducts().stream())
                .collect(Collectors.toMap(
                        Product::getCategory,
                        product -> product,
                        BinaryOperator.maxBy(Comparator.comparing(Product::getPrice))
                ));

        // System.out.println(task15);
    }
}