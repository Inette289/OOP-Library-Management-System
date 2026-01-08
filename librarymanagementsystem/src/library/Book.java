package library;

import java.time.LocalDate;

public class Book {
    private final int id;
    private final String title;
    private final String author;
    private boolean borrowed;
    private int borrowedByUserId;
    private LocalDate borrowDate;

    public Book(int id, String title, String author, boolean borrowed,
            int borrowedByUserId, LocalDate borrowDate) {

    this.id = id;
    this.title = title;
    this.author = author;
    this.borrowed = borrowed;

    if (borrowed) {
        this.borrowedByUserId = borrowedByUserId;
        this.borrowDate = borrowDate;
    } else {
        this.borrowedByUserId = -1;
        this.borrowDate = null;
    }
}

    public int getId() { return id; }
    public String getTitle() { return title; }
    public String getAuthor() { return author; }
    public boolean isBorrowed() { return borrowed; }
    public int getBorrowedByUserId() { return borrowedByUserId; }
    public LocalDate getBorrowDate() { return borrowDate; }

    public void borrowBook(int userId) {
        this.borrowed = true;
        this.borrowedByUserId = userId;
        this.borrowDate = LocalDate.now();
    }

    public void returnBook() {
        borrowed = false;
        borrowedByUserId = -1;
        borrowDate = null;
    }

    // Convert book to CSV line
    public String toCSV() {
        return id + "," + title + "," + author + "," + borrowed + "," + borrowedByUserId + "," +
               (borrowDate == null ? "" : borrowDate.toString());
    }

   @Override
public String toString() {
    return id + " | " + title + " | " + author + " | " +
           (borrowed ? "Borrowed" : "Available");
}
}