import java.net.URL;

public class Reader {

    // this array is for storing the Ebooks in the order they were added.
    // We require that you use it for that purpose.
    private final Ebook[] library;
    int size;
    private final int charperpage;
    /* add more instance variables that you need
    */

    Reader(int capacity, int charactersPerPage) {
        library = new Ebook[capacity];
        size = 0;
        charperpage = charactersPerPage;
    }

    /* Copy/paste into here the methods listed in the PDF
       and then implement them
     */

    public void addBook(URL url) {
        this.library[this.size] = new Ebook(SystemTools.download(url));
        size += 1;
    }

    public void addBook(String text) {
        this.library[this.size] = new Ebook(text);
        size += 1;
    }

    public void deleteBook(int bid) throws IndexOutOfBoundsException {
        if (bid < 0 || bid >= size){
            throw new IndexOutOfBoundsException("Invalid bid: " + bid);
        }
        Ebook temp = library[bid];
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
            library[i].toString();
        }
    }

    public void openBook(int bid) throws IndexOutOfBoundsException{
        if (bid < 0 || bid >= size){
            throw new IndexOutOfBoundsException("Invalid bid: " + bid);
        }
    }

    public void turnToPage(int page){

    }
    public String readPage(){

    }
}
