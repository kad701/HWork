package javacore.oop;

import java.util.Scanner;

public class ValidationUnits {
    public static int checkIfIntInput(Scanner scanner) {
        String input = null;
        while (!isNumber(input)) {
            System.out.println("Необходимо ввести число");
            input = scanner.nextLine();
        }
        return Integer.parseInt(input);

    }

    public static boolean isNumber(String input) {
        if ((input == null) || input.trim().isEmpty())
            return false;
        try {
            Integer.parseInt(input.trim());
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
