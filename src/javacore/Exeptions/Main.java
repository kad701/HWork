package javacore.Exeptions;

import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws NoAvailableCopiesExeption, NoItemFoundExeption {
        Scanner scanner=new Scanner(System.in);

        ArrayList<Book> catalog = new InitialCatalog().initialCatalog();
        Library library = new Library(catalog);
        String option ;

        do {
            printMenu();
            option = scanner.nextLine();
            switch (option) {
                case "1":
                    System.out.println(library.getAllBooks());
                    break;
                case "2":
                    library.addBook(new InputInfo().addBook());
                    break;
                case "3":
                    System.out.println("Введите автора");
                    String author = scanner.nextLine();
                    System.out.println("Введите название книги");
                    String title = scanner.nextLine();
                    try {
                        library.takeBook(author, title);
                    } catch (NoAvailableCopiesExeption e) {
                    }catch (NoSuchElementException e){
                        System.out.println("Такой книги нет в каталоге");
                    }
                    break;
                case "4":
                    System.out.println("Введите автора книги");
                    String returnAuthor = scanner.nextLine();
                    System.out.println("Введите название книги");
                    String returnTitle = scanner.nextLine();
                    try {
                        library.returnBook(returnAuthor,returnTitle);
                    } catch (NoItemFoundExeption e) {
                    }
                    break;
                case "5":
                    break;
                default:
                    System.out.println("Вы ввели неверную опцию");
            }

        }
        while (!option.equals("5"));

    }

    static void printMenu(){
        System.out.println("1. Вывести каталог");
        System.out.println("2. Добавить новую книгу");
        System.out.println("3. Выдать книгу");
        System.out.println("4. Вернуть книгу");
        System.out.println("5. Выйти из приложения");
    }
}

