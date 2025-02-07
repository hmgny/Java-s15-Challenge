package com.workintech.people;

import com.workintech.books.Book;

import java.util.Set;

public class Author extends Person {
    private Set<Book> books;

    public Author(String name) {
        super(name);
    }

    public void newBook(Book book){
         if (!this.books.contains(book)) {
                   this.books.add(book);
                   System.out.println(book.getTitle() + " added successfully.");
               } else {
                   System.out.println(book.getTitle() + " is already added, it cannot be added again.");
               }
    }

    @Override
    public void whoYouAre() {
        System.out.println("I am an author.");
    }
}
