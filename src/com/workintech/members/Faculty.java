package com.workintech.members;

import com.workintech.books.Book;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class Faculty extends MemberRecord{
    private Set<Book> borrowBooks;

    public Set<Book> getBorrowBooks() {
        return borrowBooks;
    }

    public void setBorrowBooks(Set<Book> borrowBooks) {
        this.borrowBooks = borrowBooks;
    }

    public Faculty(String name, String address, String phoneNo) {
        super(MemberType.FACULTY, name, address, phoneNo);
        this.borrowBooks = new HashSet<>();

    }

    public void borrowBook(Book book){
        borrowBooks.add(book);
    }

    @Override
    public void getMember() {
        System.out.println("Member Type: " + MemberType.FACULTY);
        System.out.println("Member Id: " + getMemberId());
        System.out.println("Name: " + getName());
        System.out.println("Address: " + getAddress());
        System.out.println("Phone: " + getPhoneNo());
        System.out.println("Books Issued: " + getNoBooksIssued());
        System.out.println("Max Book Limit: " + getMemberType().getMaxBookLimit());
        System.out.println("Pay per Book: " + getMemberType().getPayPerBook());
    }

    @Override
    public void incBookIssued() {
        if (getNoBooksIssued() < getMemberType().getMaxBookLimit()) {
            setNoBooksIssued(getNoBooksIssued() + 1);
            System.out.println("You borrowed one new book.");
            System.out.println("Total books borrow: " + getNoBooksIssued());
        } else {
            System.out.println("Max book limit can borrowed is full. You don't borrow one new book.");
        }
    }

    @Override
    public void decBookIssued() {
        if (getNoBooksIssued() > 0) {
            setNoBooksIssued(getNoBooksIssued() - 1);
            System.out.println("You decreased one book. Thank you.");
            System.out.println("Total books borrow: " + getNoBooksIssued());
        } else {
            System.out.println("No books to return.");
        }
    }

    @Override
    public void borrowList() {
        if (borrowBooks.isEmpty()) {
            System.out.println("No books borrowed.");
        } else {
            System.out.println("Books borrowed by " + getName() + ":");
            for (Book book : borrowBooks) {
                System.out.println("- " + book.getTitle());
            }
        }
    }

    @Override
    public void payBill() {
        double totalAmount = getNoBooksIssued() * getMemberType().getPayPerBook();
        System.out.println("Total bill to pay: " + totalAmount);
    }

    @Override
    public boolean equals(Object object) {
        if (object == null || getClass() != object.getClass()) return false;
        Faculty faculty = (Faculty) object;
        return Objects.equals(borrowBooks, faculty.borrowBooks);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(borrowBooks);
    }
}
