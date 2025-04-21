import java.util.ArrayList;

public class User {
    private String name;
    private String userId;
    private ArrayList<Book> borrowedBooks;

    public User(String name, String userId) {
        this.name = name;
        this.userId = userId;
        this.borrowedBooks = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public String getUserId() {
        return userId;
    }

    public void borrowBook(Book book) {
        if (book.isAvailable()) {
            borrowedBooks.add(book);
            book.setAvailable(false);
            System.out.println(name + " borrowed \"" + book.getTitle() + "\".");
        } else {
            System.out.println("Book is already borrowed.");
        }
    }

    public void returnBook(Book book) {
        if (borrowedBooks.contains(book)) {
            borrowedBooks.remove(book);
            book.setAvailable(true);
            System.out.println(name + " returned \"" + book.getTitle() + "\".");
        } else {
            System.out.println("Book not borrowed by " + name + ".");
        }
    }

    public void showBorrowedBooks() {
        if (borrowedBooks.isEmpty()) {
            System.out.println(name + " has no borrowed books.");
        } else {
            System.out.println(name + " has borrowed:");
            for (Book book : borrowedBooks) {
                System.out.println("  - " + book);
            }
        }
    }
}
