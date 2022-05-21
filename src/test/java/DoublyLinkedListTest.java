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

    @Test
    void insert() {
        dll.append('a');
        dll.append('b');
        dll.append('c');
        dll.insert('q', 1);
        assertEquals('q', dll.head.next.data);
        dll.insert('k', 0);
        assertEquals('k', dll.head.data);
        dll.insert('o', 5);
        assertEquals('o', dll.tail.data);
        assertThrows(IndexOutOfBoundsException.class, ()-> dll.insert('w', 8));
        assertThrows(IndexOutOfBoundsException.class, ()-> dll.insert('j',-2));
    }

    @Test
    void delete() {
        dll.append('a');
        dll.append('b');
        dll.append('c');
        dll.append('d');
        assertEquals('b', dll.delete(1));
        assertEquals(3, dll.length());
        assertEquals('d', dll.delete(2));
        assertEquals(2, dll.length());
        assertEquals('a', dll.delete(0));
        assertEquals(1, dll.length());
        assertEquals('c', dll.head.data);
        assertEquals('c', dll.delete(0));
        assertThrows(IndexOutOfBoundsException.class, ()-> dll.delete(0));
        assertThrows(IndexOutOfBoundsException.class, ()-> dll.delete(3));
        assertThrows(IndexOutOfBoundsException.class, ()-> dll.delete(-1));

    }

    @Test
    void get() {
        dll.append('a');
        dll.append('b');
        dll.append('c');
        dll.append('d');
        assertEquals('c', dll.get(2));
        assertEquals('a', dll.get(0));
        assertEquals('d', dll.get(3));
        assertThrows(IndexOutOfBoundsException.class, ()-> dll.get(4));
        assertThrows(IndexOutOfBoundsException.class, ()-> dll.get(-1));
        assertThrows(IndexOutOfBoundsException.class, ()-> dll.get(7));
    }

    @Test
    void deleteAll() {
        dll.append('a');
        dll.append('b');
        dll.append('a');
        dll.append('c');
        dll.append('d');
        dll.append('k');
        dll.append('a');
        dll.deleteAll('a');
        assertEquals('b', dll.head.data);
        assertEquals('k', dll.tail.data);
        assertEquals('c', dll.head.next.data);
    }

    @Test
    void cloneList() {
        dll.append('1');
        dll.append('2');
        dll.append('3');
        dll.append('4');
        DoublyLinkedList test_clone = dll.cloneList();
        assertEquals(dll, test_clone);
    }

    @Test
    void reverse() {
        dll.append('1');
        dll.append('2');
        dll.append('3');
        dll.append('4');
        dll.reverse();
        assertEquals('4', dll.head.data);
        assertEquals('1', dll.tail.data);
        assertEquals('3', dll.head.next.data);
        assertEquals('2', dll.tail.prev.data);
    }

    @Test
    void findFirst() {
        dll.append('a');
        dll.append('b');
        dll.append('a');
        dll.append('b');
        dll.append('d');
        dll.append('k');
        dll.append('a');
        assertEquals(0, dll.findFirst('a'));
        assertEquals(-1, dll.findFirst('w'));
        assertEquals(1, dll.findFirst('b'));
        assertEquals(5, dll.findFirst('k'));
    }

    @Test
    void findLast() {
        dll.append('a');
        dll.append('b');
        dll.append('a');
        dll.append('b');
        dll.append('d');
        dll.append('k');
        dll.append('a');
        assertEquals(6, dll.findLast('a'));
        assertEquals(-1, dll.findLast('w'));
        assertEquals(3, dll.findLast('b'));
        assertEquals(4, dll.findLast('d'));
    }
}
