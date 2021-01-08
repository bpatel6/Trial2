import java.net.URL;

public class Reader {

    // this array is for storing the Ebooks in the order they were added.
    // We require that you use it for that purpose.
    private final Ebook[] library;
    int size;
    int cap;
    private final int charperpage;
    public Ebook e;
    int currentPage;
    /* add more instance variables that you need
     */

    // Initialize all the private and instant variable
    Reader(int capacity, int charactersPerPage) {
        library = new Ebook[capacity];
        size = 0;
        cap = capacity;
        charperpage = charactersPerPage;
    }

    /* Copy/paste into here the methods listed in the PDF
       and then implement them
     */
    // Add book using URL
    public void addBook(URL url) {
        if (this.size >= cap) {
            throw new EbookException("Book couldn't be added");
        } else {
            this.library[this.size] = new Ebook(SystemTools.download(url));
            size += 1;
        }
    }

    // Add book given text input
    public void addBook(String text) {
        if (this.size >= cap) {
            throw new EbookException("Book couldn't be added");
        } else {
            this.library[this.size] = new Ebook(text);
            size += 1;
        }
    }

    // Deletes the book from a library given the bid # of the book
    public void deleteBook(int bid) {
        if (bid < 0 || bid >= size) {
            throw new EbookException("Invalid bid: " + bid);
        }
        if (library[bid].equals(e)) {
            e = null;
        }
        for (int j = bid; j < size - 1; j++) {
            library[j] = library[j + 1];
        }
        library[size - 1] = null;
        size--;
    }

    // Numbers of book in library
    public int numBooks() {
        return size;
    }

    // Print Titles of all book in the library
    public void printTitles() {
        for (int i = 0; i < size; i++) {
            String s = i + ": " + library[i].toString();
            System.out.println(s);
        }
    }

    // Opens the book to read
    public void openBook(int bid) {
        if (bid < 0 || bid >= size) {
            throw new EbookException("Invalid bid: " + bid);
        }
        e = library[bid];
        currentPage = 0;
    }

    // Turn the page base on charperpage and given page number
    public void turnToPage(int page) {
        if (e != null) {
            e.getPage(page, charperpage);
            currentPage = page;
        }
    }

    // returns the page that needs to be display based on inputs
    public String readPage() {
        if (e != null) {
            return String.valueOf(e.getPage(currentPage, charperpage));
        } else {
            throw new EbookException("Book is not open");
        }

    }

    // Returns title of the book
    public String titleOfBook() {
        return e.getTitle();
    }

    // Returns author of the book
    public String authorOfBook() {
        return e.getAuthor();
    }
}
