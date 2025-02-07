package com.workintech.books;

import com.workintech.people.Author;

public class Magazines extends Book {

    public Magazines(String title, Author author, double price, String edition, String dateOfPurchase) {
        super(title, author, price, edition, dateOfPurchase, BookType.MAGAZINES);
    }
}
