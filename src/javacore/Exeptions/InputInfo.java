package javacore.Exeptions;

import java.util.InputMismatchException;
import java.util.Scanner;

public class InputInfo {
    public Book addBook() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите автора книги");
        String author = scanner.nextLine();
        System.out.println("Введите название книги");
        String title = scanner.nextLine();
        System.out.println("Введите количество добавляемых книг");
        int amount = -1;
// проверка на ввод числа
        while (amount <= 0) {
            System.out.print("Введите положительное целое число: ");
            try {
                amount = scanner.nextInt(); // может вызвать InputMismatchException
                if (amount <= 0) {
                    System.out.println("Число должно быть положительным! Попробуйте снова.");
                } else {
                    System.out.println("Вы ввели число: " + amount);
                }

            } catch (InputMismatchException e) {
                System.out.println("Неверный формат ввода! Нужно ввести целое положительное число.");
                scanner.nextLine(); // очистить буфер от неверного ввода
            }
        }

        return new Book(author, title, amount);
    }

}
