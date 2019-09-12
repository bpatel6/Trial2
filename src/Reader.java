import java.net.URL;

public class Reader {

    // this array is for storing the Ebooks in the order they were added.
    // We require that you use it for that purpose.
    private final Ebook[] library;
    int size;
    int cap;
    private final int charperpage;
    private Ebook e;
    int currentPage;
    /* add more instance variables that you need
    */

    Reader(int capacity, int charactersPerPage) {
        library = new Ebook[capacity];
        size = 0;
        cap = capacity;
        charperpage = charactersPerPage;
        e = null;
    }

    /* Copy/paste into here the methods listed in the PDF
       and then implement them
     */

    public void addBook(URL url) {
        this.library[this.size] = new Ebook(SystemTools.download(url));
        size += 1;
    }

    public void addBook(String text) {
        if (this.size == cap){
            throw new EbookException("Book couldn't be added");
        }
        this.library[this.size] = new Ebook(text);
        size += 1;
    }

    public void deleteBook(int bid) {
        if (bid < 0 || bid >= size){
            throw new EbookException("Invalid bid: " + bid);
        }
        Ebook temp = library[bid];
        for (int j = bid; j < size-1; j++){
            library[j] = library[j+1];
        }
        library[size-1] = null;
        temp = null;
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
        e.getPage(0,charperpage);
        currentPage = 0;
    }

    public void turnToPage(int page){
        if (e == null){
            throw new EbookException("Book is not open");
        }
        else {
            e.getPage(page, charperpage);
            currentPage = page;
        }
    }

    public String readPage(){
        if (e == null){
            throw new EbookException("Book is not open");
        }
        return String.valueOf(e.getPage(currentPage,charperpage));
    }

    public String titleOfBook(){
        return e.getTitle();
    }

    public String authorOfBook(){
        return e.getAuthor();
    }
}
