package javacore.oop;

import java.util.Objects;

public abstract class Publication implements Printable {
    private String title;
    private String Author;
    private int year;
    private static int publicationCount = 0;

    public Publication(String title, String author, int year) {
        this.title = title;
        Author = author;
        this.year = year;
    }

    public abstract String getType();


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return Author;
    }

    public void setAuthor(String author) {
        Author = author;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Publication that = (Publication) o;
        return year == that.year && Objects.equals(title, that.title) && Objects.equals(Author, that.Author);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, Author, year);
    }

    @Override
    public String toString() {
        return "{" +
                "title='" + title + '\'' +
                ", Author='" + Author + '\'' +
                ", year=" + year +
                '}';
    }
}
