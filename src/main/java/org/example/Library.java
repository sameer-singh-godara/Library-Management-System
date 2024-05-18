package org.example;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.time.Instant;

public class Library {

    private final List<Book> totalBooks;
    private final List<Member> members;

    // Other fields, constructor, and methods

    public Library() {
        totalBooks = new ArrayList<>();
        members = new ArrayList<>();

    }


    // Methods to manage books (add, remove, list)
    public void addBook(Book book) {
        totalBooks.add(book);

//        System.out.println("A copy of Book with " + book.getBookId() + " Added Successfully");
//        System.out.println("---------------------------------");

    }

    public void removeBook(int bookId, String title) {// taking assumption that we are removing just one copy of the book.
        int flag = 0;
        for (Book book : totalBooks){
            if (book.getBookId() == bookId && title.equals(book.getTitle()) && book.getIssued() == 0){
                totalBooks.remove(book);
                System.out.println("---------------------------------");
                System.out.println("Book with Title: " + title + " and Id: "+ bookId + " Removed Successfully");
                flag = 1;
                break;
            }
        }
        if (flag == 0) {
            System.out.println("---------------------------------");
            System.out.println("Book with Title: " + title + " and Id: " + bookId + " Not Removed Successfully");
        }
    }

    public List<Book> getTotalBooks() {
        return totalBooks;
    }

    public List<Member> getAllMembers() {
        return members;
    }


    // Methods to manage members (register, remove, list)
    public void registerMember(Member member) {
        members.add(member);
        System.out.println("---------------------------------");
        System.out.println("Member with Name: " + member.getName() + " and his/her Id is: " + member.getMemberId() + " Added to Database Successfully");
//        System.out.println("---------------------------------");


    }

    public void removeMember(int memberId, String name) {
        for (Member member : members) {
            if (member != null && member.getMemberId() == memberId && name.equals(member.getName())) {
                members.remove(member);
                System.out.println("---------------------------------");
                System.out.println("Member with Name: "+ name + " and Member Id: " + memberId + " Removed Successfully");
//                System.out.println("---------------------------------");


            }
            else {
                System.out.println("---------------------------------");
                System.out.println("Member with Name: "+ name + " and Member Id: " + memberId + " Doesn't Exist");
//                System.out.println("---------------------------------");

            }
            break; // Exit the loop once the member is found
        }
    }

    public void issueBook(int bookId, String title, Member member){
        int flag = 0;
        for (Book book : totalBooks){
            if (book.getBookId() == bookId && title.equals(book.getTitle()) && member.getFine() == 0){
                book.setIssued(1);
                book.setMember(member);
                Instant currentTime = Instant.now();
                book.setIssueTime(currentTime);
                System.out.println("---------------------------------");
                System.out.println("Book with Title: " + book.getTitle() + " has been Issued to Member: " + member.getName() + " at " +  currentTime);
                flag = 1;
                break;
            }
        }
        if (flag == 0){
            System.out.println("---------------------------------");
            System.out.println("Book with Title: " + title + " has Not been Issued to Member: " + member.getName());
        }
    }


    public void returnBook(int bookId, String title, Member member){
        int flag = 0;
        for (Book book : totalBooks){
            if (book.getBookId() == bookId && title.equals(book.getTitle()) && book.getIssued() == 1 && (member.getName()).equals(book.getMember().getName())){
                book.setIssued(0);
                flag = 1;
                book.setMember(null);
                Instant issueTime = book.getIssueTime();
                Instant currentTime = Instant.now();
                long timeAfterDueDate = Duration.between(issueTime, currentTime).getSeconds();
                if (timeAfterDueDate>10){
                    int fineAmount = (int) ((timeAfterDueDate - 10)*3);
                    member.setFine(fineAmount);
                    System.out.println("---------------------------------");

                    System.out.println("Book with Title: " + book.getTitle() + " with Id: " + book.getBookId() + " Has been Returned Successfully, Please Pay Fine of Amount of " + member.getFine() + " for late submission of Book");
                }
                else {
                    System.out.println("---------------------------------");
                    System.out.println("Book with Title: " + book.getTitle() + " with Id: " + book.getBookId() + " Has been Returned Successfully, without any Fine");
                }
            }
        }
        if (flag == 0){
            System.out.println("Book with Title: " + title + " with Id: " + bookId + " Has Not been Returned Successfully");
        }
        System.out.println("---------------------------------");

    }

    public int randomTime(Book book, Member member) {
        int fineAmount = 0;
        if (book.getMember() == member) {
            Instant issueTime = book.getIssueTime();
            Instant currentTime = Instant.now();
            long timeAfterDueDate = Duration.between(issueTime, currentTime).getSeconds();
            if (timeAfterDueDate > 10) {
                fineAmount = (int) ((timeAfterDueDate - 10) * 3);
            }
        }
        return fineAmount;
    }

}
