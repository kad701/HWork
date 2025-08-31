package javacore.Exeptions;

import java.util.Objects;

public class Book {
    private String author;
    private String title;
    private int availableCopies;

    public String getAuthor() {
        return author;
    }

    public String getTitle() {
        return title;
    }

    public int getAvailableCopies() {
        return availableCopies;
    }

    public void setAvailableCopies(int availableCopies) {
        this.availableCopies = availableCopies;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return Objects.equals(author, book.author) && Objects.equals(title, book.title);
    }

    @Override
    public int hashCode() {
        return Objects.hash(author, title);
    }

    @Override
    public String toString() {
        return "BOOK{" +
                "author='" + author + '\'' +
                ", title='" + title + '\'' +
                ", availableCopies=" + availableCopies +
                '}';

    }

    public Book(String author, String title, int availableCopies) {
        this.author = author;
        this.title = title;
        this.availableCopies = availableCopies;
    }
}
