package org.example;
import java.util.ArrayList;
import java.util.List;
public class Member {
    private int memberId;
    private String name;
    private int age;
    private double phoneNumber;
    private int fine = 0; // Fine balance

    // List to store borrowed books
    private final List<Book> borrowedBooks;
    public Member() {
        borrowedBooks = new ArrayList<>();
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public List<Book> getBorrowedBooks() {
        return borrowedBooks;
    }



    public void returnBook(Book book){
        borrowedBooks.remove(book);
    }


//    public Member
    // Other fields, constructor, and getters and setters


    public int getMemberId() {
        return memberId;
    }

    public void setMemberId(int memberId) {
        this.memberId = memberId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(double phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public int getFine() {
        return fine;
    }

    public void setFine(int fine) {
        this.fine = fine;
    }
}
