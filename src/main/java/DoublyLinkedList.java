public class DoublyLinkedList {
    Node head = null;
    Node tail = null;

    static class Node {
        char data;
        Node prev;
        Node next;
    }

    public void printList(){
        Node currentNode = head;
        if(head == null) {
            System.out.println("List is empty.");
            return;
        }
        System.out.print("List: ");
        while(currentNode != null) {
            System.out.print(currentNode.data + " ");
            currentNode = currentNode.next;
        }
        System.out.println();
    }

    public void append(char c){
        Node elem = new Node();
        elem.data = c;
        if(head == null){
            head = tail = elem;
            head.prev = null;
        }
        else{
            tail.next = elem;
            elem.prev = tail;
            tail = elem;
        }
        tail.next = null;
    }

    public int length(){
        Node elem = head;
        int len = 0;
        if(head != null) {
            while(elem != null) {
                len++;
                elem = elem.next;
            }
        }
        return len;
    }
}
