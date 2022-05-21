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
}
