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
}
