package Linkedlist;

public class DoublyLinkedList {
    private Node head;

    public void insertFirst(int value) {
        Node node = new Node(value);
        node.next = head;
        node.prev = null;
        if (head != null) {
            head.prev = node;
        }
        head = node;
    }

    public void insertLast(int value) {
        Node newNode = new Node(value);
        Node temp = head;
        newNode.next = null;
        if (head == null) {
            insertFirst(value);
            return;

        }
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = newNode;
        newNode.prev = temp;
    }

    public void insert(int value, int index) {
        if (index == 0) {
            insertFirst(value);
            return;
        }

        Node node = new Node(value);
        Node temp = head;
        for (int i = 1; i < index; i++) {

            temp = temp.next;
        }
        node.next = temp.next;
        node.prev = temp;
        if (temp.next != null) {
            temp.next.prev = node;
        }
        temp.next = node;

    }

    public void display() {
        Node node = head;
        while (node != null) {
            System.out.print(node.value + "->");
            node = node.next;
        }
        System.out.print("END");

    }

    public void displayReverse() {
        Node node = head;
        Node last = null;
        System.out.println();
        while (node != null) {
            last = node;
            node = node.next;
        }
        while (last != null) {
            System.out.print(last.value + "->");
            last = last.prev;

        }
        System.out.print("START");
    }

    private class Node {
        private int value;
        private Node next;
        private Node prev;

        public Node(int value) {
            this.value = value;
        }

        public Node(int value, Node next, Node prev) {
            this.value = value;
            this.prev = prev;
            this.next = next;

        }
    }

}
