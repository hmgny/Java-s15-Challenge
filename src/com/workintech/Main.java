package com.workintech;

import com.workintech.books.Book;
import com.workintech.books.BookType;
import com.workintech.members.Faculty;
import com.workintech.members.MemberRecord;
import com.workintech.members.MemberType;
import com.workintech.members.Student;
import com.workintech.people.Author;
import com.workintech.people.Librarian;
import com.workintech.people.Reader;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        List<Author> authors = new ArrayList<>();
        Author author1 = new Author("Ahmet Yılmaz");
        Author author2 = new Author("Mehmet Kılıç");
        Author author3 = new Author("Ayşe Demir");
        Author author4 = new Author("Fatma Güler");
        Author author5 = new Author("Ali Veli");
        authors.add(author1);
        authors.add(author2);
        authors.add(author3);
        authors.add(author4);
        authors.add(author5);

        List<Book> books = new ArrayList<>();
        Book book1 = new Book("Java", author1, 45.99, "1st Edition", "2022-01-15", BookType.JOURNALS);
        Book book2 = new Book("Data", author2, 35.50, "2nd Edition", "2021-08-20", BookType.STUDYBOOKS);
        Book book3 = new Book("The Art", author3, 19.99, "1st Edition", "2020-03-11", BookType.MAGAZINES);
        Book book4 = new Book("Introduction", author1, 55.75, "3rd Edition", "2019-07-07", BookType.JOURNALS);
        Book book5 = new Book("Creative", author4, 42.30, "1st Edition", "2022-12-25", BookType.MAGAZINES);
        Book book6 = new Book("History", author2, 48.00, "1st Edition", "2018-02-18", BookType.STUDYBOOKS);
        Book book7 = new Book("The Lean", author5, 25.50, "1st Edition", "2021-10-05", BookType.STUDYBOOKS);
        Book book8 = new Book("Deep", author1, 75.99, "2nd Edition", "2021-06-17", BookType.STUDYBOOKS);
        Book book9 = new Book("Sapiens", author3, 39.90, "1st Edition", "2020-05-30", BookType.JOURNALS);
        Book book10 = new Book("Modern Art", author4, 33.20, "4th Edition", "2022-02-13", BookType.JOURNALS);

        Library library = new Library();
        library.newBook(book1);
        library.newBook(book2);
        library.newBook(book3);
        library.newBook(book4);
        library.newBook(book5);
        library.newBook(book6);
        library.newBook(book7);
        library.newBook(book8);
        library.newBook(book9);
        library.newBook(book10);

        Librarian librarian = new Librarian("Merve", "123456");
        Student student = new Student("Ali","İstanbul","052144556523");
        Faculty faculty = new Faculty("Ayşe", "İzmir", "054411447856");
        MemberRecord.getMemberList().add(student);
        MemberRecord.getMemberList().add(faculty);

        Scanner input = new Scanner(System.in);
        System.out.println("***************************************");
        System.out.println("1- Login as a librarian.");
        System.out.println("2- Login as a reader.");
        System.out.print("Make your choice: ");
        int userType = input.nextInt();
        input.nextLine();
        System.out.println("***************************************");

        if (userType == 1) {
            System.out.print("Librarian name: ");
            String name = input.nextLine();
            System.out.print("Password: ");
            String password = input.nextLine();

            if (librarian.getName().equals(name) && librarian.getPassword().equals(password)) {
                System.out.println(" \t\t\t Welcome, " + name + "!");
                boolean exit = false;

                while (!exit) {
                    System.out.println("**************************************");
                    System.out.println("1- Add book");
                    System.out.println("2- Delete book");
                    System.out.println("3- Update book");
                    System.out.println("4- List book information");
                    System.out.println("5- Exit");
                    System.out.print("Select the action you want to perform: ");
                    int choice = input.nextInt();
                    System.out.println("***************************************");
                    input.nextLine();

                    switch (choice) {
                        case 1:
                            System.out.println("The book you want to add is: ");
                            System.out.print("Title: ");
                            String title = input.nextLine();
                            System.out.print("Author: ");
                            Author author = new Author(input.nextLine());
                            System.out.print("Price: ");
                            double price = input.nextDouble();
                            input.nextLine();
                            System.out.print("Print: ");
                            String edition = input.nextLine();
                            System.out.print("Publication Date: ");
                            String yayinTarihi = input.nextLine();
                            System.out.print("1-JOURNALS  \n 2-STUDYBOOKS  \n 3-MAGAZINES \n type:");
                            int bookType =input.nextInt();
                            BookType type = null;
                            switch (bookType) {
                                case 1:
                                    type = BookType.JOURNALS;
                                    break;
                                case 2:
                                    type = BookType.STUDYBOOKS;
                                    break;
                                case 3:
                                    type = BookType.MAGAZINES;
                                    break;
                                default:
                                    System.out.println("\t\t\t Invalid selection!");
                                    break;
                            }
                            Book newBook = new Book(title, author, price, edition, yayinTarihi, type);
                            System.out.println("\t\t\t Book added successfully.");
                            break;


                        case 2:
                            System.out.print("Enter the name of the book you want to remove: ");
                            String removeTitle = input.nextLine();
                            Book bookToRemove = library.getBookByTitle(removeTitle);
                            if (bookToRemove != null) {
                                library.getBooks().remove(bookToRemove);
                                System.out.println("\t\t\t Book removed: " + removeTitle);
                            } else {
                                System.out.println("\t\t\tBook not found.");
                            }
                            break;

                        case 3:
                            System.out.print("Enter the name of the book you want to update: ");
                            String updateBook = input.nextLine();
                            Book bookToUpdate = library.getBookByTitle(updateBook);
                            if (bookToUpdate != null) {
                                System.out.print("New title: ");
                                String newTitle = input.nextLine();
                                System.out.print("New Author: ");
                                String newAuthor = input.nextLine();
                                System.out.print("New Price: ");
                                double newPrice = input.nextDouble();
                                System.out.print("New print: ");
                                String newEdition = input.nextLine();
                                System.out.print("New Publication Date: ");
                                String newDateOfPurchase = input.nextLine();
                                System.out.print("New Title: ");
                                System.out.print("\t\t 1-JOURNALS  \t 2-STUDYBOOKS  \t 3-MAGAZINES \t\t Type:");
                                int newBookType =input.nextInt();
                                BookType newType = null;
                                switch (newBookType) {
                                    case 1:
                                        newType = BookType.JOURNALS;
                                        break;
                                    case 2:
                                        newType = BookType.STUDYBOOKS;
                                        break;
                                    case 3:
                                        newType = BookType.MAGAZINES;
                                        break;
                                    default:
                                        System.out.println("\t\t\t Invalid selection!");
                                        break;
                                }
                               library.updateBook(bookToUpdate.getBookId(),newTitle,new Author(newAuthor),newPrice,newEdition,newDateOfPurchase,newType);
                            } else {
                                System.out.println("\t\t\t Book not found.");
                            }
                            break;
                        case 4:
                            System.out.println("\t1-Search by book name");
                            System.out.println("\t2-Search by author");
                            System.out.println("\t3-Search by id");
                            System.out.print("Choose a search type: ");
                            int searchType = input.nextInt();
                            input.nextLine();
                            switch(searchType){
                                case 1:
                                    System.out.print("Enter the book name: ");
                                    String bookName = input.nextLine();
                                    library.getBookByTitle(bookName).display();
                                    break;
                                case 2:
                                    System.out.print("Enter the author name: ");
                                    String authorName = input.nextLine();
                                    library.getBooksByAuthor(authorName).stream().filter(book ->book.getAuthor().getName().equals(authorName))
                                            .forEach(Book::display);
                                    break;
                                case 3:
                                    System.out.print("Enter the id number: ");
                                    int idNo = input.nextInt();
                                    library.getBookById(idNo).display();
                                    break;
                                default:
                                    System.out.println("You made an invalid selection.");
                            }
                        case 5:
                            exit = true;
                            break;
                        default:
                            System.out.println("\t\t\t You made an incorrect selection.");

                    }
                }
            }else{
                    System.out.println("\t\t\t You entered an incorrect username or password.");
                }
        } else if (userType == 2) {
            boolean exit = false;
            boolean validInput= false;

            while(validInput == false){
                System.out.println("\t Are you a member of the library? (Y/N)");
                String isMember = input.nextLine();
                if(isMember.equals("Y") || isMember.equals("y")){
                    validInput = true;
                }else if(isMember.equals("N") || isMember.equals("n")){
                    System.out.println("Create a new member record. ");
                    System.out.println("-----------------------------------------------");
                    System.out.print("Enter your name: ");
                    String name = input.nextLine();
                    System.out.print("Enter your address: ");
                    String address = input.nextLine();
                    System.out.print("Enter your phone number: ");
                    String phoneNo = input.nextLine();
                    System.out.println("1-Student");
                    System.out.println("2-Faculty");
                    System.out.print("Select member type: ");
                    int memberType = input.nextInt();
                    if(memberType == 1){
                        Student student1 = new Student(name, address,phoneNo);
                        validInput = true;
                        MemberRecord.getMemberList().add(student1);

                    }else if(memberType == 2){
                        Faculty faculty1 = new Faculty(name,address,phoneNo);
                        validInput = true;
                        MemberRecord.getMemberList().add(faculty1);
                    }else{
                        System.out.println("\t\t\t You made an incorrect selection.");
                    }

                }else {
                    System.out.println("\t\t\t You entered an incorrect letter ");
                }
                System.out.println("----------------------------------------");
            }
            System.out.print("\t\t 1-Student \t\t 2-Faculty \t\t\t who is this? :" );
            int whoIs = input.nextInt();

            while (!exit && validInput == true) {
                System.out.println("*********************************************");
                System.out.println("1- List all books");
                System.out.println("2- Show member information");
                System.out.println("3- Borrow a book");
                System.out.println("4- Return the borrowed books");
                System.out.println("5- List the borrowed books");
                System.out.println("6- Show the debt");
                System.out.println("7- Buy the book");
                System.out.println("8- Exit");
                System.out.print("Choose the action you want to perform: ");
                int choice = input.nextInt();
                input.nextLine();

                switch (choice) {
                    case 1:
                        System.out.println("\t\t\t All books in the library");
                        library.listBooks();
                        break;
                    case 2:
                        System.out.println("Please enter your name: ");
                        String memberName = input.nextLine();
                        if(whoIs==1 && student.getName().equals(memberName)){
                            student.getMember();
                        } else if (whoIs == 2 && faculty.getName().equals(memberName)) {
                            faculty.getMember();
                        }else{
                            System.out.println("\t\t You do not have a membership record. Please become a member.");
                        }
                        break;

                    case 3:
                        System.out.print("Enter the name of the book you want to borrow: ");
                        String borrowBookName = input.nextLine();
                        Book bookToBorrow = library.getBookByTitle(borrowBookName);
                        if(bookToBorrow != null){
                            if (whoIs == 1) {
                                if(MemberType.STUDENT.getMaxBookLimit()>= student.getBorrowBooks().size()){
                                    student.getBorrowBooks().add(library.getBookByTitle(borrowBookName));
                                    bookToBorrow.updateStatus();
                                    student.incBookIssued();
                                } else{
                                    System.out.println("\t\t Max book limit can borrowed is full. You don't borrow one new book.");
                                }
                            } else if (whoIs == 2) {
                                if(MemberType.FACULTY.getMaxBookLimit()>= faculty.getBorrowBooks().size()){
                                    faculty.getBorrowBooks().add(library.getBookByTitle(borrowBookName));
                                    bookToBorrow.updateStatus();
                                    faculty.incBookIssued();
                                } else{
                                    System.out.println("\t\t Max book limit can borrowed is full. You don't borrow one new book.");
                                }
                            } else {
                                System.out.println("!!!!!!!!Buraya düşmemesi lazım,düşerse hata!!!!!");
                            }
                        }else{
                            System.out.println("\t\t\t This book is not available in the library.");
                        }
                        break;
                    case 4:
                        System.out.print("Enter the name of the book you want to return: ");
                        String returnBookName = input.nextLine();
                        Book borrowList = library.getBookByTitle(returnBookName);
                        if(borrowList != null){
                            if (whoIs == 1) {
                                if(student.getBorrowBooks().contains(returnBookName)){
                                    student.getBorrowBooks().remove(borrowList);
                                    borrowList.updateStatus();
                                    student.decBookIssued();
                                }
                            } else if (whoIs == 2) {
                                if(faculty.getBorrowBooks().contains(returnBookName)){
                                    faculty.getBorrowBooks().remove(borrowList);
                                    borrowList.updateStatus();
                                    student.decBookIssued();
                                }
                            } else {
                                System.out.println("!!!!!!!!!Buraya düşmemesi lazım,düşerse hata!!!!!");
                            }
                        }else{
                            System.out.println("\t\t\t This book does not exist.");
                        }

                        break;
                    case 5:
                        if (whoIs == 1) {
                            if (!student.getBorrowBooks().isEmpty()) {
                                System.out.println("\t\t\t\t\tYou have borrowed books: ");
                                for (Book book : student.getBorrowBooks()) {
                                    System.out.println(" - " + book.getTitle());
                                }
                            } else {
                                System.out.println("\t\tYou have not borrowed any books yet.");
                            }
                        } else if (whoIs == 2) {
                            if (!faculty.getBorrowBooks().isEmpty()) {
                                System.out.println("\t\t\t\t\tYou have borrowed books: ");
                                for (Book book : faculty.getBorrowBooks()) {
                                    System.out.println(" - " + book.getTitle());
                                }
                            } else {
                                System.out.println("\t\tYou haven't borrowed any books yet.");
                            }
                        } else {
                            System.out.println("!!!!!!!!Buraya düşmemesi lazım.Düşerse whoIs de hata.!!!!!!");
                        }
                        break;
                    case 6:
                        if(whoIs == 1){
                            student.payBill();
                        }else if(whoIs == 2){
                            faculty.payBill();
                        }
                        break;
                    case 7:
                        System.out.print("Enter the title of the book you want to purchase: ");
                        String purchaseTitle = input.nextLine();
                        Book bookToPurchase = library.getBookByTitle(purchaseTitle);
                        if (bookToPurchase != null) {
                            System.out.println("\t\t\tBook successfully purchased: " + bookToPurchase.getTitle());
                        } else {
                            System.out.println("\t\t\tBook not found.");
                        }
                        break;
                    case 8:
                        exit = true;
                        break;
                }
            }
        }
    }
}
