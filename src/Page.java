public class Page {
    private int pagenum;
    private String content;

    public Page(int pagenumber, String contents) {
        pagenum = pagenumber;
        content = contents;
    }

    public String toString() {
        return content + " <" + pagenum + ">";
    }
}
