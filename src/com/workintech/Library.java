package com.workintech;

import com.workintech.books.Book;
import com.workintech.books.BookType;
import com.workintech.people.Author;
import com.workintech.people.Librarian;
import com.workintech.people.Reader;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Library {
   private List<Book> books = new ArrayList<>();
   private List<Author> authors =new ArrayList<>();
   private List<Reader> readers = new ArrayList<>();
   private Librarian librarian;

    public Library() {}

    public List<Book> getBooks() {
        return books;
    }
    public void setBooks(List<Book> books) {
        this.books = books;
    }
    public List<Reader> getReaders() {
        return readers;
    }
    public void setReaders(List<Reader> reader) {
        this.readers = reader;
    }


    public void newBook(Book book){
        if(!this.books.contains(book)){
            this.books.add(book);
        }else {
            System.out.println(book + "named has already been added. You cannot add it again.");
        }
    }

    public Book getBookById(int bookId) {
        for (Book book : books) {
            if (book.getBookId() == bookId) {
                return book;
            }
        }
        return null;
    }

    public Book getBookByTitle(String title) {
        for (Book book : books) {
            if (book.getTitle().equals(title)) {
                return book;
            }
        }
        return null;
    }

    public List<Book> getBooksByAuthor(String authorName) {
        for (Book book : books) {
            if (book.getAuthor().getName().equals(authorName)){
                return books;
            }
        }
        return null;
    }

    public void updateBook(int bookId, String newTitle, Author newAuthor, double newPrice, String newEdition, String newDateOfPurchase, BookType newBookType) {
        Book bookToUpdate = getBookById(bookId);
        if (bookToUpdate != null) {
            bookToUpdate.setTitle(newTitle);
            bookToUpdate.setAuthor(newAuthor);
            bookToUpdate.setPrice(newPrice);
            bookToUpdate.setEdition(newEdition);
            bookToUpdate.setDateOfPurchase(newDateOfPurchase);
            bookToUpdate.setBookType(newBookType);

            System.out.println("Book updated successfully: " + bookToUpdate.getTitle());
        } else {
            System.out.println("Book not found.");
        }
    }

    public void listBooks() {
        for (Book book : books) {
            System.out.println(book.getTitle());
        }
    }

    public void takeBackBook(Book book){
        if (!books.contains(book)) {
            books.add(book);
            System.out.println(book.getTitle() + " book was successfully returned.");
        } else {
            System.out.println("This book already exists in the library.");
        }
    }

    @Override
    public boolean equals(Object object) {

        if (object == null || getClass() != object.getClass()) return false;
        Library library = (Library) object;
        return Objects.equals(books, library.books) && Objects.equals(authors, library.authors) && Objects.equals(readers, library.readers) && Objects.equals(librarian, library.librarian);
    }

    @Override
    public int hashCode() {
        return Objects.hash(books, authors, readers, librarian);
    }
}
