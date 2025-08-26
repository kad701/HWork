package javacore.oop;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Menu menu=new Menu();
        Library library = new Library(menu.initialPublications());// заполнение каталога
        menu.printMenu(library); // вызов меню


    }
}
