package Book_Library;

public class Library {
    public String libraryName;
    public Book book1;
    public Book book2;
    public Book book3;
    
    public void addBook(Book book, int slot) {
        switch (slot) {
            case 1 -> book1 = book;
            case 2 -> book2 = book;
            case 3 -> book3 = book;
        }
    }
    public void removeBook(int slot) {
        switch (slot) {
            case 1 -> book1 = null;
            case 2 -> book2 = null;
            case 3 -> book3 = null;            
        }
    }
    public void printLibraryDetails() {
        System.out.println("Library: " + libraryName + "\n");
        this.printBookDetails(book1);
        System.out.println("");
        this.printBookDetails(book2);
        System.out.println("");
        this.printBookDetails(book3); 
    }
    public void checkBookAvailability(int slot) {
        Book book = null;
        switch (slot) {
            case 1 -> book = book1;
            case 2 -> book = book2;
            case 3 -> book = book3;            
        }
        if (book != null) {
            System.out.println(book.title + " is available.");
        } else {
            System.out.println("Book in slot " + slot + " is not available.");
        }
    }
    public void updateBookPrice(int slot, double newPrice) {
        Book book = null;
        switch (slot) {
            case 1 -> book = book1;
            case 2 -> book = book2;
            case 3 -> book = book3;            
        }
        if (book != null) {
            book.updatePrice(newPrice);
            System.out.println("Updated price of " + book.title + " to $" + newPrice + ".");
        } else {
            System.out.println("No book in this slot.");
        }
    }
    public void printBookDetails(Book book) {
        if (book != null) {
            book.printDetails();
        } else {
            System.out.println("No book in this slot.");
        }

    }
    
}
