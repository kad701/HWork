package javacore.Exeptions;


import java.util.ArrayList;
import java.util.NoSuchElementException;

public class Library {
    private ArrayList<Book> catalog;

    public Library(ArrayList<Book> catalog) {
        this.catalog = catalog;
    }

    public ArrayList<Book> getAllBooks() {
        return catalog;
    }

    public void addBook(Book book) {
        if (!catalog.contains(book))
            catalog.add(book);
        else for (Book element : catalog) {
            if (element.equals(book))
                element.setAvailableCopies(element.getAvailableCopies() + book.getAvailableCopies());
        }
    }

    public void takeBook(String author, String title) throws NoAvailableCopiesExeption, NoSuchElementException {  //добавить exeption
        int counter = catalog.size();
        for (Book book : catalog) {
            counter--;
            if ((book.getAuthor().equalsIgnoreCase(author)) && (book.getTitle().equalsIgnoreCase(title))) {
                if (book.getAvailableCopies() <= 0) {
                    throw new NoAvailableCopiesExeption();

                }
                book.setAvailableCopies(book.getAvailableCopies() - 1);
                break;
            }
            if (counter <= 0)
                throw new NoSuchElementException();
        }

    }

    public void returnBook(String author, String title) throws NoItemFoundExeption {

        int counter = catalog.size();
        for (Book book : catalog) {
            counter--;
            if ((book.getAuthor().equalsIgnoreCase(author)) && (book.getTitle().equalsIgnoreCase(title))) {
                book.setAvailableCopies(book.getAvailableCopies() + 1);
                break;
            }
            if (counter == 0)
                throw new NoItemFoundExeption();
        }

    }
}
