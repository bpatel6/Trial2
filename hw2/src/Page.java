public class Page {
    private int pagenum;
    private String content;

    public Page(int pagenumber, String contents) {
        pagenum = pagenumber;
        content = contents;
    }

    /*a class’s toString method knows how to return a String representation of the object.
    In the case of Page, the String returned by toString must be the contents of the page*/

    public String toString() {
        return content + " <" + pagenum + ">";
    }
}
