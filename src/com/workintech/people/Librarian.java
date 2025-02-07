package com.workintech.people;

import com.workintech.books.Book;
import com.workintech.Library;

import java.util.List;
import java.util.Objects;

public class Librarian {
    private String name;
    private String password;

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }

    public Librarian(String name, String password) {
        this.name = name;
        this.password = password;
    }

    public void searchBook(List<Book> books, String title) {
        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(title)) {
                book.display();
                return;
            }
        }
        System.out.println("Book isn't found.");
    }


    public boolean verifyMember(Library library, int memberId){
        for (Reader reader : library.getReaders()) {
            if (reader.getName().equalsIgnoreCase(String.valueOf(memberId))) {
                System.out.println("Reader found " + reader.getName());
                return true;
            }
        }
        System.out.println("No reader found.");
        return false;
    }



    public void issueBook(Book book) {
        if (book.getOwner().equals("Library")) {
            book.updateStatus();  //
        } else {
            System.out.println("This book is not in the library right now.");
        }
    }

    public void calculateFine(int daysLate) {
        double fine = daysLate * 2.0;
        System.out.println("Late payment fee: " + fine + "₺");
    }

    public void createBill(double fine) {
        System.out.println("Your total dept: " + fine + "₺");
    }

    public void returnBook(Book book){
        if (!book.getOwner().equals("Library")) {
            book.updateStatus();
            System.out.println(book.getTitle() + " was taken back.");
        } else {
            System.out.println("This book is already in the library.");
        }
    }

    @Override
    public boolean equals(Object object) {
        if (object == null || getClass() != object.getClass()) return false;
        Librarian librarian = (Librarian) object;
        return Objects.equals(name, librarian.name) && Objects.equals(password, librarian.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, password);
    }
}
