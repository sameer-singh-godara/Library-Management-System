package org.example;
import java.time.Instant;

public class Book {

    private int BookId;
    private String title;
    private String author;
    private int issued = 0;
    private Member member;
    private Instant issueTime;

    // Other fields, constructor, and getters and setters


    public Instant getIssueTime() {
        return issueTime;
    }

    public void setIssueTime(Instant issueTime) {
        this.issueTime = issueTime;
    }

    public int getBookId() {
        return this.BookId;
    }

    public Member getMember() {
        return member;
    }

    public void setMember(Member member) {
        this.member = member;
    }

    public void setBookId(int bookId) {
        this.BookId = bookId;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getIssued() {
        return issued;
    }

    public void setIssued(int issued) {
        this.issued = issued;
    }

    public String getAuthor() {
        return this.author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
}
