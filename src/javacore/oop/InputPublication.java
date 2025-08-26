package javacore.oop;

import java.util.Scanner;


public class InputPublication {
    public Publication inputAddInfo() {
        Scanner scanner = new Scanner(System.in);
        String option = null;
        String title;
        String author;
        int year;
        do {
            System.out.println("Что хотите добавить?");
            System.out.println("1-Книга");
            System.out.println("2-Журнал");
            System.out.println("3-Газета");
            System.out.println("4-Вернуться в предыдущее меню");
            option = scanner.nextLine();
            switch (option) {
                case "1":
                    System.out.println("Введите название");
                    title = scanner.nextLine();
                    System.out.println("Введите автора");
                    author = scanner.nextLine();
                    System.out.println("Введите год");
                    year = ValidationUtils.checkIfIntInput(scanner);
                    System.out.println("Введите isbn");
                    String isbn = scanner.nextLine();
                    return new Book(title, author, year, isbn);

                case "2":
                    System.out.println("Введите название");
                    title = scanner.nextLine();
                    System.out.println("Введите автора");
                    author = scanner.nextLine();
                    System.out.println("Введите год");
                    year = ValidationUtils.checkIfIntInput(scanner);
                    System.out.println("Введите issueNumber");
                    int issueNumber = ValidationUtils.checkIfIntInput(scanner);
                    return new Magazine(title, author, year, issueNumber);
                case "3":
                    System.out.println("Введите название");
                    title = scanner.nextLine();
                    System.out.println("Введите автора");
                    author = scanner.nextLine();
                    System.out.println("Введите год");
                    year = ValidationUtils.checkIfIntInput(scanner);
                    System.out.println("Введите publicationDay");
                    String publicationDay = scanner.nextLine();
                    return new Newspaper(title, author, year, publicationDay);
                case "4":
                    break;
                default:
                    System.out.println("Вы ввели неверную опцию");
            }
//            if (option.equalsIgnoreCase("1")) {
//                System.out.println("Введите название");
//                String title = scanner.nextLine();
//                System.out.println("Введите автора");
//                String author = scanner.nextLine();
//                System.out.println("Введите год");
//                int year = ValidationUtils.checkIfIntInput(scanner);
//                System.out.println("Введите isbn");
//                String isbn = scanner.nextLine();
//                return new Book(title, author, year, isbn);
//
//            } else if (option.equalsIgnoreCase("2")) {
//                System.out.println("Введите название");
//                String title = scanner.nextLine();
//                System.out.println("Введите автора");
//                String author = scanner.nextLine();
//                System.out.println("Введите год");
//                int year = ValidationUtils.checkIfIntInput(scanner);
//                System.out.println("Введите issueNumber");
//                int issueNumber = ValidationUtils.checkIfIntInput(scanner);
//                return new Magazine(title, author, year, issueNumber);
//
//            } else if (option.equalsIgnoreCase("3")) {
//                System.out.println("Введите название");
//                String title = scanner.nextLine();
//                System.out.println("Введите автора");
//                String author = scanner.nextLine();
//                System.out.println("Введите год");
//                int year = ValidationUtils.checkIfIntInput(scanner);
//                System.out.println("Введите publicationDay");
//                String publicationDay = scanner.nextLine();
//                return new Newspaper(title, author, year, publicationDay);


            //  } else if (!option.equals("4"))

        }
        while (!option.equalsIgnoreCase("4"));
        return null;
    }

    public Publication inputDeleteInfo() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите автора для удаления");
        String author = scanner.nextLine();
        System.out.println("Введите название публикации для удаления");
        String title = scanner.nextLine();

        Publication removedPublication = null;
        for (Publication element : Library.getPublicationList()) {
            if ((element.getAuthor().equals(author)) && (element.getTitle().equals(title))) {
                removedPublication = element;
                break;
            }
        }
        return removedPublication;
    }

}
