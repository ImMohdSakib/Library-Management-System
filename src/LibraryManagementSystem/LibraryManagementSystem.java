package LibraryManagementSystem;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// Base class for Books
class Book {
    private String title;
    private String author;
    private int bookID;
    private boolean isAvailable;

    public Book(String title, String author, int bookID) {
        this.title = title;
        this.author = author;
        this.bookID = bookID;
        this.isAvailable = true; // Default availability
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public int getBookID() {
        return bookID;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void borrowBook() {
        if (isAvailable) {
            isAvailable = false;
            System.out.println("Book borrowed: " + title);
        } else {
            System.out.println("Sorry, the book is currently unavailable.");
        }
    }

    public void returnBook() {
        if (!isAvailable) {
            isAvailable = true;
            System.out.println("Book returned: " + title);
        } else {
            System.out.println("The book is already available in the library.");
        }
    }

    @Override
    public String toString() {
        return "BookID: " + bookID + ", Title: " + title + ", Author: " + author + ", Available: " + isAvailable;
    }
}

// Subclass for specific book categories
class ScienceBook extends Book {
    private String subject;

    public ScienceBook(String title, String author, int bookID, String subject) {
        super(title, author, bookID);
        this.subject = subject;
    }

    public String getSubject() {
        return subject;
    }

    @Override
    public String toString() {
        return super.toString() + ", Subject: " + subject;
    }
}

// Library class to manage books
class Library {
    private List<Book> books;

    public Library() {
        books = new ArrayList<>();
    }

    public void addBook(Book book) {
        books.add(book);
        System.out.println("Book added: " + book.getTitle());
    }

    public void displayBooks() {
        System.out.println("\nBooks in the Library:");
        for (Book book : books) {
            System.out.println(book);
        }
    }

    public Book findBookByID(int bookID) {
        for (Book book : books) {
            if (book.getBookID() == bookID) {
                return book;
            }
        }
        System.out.println("Book with ID " + bookID + " not found.");
        return null;
    }
}

// Main class to demonstrate the Library Management System
public class LibraryManagementSystem {
    public static void main(String[] args) {
        Library library = new Library();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nLibrary Menu:");
            System.out.println("1. Add Book");
            System.out.println("2. Display Books");
            System.out.println("3. Borrow Book");
            System.out.println("4. Return Book");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline

            switch (choice) {
                case 1:
                    System.out.print("Enter the title of the book: ");
                    String title = scanner.nextLine();
                    System.out.print("Enter the author of the book: ");
                    String author = scanner.nextLine();
                    System.out.print("Enter the book ID: ");
                    int bookID = scanner.nextInt();
                    scanner.nextLine(); // Consume the newline

                    System.out.print("Is this a Science book? (yes/no): ");
                    String isScience = scanner.nextLine();

                    if (isScience.equalsIgnoreCase("yes")) {
                        System.out.print("Enter the subject: ");
                        String subject = scanner.nextLine();
                        library.addBook(new ScienceBook(title, author, bookID, subject));
                    } else {
                        library.addBook(new Book(title, author, bookID));
                    }
                    break;

                case 2:
                    library.displayBooks();
                    break;

                case 3:
                    System.out.print("Enter the book ID to borrow: ");
                    int borrowID = scanner.nextInt();
                    Book bookToBorrow = library.findBookByID(borrowID);
                    if (bookToBorrow != null) {
                        bookToBorrow.borrowBook();
                    }
                    break;

                case 4:
                    System.out.print("Enter the book ID to return: ");
                    int returnID = scanner.nextInt();
                    Book bookToReturn = library.findBookByID(returnID);
                    if (bookToReturn != null) {
                        bookToReturn.returnBook();
                    }
                    break;

                case 5:
                    System.out.println("Exiting the Library Management System. Goodbye!");
                    scanner.close();
                    return;

                default:
                    System.out.println("Invalid choice! Please try again.");
                    break;
            }
        }
    }
}
