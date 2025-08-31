package javacore.Exeptions;

import java.util.ArrayList;


public class InitialCatalog {
    public ArrayList<Book> initialCatalog(){
        // добавим несколько книг в каталог
        Book aivengo = new Book("Valter Scott", "Aivengo", 0);
        Book theLastKingdom = new Book("Bernard Cornuwell", "The Last Kingdom", 4);
        Book withFireAndSward = new Book("Genrich Senkevich", "With fire and sward", 2);
        ArrayList<Book> catalog = new ArrayList<>();
        catalog.add(aivengo);
        catalog.add(theLastKingdom);
        catalog.add(withFireAndSward);
        return catalog;
    }
}
