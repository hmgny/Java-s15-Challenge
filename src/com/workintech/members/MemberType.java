package com.workintech.members;

public enum MemberType {
    FACULTY(10, 50.0),
    STUDENT(5, 20.0);

    private final int maxBookLimit;
    private final double payPerBook;

    MemberType(int maxBookLimit, double payPerBook) {
        this.maxBookLimit = maxBookLimit;
        this.payPerBook = payPerBook;
    }

    public int getMaxBookLimit() {
        return maxBookLimit;
    }

    public double getPayPerBook() {
        return payPerBook;
    }
}
