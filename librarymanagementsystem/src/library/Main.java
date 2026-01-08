package library;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Library library = new Library();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n--- Library Management System ---");
            System.out.println("1. View Books");
            System.out.println("2. Borrow Book");
            System.out.println("3. Return Book");
            System.out.println("4. View Users");
            System.out.println("5. Borrowed Books Report");
            System.out.println("6. Overdue Books Report");
            System.out.println("0. Exit");
            System.out.print("Choose an option: ");

            if (!scanner.hasNextInt()) {
                System.out.println("Please enter a valid number.");
                scanner.nextLine();
                continue;
            }

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1 -> library.displayBooks();

                case 2 -> {
                    System.out.print("Enter User ID: ");
                    if (!scanner.hasNextInt()) {
                        System.out.println("Invalid User ID.");
                        scanner.nextLine();
                        break;
                    }
                    int userId = scanner.nextInt();
                    scanner.nextLine();

                    System.out.print("Enter Book ID: ");
                    if (!scanner.hasNextInt()) {
                        System.out.println("Invalid Book ID.");
                        scanner.nextLine();
                        break;
                    }
                    int bookId = scanner.nextInt();
                    scanner.nextLine();

                    if (library.borrowBook(userId, bookId)) {
                        System.out.println("Book borrowed successfully.");
                    } else {
                        System.out.println("Borrow failed.");
                    }
                }

                case 3 -> {
                    System.out.print("Enter Book ID: ");
                    if (!scanner.hasNextInt()) {
                        System.out.println("Invalid Book ID.");
                        scanner.nextLine();
                        break;
                    }
                    int bookId = scanner.nextInt();
                    scanner.nextLine();

                    if (library.returnBook(bookId)) {
                        System.out.println("Book returned successfully.");
                    } else {
                        System.out.println("Return failed.");
                    }
                }

                case 4 -> library.viewUsers();
                case 5 -> library.borrowedBooksReport();
                case 6 -> library.overdueReport();

                case 0 -> {
                    System.out.println("Goodbye!");
                    scanner.close();
                    return;
                }

                default -> System.out.println("Invalid choice.");
            }
        }
    }
}