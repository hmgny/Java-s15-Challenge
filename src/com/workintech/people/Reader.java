package com.workintech.people;

import java.util.Objects;
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

    @Override
    public boolean equals(Object object) {
        if (object == null || getClass() != object.getClass()) return false;
        Reader reader = (Reader) object;
        return Objects.equals(readers, reader.readers);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(readers);
    }
}
