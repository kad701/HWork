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
        List<Product> task1 = products.stream().filter(element -> element.getCategory().equals("books")).toList();
        //  System.out.println(task1);

        // 2. Получите список заказов с продуктами из категории "Children's products".
        List<Order> task2 = orders.stream()
                .filter(order -> order.getProducts().stream()
                        .anyMatch(product -> "Children's products".equals(product.getCategory())))
                .toList();
        // System.out.println(task2);

        //3. Получите список продуктов из категории "Toys" и примените скидку 10% и получите сумму всех продуктов.
        BigDecimal task3 = products.stream()
                .filter(element -> element.getCategory().equalsIgnoreCase("toy"))
                .map(element -> element.getPrice().multiply(new BigDecimal("0.9")))
                .reduce(BigDecimal.ZERO, BigDecimal::add);
        //System.out.println(task3);

        //4. Получите список продуктов, заказанных клиентом второго уровня между 01-фев-2021 и 01-апр-2021.

        List<Product> task4 = customers.stream()
                .filter(c -> c.getLevel() == 2)
                .flatMap(c -> c.getOrders().stream())
                .filter(order -> !order.getOrderDate().isBefore(LocalDate.of(2021, 2, 1))
                        && !order.getOrderDate().isAfter(LocalDate.of(2021, 4, 1)))
                .flatMap(order -> order.getProducts().stream()).distinct()
                .collect(Collectors.toList());
        //System.out.println(task4);


        // 5. Получите топ 2 самые дешевые продукты из категории "Books".

        List<Product> task5 = products.stream().filter(element -> element.getCategory().equalsIgnoreCase("books"))
                .sorted(Comparator.comparing(Product::getPrice)).limit(2).collect(Collectors.toList());
        //System.out.println(task5);

        //6. Получите 3 самых последних сделанных заказа.
        List<Order> task6 = orders.stream().sorted(Comparator.comparing(Order::getOrderDate).reversed()).limit(3)
                .collect(Collectors.toList());
        //System.out.println(task6);

        // 7. Получите список заказов, сделанных 15-марта-2021, выведите id заказов в консоль и затем верните
        //список их продуктов.
        // Фильтрация заказов по дате 15 марта 2021
        List<Order> ordersOnDate = orders.stream()
                .filter(order -> order.getOrderDate().equals(LocalDate.of(2021, 3, 15)))
                .collect(Collectors.toList());

        // Выводим id заказов в консоль
        List<Long> idLstTask7 = ordersOnDate.stream()
                .map(Order::getId)
                .collect(Collectors.toList());

        //  System.out.println("IDs заказов от 15 марта 2021: " + idLstTask7);

        // Получаем список всех продуктов из этих заказов
        List<Product> productsFromOrders = ordersOnDate.stream()
                .flatMap(order -> order.getProducts().stream())
                .collect(Collectors.toList());
        //   System.out.println("Список продуктов от 15 марта 2021: " + productsFromOrders);


        // 8. Рассчитайте общую сумму всех заказов, сделанных в феврале 2021.
        BigDecimal totalSum = orders.stream()
                .filter(order -> {
                    LocalDate date = order.getOrderDate();
                    return !date.isBefore(LocalDate.of(2021, 2, 1)) && !date.isAfter(LocalDate.of(2021, 2, 28));
                })
                .flatMap(order -> order.getProducts().stream())
                .map(Product::getPrice)
                .reduce(BigDecimal.ZERO, BigDecimal::add);

        //   System.out.println("Общая сумма заказов за февраль 2021: " + totalSum);

        //9. Рассчитайте средний платеж по заказам, сделанным 14-марта-2021.

        List<Product> productListTask9 = orders.stream().filter(element -> element.getOrderDate()
                        .equals(LocalDate.of(2021, 3, 14))).flatMap(order -> order.getProducts().stream())
                .collect(Collectors.toList()); // список товаров купленных в заданное число
        BigDecimal total = productListTask9.stream()
                .map(Product::getPrice)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
        long countProductTask9 = productListTask9.stream().count();
        // System.out.println(productListTask9);
        //  System.out.println(countProductTask9);
        BigDecimal avgPriceTask9 = countProductTask9 > 0
                ? total.divide(BigDecimal.valueOf(countProductTask9), 2, RoundingMode.HALF_UP)
                : BigDecimal.ZERO;
        //System.out.println("Средний платёж по заказам за 14 марта 2021: " + avgPriceTask9);

        // 10. Получите набор статистических данных (сумма, среднее, максимум, минимум, количество) для всех
        //продуктов категории "Книги"

        Long amountTask10 = products.stream().filter(element -> element.getCategory().equalsIgnoreCase("books"))
                .count();// находим количество
        //System.out.println(amountTask10);
        // находим максимальное
        Optional<Product> mostExpensiveBook = products.stream()
                .filter(product -> product.getCategory().equalsIgnoreCase("books"))
                .max(Comparator.comparing(Product::getPrice));
        BigDecimal maxTask10 = mostExpensiveBook.map(Product::getPrice).orElse(null);
        // System.out.println("Цена самой дорогой книги: " + maxTask10);
        //System.out.println(maxTask10);
        // находим минимальное
        Optional<Product> leastExpensiveBook = products.stream()
                .filter(product -> product.getCategory().equalsIgnoreCase("books"))
                .max(Comparator.comparing(Product::getPrice).reversed());
        BigDecimal minTask10 = leastExpensiveBook.map(Product::getPrice).orElse(null);
        //System.out.println("Цена самой дешевой книги: " + minTask10);
        // System.out.println(minTask10);

        //находим сумму
        BigDecimal sumTask10 = products.stream().filter(element -> element.getCategory().equalsIgnoreCase("books"))
                .map(Product::getPrice)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
        // System.out.println("Сумма всех цен: " + sumTask10);
        // System.out.println(sumTask10);

        // Вычисляем среднее
        BigDecimal avgTask10 = sumTask10.divide(BigDecimal.valueOf(amountTask10), 2, RoundingMode.HALF_UP);
        //System.out.println(avgTask10);

        //11. Получите данные Map<Long, Integer> → key - id заказа, value - кол-во товаров в заказе
        Map<Long, Integer> task11 = orders.stream()
                .collect(Collectors.toMap(
                        Order::getId,
                        order -> order.getProducts().size()
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
        Map<Order, Double> task13 = orders.stream().collect(Collectors.toMap(
                order -> order,
                order -> order.getProducts().stream()
                        .map(Product::getPrice)
                        .reduce(BigDecimal.ZERO, BigDecimal::add)
                        .doubleValue()
        ));
        // System.out.println(task13);

        //14. Получите Map<String, List<String>> → key - категория, value - список названий товаров в категории
        Map<String, List<String>> task14 = products.stream()
                .collect(Collectors.groupingBy(
                        Product::getCategory,
                        Collectors.mapping(
                                Product::getName,
                                Collectors.toList()
                        )
                ));
        //  System.out.println(task14);

        // 15. Получите Map<String, Product> → самый дорогой продукт по каждой категории.
        Map<String, Product> task15 = products.stream()
                .collect(Collectors.toMap(
                        Product::getCategory,
                        product -> product,
                        BinaryOperator.maxBy(Comparator.comparing(Product::getPrice))
                ));

        // System.out.println(task15);
    }
}