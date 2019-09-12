
public class Ebook {
    private final String author;
    private final String title;
    private final String text;
/* you probably won't need to add any more instance variables for this class */

    public Ebook(String t) {
        author = SystemTools.findAuthor(t);
        title = SystemTools.findTitle(t);
        text = t;
    }

    public String getAuthor() {
        return author;
    }
    public String getTitle() {
        return title;
    }

    public Page getPage(int page, int charactersPerPage) {
        int start = page*charactersPerPage;
        int end;
        if (start+charactersPerPage > text.length()){
            end = text.length();
        }
        else {
            end = start+charactersPerPage;
        }
            String data = text.substring(start, end);
            return new Page(page,data);
    }

    public int numPages(int charactersPerPage) {
        if ((text.length()%charactersPerPage) == 0 ){
            return text.length()/charactersPerPage;
        }
        else {
            return (text.length() / charactersPerPage)+1;
        }
    }

    public String toString() {
        return this.getTitle() + " by " + this.getAuthor();
    }
}
