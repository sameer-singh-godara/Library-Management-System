
# Library Management System
### Made By: Sameer Singh Godara (2022439)

The Library Management System is a Java-based application designed to efficiently manage library operations. 

## Classes
### 1) LibraryManagementSystem
The LibraryManagementSystem class serves as the entry point of the application. It allows both librarians and members to interact with the library system through a text-based menu system. It includes options to (achieved through nested while loop concept):

    1) Register and remove members.
    2) Add and remove books.
    3) View all members along with their borrowed books and fines.
    4) View all available books.
    5) Allow members to:
        a) List available books.
        b) List their borrowed books.
        c) Borrow books.
        d) Return books.
        e) Pay fines.

### 2) Library
The Library class is responsible for managing library data and operations. It includes methods to:

    1) Add and remove books from the library's collection.
    2) Register and remove members from the library's database.
    3) Issue and return books to/from members.
    4) Calculate fines for late book returns.
    5) Retrieve lists of all books and members.


### 3) Book
The Book class represents a book in the library system. It includes attributes such as:

    1) Book ID
    2) Title
    3) Author
    4) Issued status (0 for available, 1 for issued)
    5) Member (if the book is issued to a member)
    6) Issue time (timestamp when the book was issued)
    
    *The class provides getters and setters for these attributes.*

### 4) Member
The Member class represents a library member. It includes attributes such as:

    1) Member ID
    2) Name
    3) Age
    4) Phone number
    5) Fine balance (for late returns)
    6) The class also maintains a list of borrowed books by the member.
    
    *The claass provides methods to return books and getters and setters for its attributes.*


## Outline of the Code
    1) I have used nested while loops.
    2) Which takes input from the user.
    3) On the basis of appropriate command given by the user.
    4) Command fetches functions from Library class, which takes data from Book and Member class.
    5) There are 2 arraylist which contains all data of the members registered and books added to the library management system.
    6) It also asks extra information from user when needed.
    7) It is a Single Session System, hence data can't be stored for forever.
    7) In our system we have taken assumption that 1 day = 1 sec.
    8) I have tried to handle major errors
    9) Please ignore if any found.