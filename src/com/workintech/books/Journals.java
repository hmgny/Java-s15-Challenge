package com.workintech.books;

import com.workintech.people.Author;

public class Journals extends Book {


    public Journals(String title, Author author, double price, String edition, String dateOfPurchase) {
        super(title, author, price, edition, dateOfPurchase, BookType.JOURNALS);
    }
}
