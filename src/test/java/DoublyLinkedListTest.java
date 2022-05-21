import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class DoublyLinkedListTest {
    private DoublyLinkedList dll;

    @BeforeEach
    void setUp() {
        dll = new DoublyLinkedList();
    }

    @Test
    void append() {
        dll.append('a');
        dll.append('b');
        dll.append('c');
        assertEquals('a', dll.head.data);
        assertEquals('c', dll.tail.data);
        assertEquals('b', dll.head.next.data);
    }

    @Test
    void length() {
        dll.append('1');
        dll.append('2');
        dll.append('3');
        assertEquals(3, dll.length());
        dll.append('4');
        dll.append('5');
        assertEquals(5, dll.length());
    }
}
