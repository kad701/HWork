package javacore.oop;

import java.util.Scanner;

public class ValidationUtils {

    public static int checkIfIntInput(Scanner scanner) {
        String input = null;
        while (true) {
            System.out.println("Введите положительное целое число:");
            input = scanner.nextLine();
            if (!isNumber(input)) {
                System.out.println("Ошибка: нужно ввести целое число.");
                continue;
            }
            int number = Integer.parseInt(input);
            if (!isPositive(number)) {
                System.out.println("Ошибка: число должно быть положительным.");
                continue;
            }
            return number;
        }
    }

    public static boolean isNumber(String input) {
        if (input == null || input.trim().isEmpty())
            return false;
        try {
            Integer.parseInt(input.trim());
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public static boolean isPositive(int number) {
        return number > 0;
    }
}
