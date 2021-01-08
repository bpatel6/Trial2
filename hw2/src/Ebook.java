
public class Ebook {
    private final String author;
    private final String title;
    private final String text;

    /* you probably won't need to add any more instance variables for this class */
    /* takes a String representing the entire text of the book and set the variables */
    public Ebook(String t) {
        author = SystemTools.findAuthor(t);
        title = SystemTools.findTitle(t);
        text = t;
    }

    /*return the author and title of this Ebook, respectively*/
    public String getAuthor() {
        return author;
    }

    public String getTitle() {
        return title;
    }

    /*takes a page number and the charactersPerPage and returns that page of text.*/
    public Page getPage(int page, int charactersPerPage) {
        int start = page * charactersPerPage;
        int end;
        if (start + charactersPerPage > text.length()) {
            end = text.length();
        } else {
            end = start + charactersPerPage;
        }
        String data = text.substring(start, end);
        return new Page(page, data);
    }

    /*   Returns the number of pages in this Ebook. The charactersPerPage argument indicates how
       many characters fit on a page. Note that the last page might not be full!*/
    public int numPages(int charactersPerPage) {
        if ((text.length() % charactersPerPage) == 0) {
            return text.length() / charactersPerPage;
        } else {
            return (text.length() / charactersPerPage) + 1;
        }
    }

    /*returns the title and the author of this Ebook as a String.*/
    public String toString() {
        return this.getTitle() + " by " + this.getAuthor();
    }
}
