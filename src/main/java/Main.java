public class Main {
        public static void main(String[] args) {
            DoublyLinkedList list = new DoublyLinkedList();
            list.append('a');
            list.append('b');
            list.append('c');
            list.append('d');
            list.append('b');
            list.append('a');
            list.append('c');
            System.out.println("Your starting list: ");
            list.printList();

            System.out.println("Appending e to the end of list: ");
            list.append('e');
            list.printList();

            System.out.println("Length of the list for now: ");
            System.out.println(list.length());

            System.out.println("Inserting character k at index 4: ");
            list.insert('k', 4);
            list.printList();

            System.out.println("Deleting node at index 1: ");
            System.out.println("Deleted character: " + list.delete(1));
            list.printList();

            System.out.println("Deleting all occurrences of character a: ");
            list.deleteAll('a');
            list.printList();

            System.out.println("Getting character at index 2: ");
            System.out.println(list.get(2));

            System.out.println("Copying the list: ");
            DoublyLinkedList copy = list.cloneList();
            System.out.print("Copy " );
            copy.printList();

            System.out.println("Reversing list: ");
            list.reverse();
            list.printList();

            System.out.print("Index of first c in list: ");
            System.out.println(list.findFirst('c'));
            System.out.print("Index of last c in list: ");
            System.out.println(list.findLast('c'));

            System.out.print("We want to add ");
            DoublyLinkedList add = new DoublyLinkedList();
            add.append('1');
            add.append('2');
            add.append('3');
            add.printList();
            System.out.println("Extended main list: ");
            list.extend(add);
            list.printList();

            System.out.println("Clearing main list: ");
            list.clear();
            list.printList();
        }
}
