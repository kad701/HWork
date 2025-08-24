package javacore.oop;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
// Добавим несколько публикаций в библиотеку
        List<Publication> publicationList = new ArrayList<>();
        publicationList.add(new Newspaper("The Times", "Journalists from Times", 2025,
                "Monday"));
        publicationList.add(new Newspaper("Fox News", "Journalists from Fox", 2025,
                "Wednesday"));
        publicationList.add(new Newspaper("Usa Today", "Journalists from Usa", 2025,
                "Thursday"));
        publicationList.add(new Book("Aivengo", "Valter Scott", 1828, "1126789"));
        publicationList.add(new Book("The Last Kingdom", "Bernard Cornuwell", 2009, "234571"));
        publicationList.add(new Magazine("Vogue", "Farmers Journalist", 1989, 45678));
        publicationList.add(new Magazine("Farmers", "Farmers Journalist", 1970, 2314));
        //   Journalist Vogue
        Library library = new Library(publicationList);
        Scanner scanner = new Scanner(System.in);
        String option = null;
        do {
            System.out.println("МЕНЮ");
            System.out.println("Введите 1 Добавить новую публикацию");
            System.out.println("Введите 2 Вывести список всех публикаций");//
            System.out.println("Введите 3 Поиск публикации по автору");//
            System.out.println("Введите 4 Вывести общее количество публикаций");//
            System.out.println("Введите 5 Удалить публикацию");
            System.out.println("Введите 0 Завершить работу");//
            //удалить публикацию
            option = scanner.nextLine();
            switch (option) {
                case "1":
                    library.addPublicatoin(scanner);
                    break;
                case "2":
                    library.showPublications();
                    break;
                case "3":
                    System.out.println("Введите имя автора");
                    String name = scanner.nextLine();
                    library.findPublicationByAuthor(name);
                    break;
                case "4":
                    System.out.println("Общее количество публикаций : = " + Library.getPublicationListSize());
                    break;
                case "5":
                    library.deletePublicationByAuthorAndTitle(scanner);
                    break;
            }

            if(!((option.equals("1"))||(option.equals("2"))||(option.equals("3"))||(option.equals("4"))||(option.equals("0"))))

                System.out.println("Вы выбрали не верную опцию, повторите ввод");

        }
        while (!option.equals("0"));

    }
}
