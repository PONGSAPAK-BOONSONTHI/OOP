package Ex2;

public class Main {
    public static void main(String[] args) {
        Book b = new Book();
        String title = "The Great Gatsby";
        b.setTitle(title);
        String author = "F. Scott Fitzgerald";
        b.setAuthor(author);
        double price = 10.99;
        b.setPrice(price);
        System.out.println("\""+ b.getTitle() +"\" by "+ b.getAuthor() +" costs "+ b.getPrice() +" USD.");
        
    }
}
