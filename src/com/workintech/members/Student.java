package com.workintech.members;

import com.workintech.books.Book;

import java.util.HashSet;
import java.util.Set;

public class Student extends MemberRecord{
    private Set<Book> borrowBooks;

    public Student(String name, String address, String phoneNo) {
        super(MemberType.STUDENT, name, address, phoneNo);
        this.borrowBooks = new HashSet<>();
    }

    public Set<Book> getBorrowBooks() {
        return borrowBooks;
    }

    public void setBorrowBooks(Set<Book> borrowBooks) {
        this.borrowBooks = borrowBooks;
    }

    public void borrowBook(Book book){
        borrowBooks.add(book);
    }

    @Override
    public void getMember() {
        System.out.println("\t Member Type: " + MemberType.STUDENT);
        System.out.println("\t Member Id: " + getMemberId());
        System.out.println("\t Name: " + getName());
        System.out.println("\t Address: " + getAddress());
        System.out.println("\t Phone: " + getPhoneNo());
        System.out.println("\t Books Issued: " + getNoBooksIssued());
        System.out.println("\t Max Book Limit: " + getMemberType().getMaxBookLimit());
        System.out.println("\t Pay per Book: " + getMemberType().getPayPerBook());
    }

    @Override
    public void incBookIssued() {
        if (getNoBooksIssued() < getMemberType().getMaxBookLimit()) {
            setNoBooksIssued(getNoBooksIssued() + 1);
            System.out.println("************ Congratulation ************");
            System.out.println("\n\t\t You borrowed one new book.");
            System.out.println("\n\t\tTotal books borrow: " + getNoBooksIssued());
        } else {
            System.out.println("\t\tMax book limit can borrowed is full. You don't borrow one new book.");
        }
    }

    @Override
    public void decBookIssued() {
        if (getNoBooksIssued() > 0) {
            setNoBooksIssued(getNoBooksIssued() - 1);
            System.out.println("*********** Thank You ***********");
            System.out.println("\n\t\t You decreased one book. Thank you.");
            System.out.println("\n\t\tTotal books borrow: " + getNoBooksIssued());
        } else {
            System.out.println("\t\t\tNo books to return.");
        }
    }

    @Override
    public void borrowList() {
        if (borrowBooks.isEmpty()) {
            System.out.println("\t\t\tNo books borrowed.");
        } else {
            System.out.println("\t\t\t Books borrowed by " + getName() + ":");
            for (Book book : borrowBooks) {
                System.out.println("- " + book.getTitle());
            }
        }
    }

    @Override
    public void payBill() {
        double totalAmount = getNoBooksIssued() * getMemberType().getPayPerBook();
        System.out.println("\t\t\t Total bill to pay: " + totalAmount);
    }
}
