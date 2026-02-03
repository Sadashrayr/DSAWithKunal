package Linkedlist;

public class Main {
    public static void main(String[] args) {
        SinglyLinkedList list = new SinglyLinkedList();
        // DoublyLinkedList list = new DoublyLinkedList();
        // CircularLinkedList list = new CircularLinkedList();
        list.insertFirst(9);
        list.insertFirst(8);
        list.insertFirst(5);
        list.insertFirst(3);
        list.display();
        // list.insertLast(17);
        list.insertRecursion(100, 1);
        // list.insertLast(10);
        // list.insert(19, 3);

        System.out.println();
        // list.delete(5);
        list.display();
        // list.displayReverse();
        // System.out.println(list.deleteFirst());
        // list.display();
        // System.out.println(list.deleteLast());
        // list.display();
        // System.out.println(list.delete(3));

    }
    

}
