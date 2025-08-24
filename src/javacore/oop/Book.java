package javacore.oop;

import java.util.Objects;

public class Book extends Publication implements Printable {
    private String isbn;

    public Book(String title, String author, int year, String isbn) {
        super(title, author, year);
        this.isbn = isbn;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Book book = (Book) o;
        return Objects.equals(isbn, book.isbn);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), isbn);
    }

    @Override
    public String toString() {
        return "BOOK{" +
                "isbn='" + isbn + '\'' +
                ", title='" + super.getTitle() + '\'' +
                ", Author='" + super.getAuthor() + '\'' +
                ", year=" + super.getYear() +
                "} ";
    }

    @Override
    public void printDetails() {
        System.out.println("Book details  " + isbn + "  " + super.toString());

    }

    @Override
    public String getType() {
        return "Book";
    }
}
