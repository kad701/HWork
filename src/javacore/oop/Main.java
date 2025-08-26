package javacore.oop;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Menu menu=new Menu();
        Library library = new Library(menu.initialPublications());// заполнение каталога
            Scanner scanner = new Scanner(System.in);
            String option = null;
            do {
                menu();
                option = scanner.nextLine();
                switch (option) {
                    case "1":
                        Publication publication = new InputPublication().inputAddInfo();
                        library.addPublicatoin(publication);
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
                        System.out.println("Общее количество публикаций : = " + Library.getPublicationList().size());
                        break;
                    case "5":
                        Publication pub = new InputPublication().inputDeleteInfo();
                        library.deletePublicationByAuthorAndTitle(pub);
                        break;
                    case "0":
                        System.out.println("Программа завершена");
                        break;
                    default:
                        System.out.println("Вы выбрали не верную опцию, повторите ввод");
                }

            }
            while (!option.equals("0"));
        }

    public static void menu(){
        System.out.println("МЕНЮ");
        System.out.println("Введите 1 Добавить новую публикацию");
        System.out.println("Введите 2 Вывести список всех публикаций");//
        System.out.println("Введите 3 Поиск публикации по автору");//
        System.out.println("Введите 4 Вывести общее количество публикаций");//
        System.out.println("Введите 5 Удалить публикацию");
        System.out.println("Введите 0 Завершить работу");
    }
}
