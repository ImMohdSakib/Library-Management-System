# Library Management System

**The Library Management System** is a simple console-based application built using Java. It allows users to manage a collection of books by performing operations such as adding books, displaying the available books, borrowing, and returning them. The system is designed with basic Object-Oriented Programming (OOP) concepts and showcases inheritance, encapsulation, and user interaction using the console.
## Features

- **Add Books**: Users can add general books or specific science books to the library.
- **Display Books**: View a list of all the books currently in the library, including their availability.
- **Borrow Books**: Allows borrowing a book if it is available.
- **Return Books**: Return a borrowed book to the library.
- **Search by Book ID**: Find a book by its unique ID.

## How It Works

The program uses three main classes:
- **Book**: A base class representing a general book with properties like title, author, and availability status.
- **ScienceBook**: A subclass of `Book` for science-related books, including a specific subject.
- **Library**: A class that maintains a list of books and handles operations like adding, displaying, and searching for books.
  
The `LibraryManagementSystem` class acts as the entry point and contains the main menu logic.

## Class Descriptions

### 1. `Book`
This class defines the basic structure for a book with the following properties:
- **title**: Title of the book.
- **author**: Author of the book.
- **bookID**: Unique identifier for the book.
- **isAvailable**: A boolean indicating if the book is available for borrowing.

**Methods**:
- `borrowBook()`: Marks the book as borrowed if available.
- `returnBook()`: Marks the book as returned if it was borrowed.
- `toString()`: Provides a string representation of the book's details.

### 2. `ScienceBook`
This subclass inherits from `Book` and includes an additional property:
- **subject**: Specific subject related to the science book.

Overrides the `toString()` method to include subject information.

### 3. `Library`
Handles the collection of books in the library. Provides the following functionality:
- `addBook(Book book)`: Adds a book to the library.
- `displayBooks()`: Displays all books in the library.
- `findBookByID(int bookID)`: Finds a book by its ID.

## Usage

### Menu Options
When the program runs, it provides the following menu options:
1. **Add Book**: Prompts the user to enter book details. If it's a science book, the subject is also required.
2. **Display Books**: Lists all the books with their details.
3. **Borrow Book**: Allows borrowing a book by entering the book ID.
4. **Return Book**: Allows returning a book by entering the book ID.
5. **Exit**: Exits the program.

