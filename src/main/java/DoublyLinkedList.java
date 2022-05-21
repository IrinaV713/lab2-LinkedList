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

    public void insert(char c, int index){
        if(index < 0 || index > this.length()){
            throw new IndexOutOfBoundsException("Error. Invalid index");
        }
        else{
            Node newNode = new Node();
            newNode.data = c;
            newNode.next = null;
            newNode.prev = null;

            if(index == 0){
                newNode.next = head;
                head.prev = newNode;
                head = newNode;
            }
            else if(index == this.length()){
                newNode.prev = tail;
                tail.next = newNode;
                tail = newNode;
            }
            else{
                Node temp = head;
                for(int i = 1; i < index; i++) {
                    if(temp != null) {
                        temp = temp.next;
                    }
                }
                if(temp != null) {
                    newNode.next = temp.next;
                    newNode.prev = temp;
                    temp.next = newNode;
                    if(newNode.next != null) newNode.next.prev = newNode;
                }
            }
        }
    }

    public char delete(int index){
        char result;
        if(index < 0 || index >= this.length() || head == null){
            throw new IndexOutOfBoundsException("Error. Invalid index");
        }
        else if(index == 0){
            result = this.get(index);
            head = head.next;
            if (head != null) head.prev = null;
        }
        else{
            result = this.get(index);
            Node temp = head;
            for(int i = 1; i < index; i++) {
                if(temp != null) {
                    temp = temp.next;
                }
            }
            if(temp != null && temp.next != null) {
                temp.next = temp.next.next;
                if(temp.next != null) {
                    if (temp.next.next != null) temp.next.next.prev = temp.next;
                }
            }
        }
        return result;
    }

    public char get(int index){
        if(index < 0 || index >= this.length()){
            throw new IndexOutOfBoundsException("Error. Invalid index");
        }
        else{
            Node elem = head;
            char result = Character.MIN_VALUE;
            int i = 0;
            if(head != null) {
                while(elem != null) {
                    if(i == index){
                        result = elem.data;
                        break;
                    }
                    i++;
                    elem = elem.next;
                }
            }
            return result;
        }
    }

    public void deleteAll(char c){
        while(head != null && head.data == c) {
            head = head.next;
            if (head != null) head.prev = null;
        }

        Node temp = head;
        if(temp != null) {
            while(temp.next != null) {
                if(temp.next.data == c) {
                    temp.next = temp.next.next;
                    if(temp.next != null) temp.next.prev = temp;
                }
                else {
                    temp = temp.next;
                }
            }
        }

        while(tail != null && tail.data == c) {
            tail = tail.prev;
            if (tail != null) tail.next = null;
        }
    }
}
