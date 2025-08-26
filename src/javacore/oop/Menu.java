package javacore.oop;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Menu {
    public List<Publication> initialPublications() {
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
        return publicationList;
    }

}
