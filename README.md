This project allows users to manage books and users, borrow and return books, and generate reports for borrowed and overdue books using CSV file storage.

🚀 Features

📖 View all books and their availability

👤 View registered users

📥 Borrow books (linked to a user)

📤 Return borrowed books

📊 Borrowed books report

⏰ Overdue books report (after 14 days)

💾 Persistent data storage using CSV files

🧠 Clean separation of concerns using OOP


🛠️ Technologies Used

Java

Object-Oriented Programming (OOP)

File I/O (BufferedReader & BufferedWriter)

Collections (ArrayList)

Java Time API (LocalDate, ChronoUnit)

CSV-based data persistence


📁 Project Structure
LibraryManagementSystem/
│
├── src/
│   └── library/
│       ├── Main.java          # Application entry point
│       ├── Library.java       # Core business logic
│       ├── Book.java          # Book model
│       ├── User.java          # User model
│       └── FileManager.java   # File I/O handling
│
├── data/
│   ├── books.csv              # Book storage
│   └── users.csv              # User storage
│
├── README.md
└── Library_Management_System_Assignment.pdf


▶️ How to Run the Project

Clone this repository:

Open the project in Eclipse or VS Code

Ensure the data/ folder exists at the project root

Run Main.java

Use the menu to interact with the system


🧠 How the System Works

Books and users are loaded from CSV files on startup

Borrowing a book:

Validates the user

Checks availability

Stores borrow date using LocalDate

Returning a book resets its status

Overdue books are calculated using ChronoUnit.DAYS

All changes are saved back to CSV files automatically


📊 Sample Menu Output
--- Library Management System ---
1. View Books
2. Borrow Book
3. Return Book
4. View User
5. Borrowed Books Report
6. Overdue Books Report
0. Exit
