package com.workintech.books;

import com.workintech.people.Author;

public class StudyBooks extends Book {

    public StudyBooks(String title, Author author, double price, String edition, String dateOfPurchase) {
        super(title, author, price, edition, dateOfPurchase, BookType.STUDYBOOKS);
    }

}
