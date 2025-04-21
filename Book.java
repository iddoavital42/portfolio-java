public class Book {
    private String title;
    private String author;
    private String id;
    private boolean available;

    public Book(String title, String author, String id) {
        this.title = title;
        this.author = author;
        this.id = id;
        this.available = true;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getId() {
        return id;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public String toString() {
        return "[" + id + "] \"" + title + "\" by " + author + (available ? " (Available)" : " (Borrowed)");
    }
}
