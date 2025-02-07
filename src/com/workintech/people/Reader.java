package com.workintech.people;

import java.util.Set;

public class Reader extends Person {
    private Set<Reader> readers;

    public Reader(String name) {
        super(name);
    }

    public void purchaseBook(){}
    public void borrowBook(){}
    public void returnBook(){}
    public void showBook(){}

    @Override
    public void whoYouAre(){
        System.out.println("I am a reader");
    }

}
