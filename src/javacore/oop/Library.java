package javacore.oop;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Library {
    private static List<Publication> publicationList;

    public static int getPublicationListSize(){
        return publicationList.size();
    }

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

    public Library(List<Publication> publicationList) {
        this.publicationList = publicationList;
    }

    public void showPublications() {
        System.out.println(publicationList);
    }

    public void addPublicatoin(Scanner scanner) {
        String option = null;
        do {
            System.out.println("Что хотите добавить?");
            System.out.println("1-Книга");
            System.out.println("2-Журнал");
            System.out.println("3-Газета");
            System.out.println("4-Вернуться в предыдущее меню");
            option = scanner.nextLine();
            if (option.equalsIgnoreCase("1")) {
                System.out.println("Введите название");
                String title = scanner.nextLine();
                System.out.println("Введите автора");
                String author = scanner.nextLine();
                System.out.println("Введите год");
                int year = checkIfIntInput(scanner);
                System.out.println("Введите isbn");
                String isbn = scanner.nextLine();
                Book newBook = new Book(title, author, year, isbn);
                publicationList.add(newBook);
                break;
            } else if (option.equalsIgnoreCase("2")) {
                System.out.println("Введите название");
                String title = scanner.nextLine();
                System.out.println("Введите автора");
                String author = scanner.nextLine();
                System.out.println("Введите год");
                int year = checkIfIntInput(scanner);
                System.out.println("Введите issueNumber");
                int issueNumber = checkIfIntInput(scanner);
                Magazine magazine = new Magazine(title, author, year, issueNumber);
                publicationList.add(magazine);
                break;
            } else if (option.equalsIgnoreCase("3")) {
                System.out.println("Введите название");
                String title = scanner.nextLine();
                System.out.println("Введите автора");
                String author = scanner.nextLine();
                System.out.println("Введите год");
                int year = checkIfIntInput(scanner);
                System.out.println("Введите publicationDay");
                String publicationDay = scanner.nextLine();
                Newspaper newspaper = new Newspaper(title, author, year, publicationDay);
                publicationList.add(newspaper);
                break;

            } else if (!option.equals("4"))
                System.out.println("Вы ввели неверную опцию");
        }
        while (!option.equalsIgnoreCase("4"));
        System.out.println();
    }

    public void findPublicationByAuthor(String author) {
        List<Publication> authorPublications = new ArrayList<>();


        for (Publication element : publicationList) {
            if (element.getAuthor().toLowerCase().contains(author.toLowerCase()))
                authorPublications.add(element);
        }
        if (authorPublications.isEmpty())
            System.out.println("Нет публикаций данного автора");
        else
            System.out.println(authorPublications);
    }

    public void deletePublicationByAuthorAndTitle(Scanner scanner){
        System.out.println("Введите автора для удаления");
        String author=scanner.nextLine();
        System.out.println("Введите название публикации для удаления");
        String title=scanner.nextLine();
        Publication removedPublication=null;
        for (Publication element:publicationList) {
            if((element.getAuthor().equals(author))&&(element.getTitle().equals(title))){
                removedPublication=  element;
                break;
            }
        }
        publicationList.remove(removedPublication);
        System.out.println();
    }

}
