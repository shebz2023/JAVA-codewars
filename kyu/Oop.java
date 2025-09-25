// Library Management System :)
// Create a Java application that models a library with books, users, and borrowing functionality.

// Requirements:
// Book Class

// Properties: title, author, ISBN, isBorrowed

// Methods: borrowBook(), returnBook()

// User Class

// Properties: name, userId, borrowedBooks (list)

// Methods: borrowBook(Book), returnBook(Book)

// Library Class

// Properties: books (collection), users (collection)

// Methods: addBook(), registerUser(), findBook(), findUser()


import java.util.ArrayList;

class Book {
    String title;
    String author;
    Boolean isBorrowed;
    String ISBN;

    public Book(String title, String author, String ISBN) {
        this.title = title;
        this.author = author;
        this.ISBN = ISBN;
        this.isBorrowed = false;
    }

    public void borrowBook() {
        this.isBorrowed = true;
        System.out.println("you borrowed this book");
    }

    public void returnBook() {
        this.isBorrowed = false;
        System.out.println("you returned this book");
    }

    @Override
    public String toString() {
        return title + " by " + author;
    }
}

class User {
    String name;
    int userId;
    ArrayList<Book> borrowedBooks = new ArrayList<>();

    public User(String name, int userId) {
        this.name = name;
        this.userId = userId;
    }

    public void borrowBook(Book book) {
        this.borrowedBooks.add(book);
        book.isBorrowed = true;
        System.out.println("the book borrowed successfully");
    }

    public void returnBook(Book book) {
        borrowedBooks.remove(book);
        book.isBorrowed = false;
        System.out.println("the book returned successfully");
    }

    @Override
    public String toString() {
        return name + " (ID: " + userId + ")";
    }
}

class Library {
    ArrayList<Book> booksCollection;
    ArrayList<User> usersCollection;

    public Library() {
        booksCollection = new ArrayList<>();
        usersCollection = new ArrayList<>();
    }

    public void addBook(Book book) {
        booksCollection.add(book);
        System.out.println("Added a book to the library");
    }

    public Book findBook(String title) {
        for (Book book : booksCollection) {
            if (book.title.equals(title)) {
                return book;
            }
        }
        System.out.println("Book not found");
        return null;
    }

    public void registerUser(User user) {
        usersCollection.add(user);
        System.out.println("the user Added");
    }

    public User findUser(String name) {
        for (User user : usersCollection) {
            if (user.name.equals(name)) {
                return user;
            }
        }
        System.out.println("User not found");
        return null;
    }
}

public class Oop {
    public static void main(String[] args) {
        Library library = new Library();

        Book book1 = new Book("book1", "writer one", "isbn1");
        Book book2 = new Book("book2", "writer two", "isbn2");

        User user1 = new User("Alice", 1);

        library.addBook(book1);
        library.addBook(book2);
        library.registerUser(user1);

        user1.borrowBook(book1);
        user1.returnBook(book1);

        Book foundBook = library.findBook("book1");
        User foundUser = library.findUser("Alice");
    }
}