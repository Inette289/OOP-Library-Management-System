package library;

import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;

public class FileManager {
   private static final String BOOK_FILE = "data/books.csv";
    private static final String USER_FILE = "data/users.csv";

    // Load books from CSV
    public static ArrayList<Book> loadBooks() {
        ArrayList<Book> books = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(BOOK_FILE))) {
            String line;

            while ((line = br.readLine()) != null) {
                line = line.trim();
                if (line.startsWith("#") || line.toLowerCase().startsWith("id")) {
                continue;
}
                if (line.isEmpty()) continue;
                String[] data = line.split(",",-1);
                if (data.length < 6) continue;

                int id = Integer.parseInt(data[0].trim());
                String title = data[1].trim();
                String author = data[2].trim();
                boolean borrowed = Boolean.parseBoolean(data[3].trim());
                int userId = Integer.parseInt(data[4].trim());

                LocalDate borrowDate = data[5].trim().isEmpty()
                 ? null 
                 : LocalDate.parse(data[5].trim());

                books.add(new Book(id, title, author, borrowed, userId, borrowDate));
            }

        } catch (IOException e) {
           System.out.println("Error loading books: " + e.getMessage());
        }
        return books;
    }

   public static void saveBooks(ArrayList<Book> books) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(BOOK_FILE))) {
            for (Book book : books) {
                bw.write(book.toCSV());
                bw.newLine();
            }
        } catch (IOException e) {
            System.out.println("Error saving books: " + e.getMessage());
        }
    }

    // ------------------ Users ------------------
    public static ArrayList<User> loadUser() {
        ArrayList<User> users = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(USER_FILE))) {
            String line;
            while ((line = br.readLine()) != null) {
                line = line.trim();
                if (line.isEmpty()) continue;
                String[] data = line.split(",");
                if (data.length != 2) continue;
                int id = Integer.parseInt(data[0].trim());
                String name = data[1].trim();
                users.add(new User(id, name));
            }
        } catch (IOException e) {
            System.out.println("Error loading users: " + e.getMessage());
        }
        return users;
    }

    public static void saveUsers(ArrayList<User> users) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(USER_FILE))) {
            for (User user : users) {
                bw.write(user.getUserId() + "," + user.getName());
                bw.newLine();
            }
        } catch (IOException e) {
            System.out.println("Error saving users: " + e.getMessage());
        }
    }
}


