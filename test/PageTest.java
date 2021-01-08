import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class PageTest {

    @Test
    void testToString() {
        Page p = new Page(21, "Hello World");
        assertEquals("Hello World <21>", p.toString());
    }
}