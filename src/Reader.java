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

    Reader(int capacity, int charactersPerPage) {
        library = new Ebook[capacity];
        size = 0;
        cap = capacity;
        charperpage = charactersPerPage;
    }

    /* Copy/paste into here the methods listed in the PDF
       and then implement them
     */

    public void addBook(URL url) {
        if (this.size == cap){
            throw new EbookException("Book couldn't be added");
        }
        else {
            this.library[this.size] = new Ebook(SystemTools.download(url));
            size += 1;
        }
    }

    public void addBook(String text) {
        if (this.size == cap){
            throw new EbookException("Book couldn't be added");
        }
        else {
            this.library[this.size] = new Ebook(text);
            size += 1;
        }
    }

    public void deleteBook(int bid) {
        if (bid < 0 || bid >= size){
            throw new EbookException("Invalid bid: " + bid);
        }
        if (library[bid].equals(e)){
            e = null;
        }
        for (int j = bid; j < size-1; j++){
            library[j] = library[j+1];
        }
        library[size-1] = null;
        size--;
    }

    public int numBooks(){
        return size;
    }

    public void printTitles(){
        for (int i = 0; i < size; i++){
            String s = i + ": " + library[i].toString();
            System.out.println(s);
        }
    }

    public void openBook(int bid){
        if (bid < 0 || bid >= size){
            throw new EbookException("Invalid bid: " + bid);
        }
        e = library[bid];
        currentPage = 0;
    }

    public void turnToPage(int page){
        if (e != null) {
            e.getPage(page, charperpage);
            currentPage = page;
        }
    }

    public String readPage(){
        if (e != null) {
            return String.valueOf(e.getPage(currentPage, charperpage));
        }
        else {
            throw new EbookException("Book is not open");
        }

    }

    public String titleOfBook(){
        return e.getTitle();
    }

    public String authorOfBook(){
        return e.getAuthor();
    }
}
