📚 Library Management System

A console-based Library Management System built in Java.
This project allows managing books and users, borrowing and returning books, tracking overdue items, and persisting data using CSV files.

🚀 Features

•	Book Management

•	View all books

•	Borrow and return books

•	Tracks borrowing user and borrow date

•	User Management

•	View all users

•	Store unique user IDs

•	Reports

•	Borrowed Books Report

•	Overdue Books Report (books borrowed for more than 14 days)

•	Input Validation

•	Prevents crashes from invalid input (InputMismatchException, NumberFormatException)

•	Data Persistence

•	All data is stored in CSV files for persistence between runs

•	Robust Console UI

•	Menu-driven system with safe input handling


🏗️ Technologies Used

•	Language: Java

•	IDE: VS Code / Eclipse

•	File Handling: BufferedReader, BufferedWriter

•	Java Time API: LocalDate, ChronoUnit for overdue calculation

•	Data Storage: CSV files

•	OOP Concepts: Encapsulation, composition, modular design


🛠️ Installation & Running

•	Clone the repository

git clone https://github.com/yourusername/library-management-system.git

•	Open in IDE (VS Code, Eclipse, IntelliJ)

•	Ensure CSV files exist under data/ folder:

data/books.csv

data/users.csv

•	CSV headers are required, e.g., # id,title,author,borrowed,userId,borrowDate

•	Run the program

•	java -cp bin library.Main


🧩 Project Structure

library/

│

├─ Main.java   # Console UI

├─ Library.java      # Business logic

├─ Book.java         # Book model

├─ User.java         # User model

├─ FileManager.java  # File I/O

└─ data/

   ├─ books.csv
   
   └─ users.csv
   

📄 Sample CSV Format

•	books.csv

# id,title,author,borrowed,userId,borrowDate

1,The Alchemist,Paulo Coelho,false,-1,

2,1984,George Orwell,false,-1,


•	users.csv

# id,name

1,John Doe

2,Jane Smith

🎯 How it Works

•	Program starts and loads books/users from CSV.

•	Console menu allows the following actions:

•	View all books

•	Borrow a book

•	Return a book

•	View all users

•	Generate borrowed books report

•	Generate overdue books report

•	User input is validated to prevent crashes.

•	Changes are automatically saved to CSV files.


🧠 Key Concepts Demonstrated

•	Object-Oriented Programming (OOP)

•	Classes with encapsulated data

•	Modular design

•	File handling

•	Reading and writing CSV files

•	Exception Handling

•	Prevent InputMismatchException and NumberFormatException

•	Java Time API

•	Track borrowing and overdue days

•	Robust console interface

•	Menu system with input validation



🛠️ Future Improvements

•	Add a GUI (JavaFX/Swing)

•	Replace CSV files with a database (MySQL/PostgreSQL)

•	Add user authentication

•	Implement book search and filter features

•	Add fines or penalties for overdue books


📌 Author

Inette Badenhorst

LinkedIn: www.linkedin.com/in/inette-badenhorst-a66341143



