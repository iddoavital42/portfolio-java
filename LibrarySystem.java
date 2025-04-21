import java.util.ArrayList;
import java.util.Scanner;

public class LibrarySystem {
    private static ArrayList<Book> books = new ArrayList<>();
    private static ArrayList<User> users = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        boolean running = true;
        while (running) {
            System.out.println("\n📚 Welcome to the Library System 📚");
            System.out.println("1. Add Book");
            System.out.println("2. Add User");
            System.out.println("3. Show All Books");
            System.out.println("4. Show All Users");
            System.out.println("5. Borrow Book");
            System.out.println("6. Return Book");
            System.out.println("0. Exit");
            System.out.print("Choose an option: ");

            int choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 1:
                    addBook();
                    break;
                case 2:
                    addUser();
                    break;
                case 3:
                    showBooks();
                    break;
                case 4:
                    showUsers();
                    break;
                case 5:
                    borrowBook();
                    break;
                case 6:
                    returnBook();
                    break;
                case 0:
                    running = false;
                    break;
                default:
                    System.out.println("Invalid option.");
                    break;
            }
        }
    }
    private static void addBook() {
        System.out.print("Title: ");
        String title = scanner.nextLine();
        System.out.print("Author: ");
        String author = scanner.nextLine();
        System.out.print("Book ID: ");
        String id = scanner.nextLine();
        books.add(new Book(title, author, id));
        System.out.println("✅ Book added.");
    }

    private static void addUser() {
        System.out.print("User name: ");
        String name = scanner.nextLine();
        System.out.print("User ID: ");
        String id = scanner.nextLine();
        users.add(new User(name, id));
        System.out.println("✅ User added.");
    }

    private static void showBooks() {
        if (books.isEmpty()) {
            System.out.println("No books in the library.");
        } else {
            for (Book book : books) {
                System.out.println(book);
            }
        }
    }

    private static void showUsers() {
        if (users.isEmpty()) {
            System.out.println("No users in the system.");
        } else {
            for (User user : users) {
                System.out.println("- " + user.getName() + " (ID: " + user.getUserId() + ")");
                user.showBorrowedBooks();
            }
        }
    }

    private static void borrowBook() {
        System.out.print("User ID: ");
        String userId = scanner.nextLine();
        System.out.print("Book ID: ");
        String bookId = scanner.nextLine();

        User user = findUserById(userId);
        Book book = findBookById(bookId);

        if (user != null && book != null) {
            user.borrowBook(book);
        } else {
            System.out.println("❌ User or book not found.");
        }
    }

    private static void returnBook() {
        System.out.print("User ID: ");
        String userId = scanner.nextLine();
        System.out.print("Book ID: ");
        String bookId = scanner.nextLine();

        User user = findUserById(userId);
        Book book = findBookById(bookId);

        if (user != null && book != null) {
            user.returnBook(book);
        } else {
            System.out.println("❌ User or book not found.");
        }
    }

    private static User findUserById(String id) {
        for (User user : users) {
            if (user.getUserId().equals(id)) return user;
        }
        return null;
    }

    private static Book findBookById(String id) {
        for (Book book : books) {
            if (book.getId().equals(id)) return book;
        }
        return null;
    }
}
