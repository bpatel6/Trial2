import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

public class EbookTest {

    @Test
    public void testEbookCreate() {
        Ebook e = new Ebook("Project Gutenberg's Frankenstein, by Mary Wollstonecraft (Godwin) Shelley\n" +
                "\n" +
                "This eBook is for the use of anyone anywhere at no cost and with\n" +
                "almost no restrictions whatsoever.  You may copy it, give it away or\n" +
                "re-use it under the terms of the Project Gutenberg License included\n" +
                "with this eBook or online at www.gutenberg.net\n");

        assertEquals("Mary Wollstonecraft (Godwin) Shelley", e.getAuthor());
        assertEquals("Frankenstein", e.getTitle());
    }

    @Test
    public void testEbookNumPages() {
        Ebook e = new Ebook("Project Gutenberg's Frankenstein, by Mary Wollstonecraft (Godwin) Shelley\n" +
                "\n" +
                "This eBook is for the use of anyone anywhere at no cost and with\n" +
                "almost no restrictions whatsoever.  You may copy it, give it away or\n" +
                "re-use it under the terms of the Project Gutenberg License included\n" +
                "with this eBook or online at www.gutenberg.net\n");

        assertEquals(324, e.numPages(1));
        assertEquals(162, e.numPages(2));
        assertEquals(108, e.numPages(3));
        assertEquals(81, e.numPages(4));
        assertEquals(65, e.numPages(5));
        assertEquals(54, e.numPages(6));
        assertEquals(27, e.numPages(12));
        assertEquals(3, e.numPages(120));
        assertEquals(1, e.numPages(1200));
    }

    @Test
    public void testEbookGetPage() {
        Ebook e = new Ebook("Project Gutenberg's Frankenstein, by Mary Wollstonecraft (Godwin) Shelley\n" +
                "\n" +
                "This eBook is for the use of anyone anywhere at no cost and with\n" +
                "almost no restrictions whatsoever.  You may copy it, give it away or\n" +
                "re-use it under the terms of the Project Gutenberg License included\n" +
                "with this eBook or online at www.gutenberg.net\n");

        assertEquals("j <3>", e.getPage(3, 1).toString());

        assertEquals("oj <1>", e.getPage(1, 2).toString());

        assertEquals("in, <10>", e.getPage(10, 3).toString());

        assertEquals("w.gutenberg.net\n <4>", e.getPage(4, 77).toString());
    }


}