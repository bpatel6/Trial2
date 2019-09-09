/* UNCOMMENT THIS FILE WHEN YOU ARE READY


import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

public class ReaderTest {
    private static String text1 =
            "Project Gutenberg's Frankenstein, by Mary Wollstonecraft (Godwin) Shelley\n" +
            "This eBook is for the use of anyone anywhere at no cost and without restr\n";

    private static String text2 =
            "The Project Gutenberg EBook of Beowulf\n" +
            "This eBook is for the use of anyone in\n" +
            "almost no restrictions whatsoever. You\n";

    private static String text3 = "The Project Gutenberg EBook of TestBook";

    @Test
    public void testAdd() {
        Reader ebr = new Reader(2, 1);
        ebr.addBook(text1);
        ebr.addBook(text2);
        assertEquals(2, ebr.numBooks());
    }

    @Test
    public void testAddFail() {
        Reader ebr = new Reader(2, 1);
        ebr.addBook(text1);
        ebr.addBook(text2);
        Assertions.assertThrows(EbookException.class, () -> {
            ebr.addBook(text1); // should cause EbookException
        });
    }

    @Test
    public void testDelete() {
        Reader ebr = new Reader(2, 1);
        ebr.addBook(text1);
        ebr.addBook(text2);
        ebr.deleteBook(1);
        assertEquals(1, ebr.numBooks());
    }

    @Test
    public void testOpenFail() {
        Reader ebr = new Reader(4, 1);
        ebr.addBook(text1);
        ebr.addBook(text2);
        Assertions.assertThrows(EbookException.class, () -> {
            ebr.openBook(3);  // should cause EbookException
        });
    }

    @Test
    public void testReadFail() {
        Reader ebr = new Reader(4, 1);
        ebr.addBook(text1);
        ebr.addBook(text2);

        ebr.turnToPage(3);
        Assertions.assertThrows(EbookException.class, () -> {
            ebr.readPage(); // should cause EbookException
        });
    }

    @Test
    public void testOpenRead() {
        Reader ebr = new Reader(4, 21);
        ebr.addBook(text1);
        ebr.addBook(text2);

        ebr.openBook(1);
        ebr.turnToPage(0);
        assertEquals("The Project Gutenberg <0>", ebr.readPage());

        ebr.openBook(0);
        ebr.turnToPage(0);
        assertEquals("Project Gutenberg's F <0>", ebr.readPage());
        ebr.turnToPage(3);
        assertEquals("n) Shelley\n" +
                "This eBook <3>", ebr.readPage());

        ebr.deleteBook(0);

        // read the other book
        ebr.openBook(0);
        ebr.turnToPage(0);
        assertEquals("The Project Gutenberg <0>", ebr.readPage());
        ebr.turnToPage(5);
        assertEquals("soever. You\n <5>", ebr.readPage());
    }

    @Test
    public void testDeleteOpenedBook() {
        Reader ebr = new Reader(4, 1);
        ebr.addBook(text1);
        ebr.addBook(text2);
        // if deleted book is the open book then can no longer read it
        ebr.openBook(0);
        ebr.deleteBook(0);
        Assertions.assertThrows(EbookException.class, () -> {
            ebr.turnToPage(0);
            ebr.readPage();
        });
    }

    @Test
    public void testOpenReadHard() {
        Reader ebr = new Reader(14, 12);
        for (int i=0; i<10; i++) {
           ebr.addBook(i+text3);
        }
        ebr.openBook(7);
        assertEquals("7The Project <0>", ebr.readPage());
        ebr.deleteBook(3);
        ebr.openBook(7);
        assertEquals("8The Project <0>", ebr.readPage());
        ebr.deleteBook(3);
        ebr.deleteBook(3);
        ebr.addBook("A"+text3);
        ebr.openBook(2);
        assertEquals("2The Project <0>", ebr.readPage());
        ebr.openBook(6);
        assertEquals("9The Project <0>", ebr.readPage());
        ebr.openBook(7);
        assertEquals("AThe Project <0>", ebr.readPage());
        assertEquals(8, ebr.numBooks());
    }

    @Test
    public void testOpenFailDeleted() {
        Reader ebr = new Reader(4, 1);
        ebr.addBook(text1);
        ebr.addBook(text2);
        ebr.deleteBook(0);

        Assertions.assertThrows(EbookException.class, () -> {
            ebr.openBook(1); // should fail
        });
    }

    @Test
    public void testDeleteFail() {
        Reader ebr = new Reader(2, 1);
        ebr.addBook(text1);
        ebr.addBook(text2);
        Assertions.assertThrows(EbookException.class, () -> {
            ebr.deleteBook(2); // should cause EbookException
        });
    }

}
 */