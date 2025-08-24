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



    public Library(List<Publication> publicationList) {
        this.publicationList = publicationList;
    }

    public void showPublications() {
        System.out.println(publicationList);
    }

    public void addPublicatoin(Publication publication) {
        publicationList.add(publication);
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

    public static List<Publication> getPublicationList() {
        return publicationList;
    }

    public void deletePublicationByAuthorAndTitle(Publication publication){

        publicationList.remove(publication);

    }

}
