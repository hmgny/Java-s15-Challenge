package com.workintech.books;

import com.workintech.people.Author;

import java.util.Objects;

public class Book {
    private static int idCounter = 0;
    private int bookId;
    private String title;                //name
    private Author author;
    private double price;
    private boolean status;
    private String edition;
    private String dateOfPurchase;
    private String owner;
    private BookType bookType;

    public Book(String title, Author author, double price, String edition, String dateOfPurchase, BookType bookType){
        this.bookId = ++idCounter;
        this.title = title;
        this.author = author;
        this.price = price;
        this.status = true;
        this.edition = edition;
        this.dateOfPurchase = dateOfPurchase;
        this.owner = "Library";
        this.bookType = bookType;
    }

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getEdition() {
        return edition;
    }

    public void setEdition(String edition) {
        this.edition = edition;
    }

    public String getDateOfPurchase() {
        return dateOfPurchase;
    }

    public void setDateOfPurchase(String dateOfPurchase) {
        this.dateOfPurchase = dateOfPurchase;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public BookType getBookType() {
        return bookType;
    }

    public void setBookType(BookType bookType) {
        this.bookType = bookType;
    }

    public static long getIdCounter() {
        return idCounter;
    }

    public static void setIdCounter(int idCounter) {
        Book.idCounter = idCounter;
    }

    public void changeOwner() {
        if(!status){
            System.out.println(title +", borrowed by " +owner );
        }
    }

    public void display(){
        System.out.println("\n*********** Book Information************");
        System.out.println("ID: " + bookId);
        System.out.println("Name: " + title);
        System.out.println("Author: " + author.getName());
        System.out.println("Edition: " + edition);
        System.out.println("Status: " + (status ? "Mevcut" : "Ödünç Alındı"));
        System.out.println("Date of Purchase: " + dateOfPurchase);
        System.out.println("Price: " + price + "₺");
        System.out.println("Owner: " + owner);
    }

    public void updateStatus(){
            this.status = !status;
    }

    @Override
    public boolean equals(Object object) {
        if (object == null || getClass() != object.getClass()) return false;
        Book book = (Book) object;
        return bookId == book.bookId && Objects.equals(title, book.title);
    }

    @Override
    public int hashCode() {
        return Objects.hash(bookId, title);
    }
}
