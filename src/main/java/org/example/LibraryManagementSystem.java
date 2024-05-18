package org.example;

import java.util.List;
import java.util.Scanner;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class LibraryManagementSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Library library = new Library();
        int bookId = 1;
        int memberId = 1;
        System.out.println("---------------------------------");
        System.out.println("Library Portal Initialized...");
        System.out.println("---------------------------------");

        while (true) {
            System.out.println("1. Enter as a librarian");
            System.out.println("2. Enter as a member");
            System.out.println("3. Exit");
            System.out.println("---------------------------------");
            System.out.println("Enter your choice: ");
            int choice1 = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character
            System.out.println("---------------------------------");

            if (choice1 == 1) {
                // Implement librarian menu
                int choice2;
                while (true) {
                    System.out.println("---------------------------------");
                    System.out.println("Librarian Menu:");
                    System.out.println("1. Register a Member");
                    System.out.println("2. Remove a Member");
                    System.out.println("3. Add a Book");
                    System.out.println("4. Remove a Book");
                    System.out.println("5. View all members along with their books and fines to be paid");
                    System.out.println("6. View all books");
                    System.out.println("7. Back");
                    System.out.println("---------------------------------");

                    System.out.println("Enter your choice: ");
                    choice2 = scanner.nextInt();
                    scanner.nextLine();
//                    System.out.println("---------------------------------");

                    if (choice2 == 1) {
                        Member member = new Member();
                        System.out.println("Enter Name: ");
                        String name = scanner.nextLine();
                        member.setName(name);
                        member.setMemberId(memberId);
                        memberId++;
                        System.out.println("Enter Phone Number: ");
                        double phoneNumber = scanner.nextDouble();
                        scanner.nextLine();
                        member.setPhoneNumber(phoneNumber);
                        System.out.println("Enter Age: ");
                        int age = scanner.nextInt();
                        scanner.nextLine();
                        member.setAge(age);
                        library.registerMember(member);
//                        System.out.println("Member Successfully registered in Database with Member Id: " + memberId);
                    } else if (choice2 == 2) {
                        System.out.print("Enter Member ID: ");
                        int mId = scanner.nextInt();
                        scanner.nextLine();
                        System.out.println("Enter Name: ");
                        String name = scanner.nextLine();
                        library.removeMember(mId, name);

//                        System.out.println("---------------------------------");

                    } else if (choice2 == 3) {
                        System.out.println("Enter Title: ");
                        String title = scanner.nextLine();

                        System.out.println("Enter Author of Book: ");
                        String author = scanner.nextLine();

                        System.out.println("Enter no. of Copies: ");
                        int copies = scanner.nextInt();
                        scanner.nextLine();
                        System.out.println("---------------------------------");
                        for (int i = 0; i < copies; i++) {
                            Book book = new Book();
                            book.setBookId(bookId);
                            bookId++;
                            book.setTitle(title);
                            book.setAuthor(author);
                            library.addBook(book);
//                            System.out.println("---------------------------------");
                            System.out.println("Book " + title + " Successfully Added in Database with Id " + book.getBookId());
//                            System.out.println("---------------------------------");
                        }

                    } else if (choice2 == 4) {
                        System.out.println("Enter Book ID: ");
                        int bId = scanner.nextInt();
                        scanner.nextLine();
                        System.out.println("Enter Title: ");
                        String title = scanner.nextLine();
                        library.removeBook(bId, title);
//                        System.out.println("---------------------------------");

                    }
                    else if (choice2 == 5) {
                        List<Member> members = library.getAllMembers();
                        List<Book> books = library.getTotalBooks();
                        int totalMembers = members.size();
                        if (totalMembers > 0){
                            System.out.println("The Registered Members in DataBase are: ");
                            int i = 1;
                            for (Member member : members) {
                                int bookCount = 0;
                                System.out.println(i + ". " + member.getName() + ": ");
                                i++;
                                int fineAmount = 0;
                                for (Book book : books) {
                                    if (book.getMember() == member) {
                                        int bookFine;
                                        System.out.println("Book Id: " + book.getBookId());
                                        System.out.println("Title of the Book: " + book.getTitle());
                                        System.out.println("Author of the Book: " + book.getAuthor());
                                        bookFine = library.randomTime(book, member);
                                        System.out.println("Fine Due to Book " + book.getTitle() + "is: " + bookFine + "Rs");
                                        fineAmount += bookFine;
                                        System.out.println("\n");
                                        bookCount++;
                                    }
                                }
                                if (bookCount == 0) {
                                    System.out.println("No book is issued by this Member Named: " + member.getName());
                                }
                                if (fineAmount == 0) {
                                    System.out.println("Fine Amount is: " + fineAmount + "Rs");
                                } else {
                                    System.out.println("Total Fine Amount is: " + fineAmount + "Rs");
                                }
                                System.out.println("---------------------------------");
                            }
                        }
                        else {
                            System.out.println("No Members are Registered in the DataBase");
                        }

                    }
                    else if (choice2 == 6) {
                        List<Book> books = library.getTotalBooks();
                        System.out.println("List of Books in DataBase:");
                        for (Book book : books) {
                            System.out.println("Book Id: " + book.getBookId());
                            System.out.println("Title of the Book: " + book.getTitle());
                            System.out.println("Author of the Book: " + book.getAuthor());
                            if (book.getIssued() == 1){
                                System.out.println(book.getTitle() + " is Issued");
                                System.out.println(book.getTitle() + " is Currently with " + (book.getMember()).getName() + " whose Id is: " + (book.getMember()).getMemberId());
                            }
                            else {
                                System.out.println(book.getTitle() + " is Not Issued");
                            }
                            System.out.println("---------------------------------");

                        }
                    }
                    else if (choice2 == 7) {
                        break;
                    }
                    else {
                        System.out.println("Wrong Choice, Try Again");
//                        System.out.println("---------------------------------");

                    }
                }
            }
            else if (choice1 == 2) {
                System.out.println("Enter your Name: ");
                String name = scanner.nextLine();
                System.out.println("Enter you Phone Number: ");
                double phoneNumber = scanner.nextDouble();
                scanner.nextLine();
                List<Member> members = library.getAllMembers();
                if (members.isEmpty()){
                    System.out.println("---------------------------------");
                    System.out.println("Member with Name: " + name + " and Phone Number: " + (int) phoneNumber + " Doesn't exists in the DataBase");
                    System.out.println("---------------------------------");

                }
                else {
                    int flag = 0;
                    for (Member member : members) { 
                        if (name.equals(member.getName()) && member.getPhoneNumber() == phoneNumber) {
                            flag = 1;
                            System.out.println("\nWelcome " + name + " Member Id: " + member.getMemberId() + "\n");
                            while (true) {
                                System.out.println("---------------------------------");
                                System.out.println("Member Menu:");
                                System.out.println("1. List of Available Books");
                                System.out.println("2. List of My Books");
                                System.out.println("3. Issue a Book");
                                System.out.println("4. Return a Book");
                                System.out.println("5. Pay Fine");
                                System.out.println("6. Back");
                                System.out.println("---------------------------------");
                                System.out.print("Enter your choice: ");

                                int choice3 = scanner.nextInt();
                                scanner.nextLine(); // Consume the newline character
                                //                             Implement member menu
                                System.out.println("---------------------------------");
                                if (choice3 == 1) {
                                    System.out.println("List of Available Books: ");
                                    List<Book> booksAvailable = library.getTotalBooks();
                                    for (Book book : booksAvailable) {
                                        if (book.getIssued() == 0) { // printing the books whose copies are greater than 0
                                            System.out.println("Book Id: " + book.getBookId());
                                            System.out.println("Title of the Book: " + book.getTitle());
                                            System.out.println("Author of the Book: " + book.getAuthor());
                                            System.out.println("---------------------------------");

                                        }
                                    }
                                } else if (choice3 == 2) {
                                    System.out.println("List of My Books: ");
                                    int flag1 = 0;
                                    List<Book> MyBooks = library.getTotalBooks();
                                    for (Book book : MyBooks) {
                                        if (book.getMember() == member) {
                                            flag1 = 1;
                                            System.out.println("Book Id: " + book.getBookId());
                                            System.out.println("Title of the Book: " + book.getTitle());
                                            System.out.println("Author of the Book: " + book.getAuthor());

                                            System.out.println("---------------------------------");
                                        }
                                    }
                                    if (flag1 == 0){
                                        System.out.println("There are no Issued Books with you");
                                        System.out.println("---------------------------------");

                                    }
                                } else if (choice3 == 3) {
                                    System.out.println("Enter Book Id: ");
                                    int bId = scanner.nextInt();
                                    scanner.nextLine();
                                    System.out.println("Enter Title of Book: ");
                                    String title = scanner.nextLine();
                                    List<Book> booksAvailable = library.getTotalBooks();
                                    int numberOfBooksIssued = 0;
                                    Book book1 = null;
                                    for (Book book : booksAvailable) {
                                        if (book.getMember() == member) {
                                            numberOfBooksIssued++;
                                            book1 = book;
                                        }
                                    }
                                    if (numberOfBooksIssued == 0) {
                                        library.issueBook(bId, title, member);
                                    }
                                    else if (numberOfBooksIssued == 1) {
                                        int bookFineTemp;
                                        bookFineTemp = library.randomTime(book1, member);
                                        if (bookFineTemp == 0) {
                                            library.issueBook(bId, title, member);
                                        }
                                        else {
                                            System.out.println("First Pay the Fine of " + bookFineTemp + " First Book then Issue another one");
                                        }
                                    }
                                    else {
                                        System.out.println("You Can't Issue New Book; First Return the Issued Books");
                                    }
                                }
                                else if (choice3 == 4) {
                                    System.out.println("Enter Book Id: ");
                                    int bId = scanner.nextInt();
                                    scanner.nextLine();
                                    System.out.println("Enter Title of Book: ");
                                    String title = scanner.nextLine();
                                    library.returnBook(bId, title, member);
                                }
                                else if (choice3 == 5) {
                                    System.out.println("Your Fine is " + member.getFine() + "Rs");
                                    if (member.getFine() > 0) {
                                        System.out.println("Enter the Amount you want to pay: ");
                                        int fineAmount = scanner.nextInt();
                                        scanner.nextLine();
                                        int leftAmount = member.getFine() - fineAmount;
                                        member.setFine(leftAmount);
                                        System.out.println("---------------------------------");
                                        System.out.println(fineAmount + "Rs Amount paid Successfully");
                                        System.out.println("Balance: " + leftAmount + "Rs");
                                    }
                                }
                                else if (choice3 == 6) {
                                    break;
                                }
                                else {
                                    System.out.println("---------------------------------");
                                    System.out.println("Wrong Choice, Try Again");
                                }
                            }
                        }
//                        else {
//                            System.out.println("---------------------------------");
//                            System.out.println("Member with Name: " + name + " and Phone Number: " + (int) phoneNumber + " Doesn't exists in DataBase");
//                            System.out.println("---------------------------------");
//
//                        }
                    }
                    if (flag == 0){
                        System.out.println("---------------------------------");
                        System.out.println("Member with Name: " + name + " and Phone Number: " + (int) phoneNumber + " Doesn't exists in DataBase");
                        System.out.println("---------------------------------");
                    }
                }
            }
            else if (choice1 == 3) {
                System.out.println("Thanks for visiting!");
                System.out.println("---------------------------------");
                System.exit(0);
            }
            else {
//                System.out.println("---------------------------------");

                System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}