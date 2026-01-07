package library;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;

//Stores and manages book collection
public class Library {
   private final ArrayList<Book> books;   
    private final ArrayList<User> users;
    private static final int MAX_BORROW_DAYS = 14;

    public Library() {
        books = FileManager.loadBooks();
        users = FileManager.loadUsers();
    }

    // ------------------ Books ------------------
     public void displayBooks() {
    System.out.println("\n--- Books ---");

    if (books.isEmpty()) {
        System.out.println("No books available.");
        return;
    }

    for (Book book : books) {
        System.out.println(book);
    }
}
    public Book getBookById(int id) {
        for (Book book : books){
            if (book.getId() == id)
                return book;
    }
        return null;   
}


    public void save() {
        FileManager.saveBooks(books);
        FileManager.saveUsers(users);
    }

    // ------------------ User ------------------
   public void viewUsers() {
        System.out.println("\n--- Users ---");
        for (User user : users) {           // ✅ users is visible here
            System.out.println(user);
        }
    }

    public User getUserById(int id) {
        for (User user : users) {
            if (user.getUserId() == id)
                return user;
            }
        return null;
    }

    public boolean borrowBook(int userId, int bookId) {
    User user = getUserById(userId);
    Book book = getBookById(bookId);

    if (user == null || book == null || book.isBorrowed()) {
        return false;
    }

    book.borrowBook(userId);
    save();
    return true;
}

public boolean returnBook(int bookId) {
    Book book = getBookById(bookId);

    if (book == null || !book.isBorrowed()) {
        return false;
    }

    book.returnBook();
    save();
    return true;
}
    // ------------------ Reports ------------------
    public void borrowedBooksReport() {
        System.out.println("\n--- Borrowed Books Report ---");
        for (Book book : books) {
            if (book.isBorrowed()) {
                 System.out.println(book.getId() + " | " + book.getTitle() +
                        " | Borrowed by User ID: " + book.getBorrowedByUserId() +
                        " | Date: " + book.getBorrowDate());
            }
        }
    }

    public void overdueReport() {
        System.out.println("\n--- Overdue Books (14 days) ---");
        for (Book book : books) {
            if (book.isBorrowed() && book.getBorrowDate() != null) {
    long days = ChronoUnit.DAYS.between(book.getBorrowDate(), LocalDate.now());
                if (days > MAX_BORROW_DAYS) {
                    System.out.println(book.getId() + " | " + book.getTitle() +
                            " | Overdue by " + (days - 14) + " days");
                }
            }
        }
    }
}