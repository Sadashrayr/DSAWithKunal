package StackandQueue;

public class Circularqueue {
    protected int[] data;
    private static final int DEFAULT_SIZE = 10;
    protected int end = 0;
    protected int front = 0;
    private int size = 0;

    public Circularqueue() {
        this(DEFAULT_SIZE);
    }

    public Circularqueue(int size) {
        this.data = new int[size];
    }

    public boolean isFull() {
        return size == data.length;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean insert(int item) {
        if (isFull()) {
            return false;
        }
        data[end++] = item;
        end = end % data.length;
        size++;
        return true;
    }

    public int remove() throws Exception {
        if (isEmpty()) {
            throw new Exception("Circular Queue is empty");
        }
        int removed = data[front++];
        front = front % data.length;
        size--;
        return removed;

    }

    public int front() throws Exception {
        if (isEmpty()) {
            throw new Exception("Circular queue is empty");

        }
        return data[front];
    }

    public void display() {
        int i = front;
        if (isEmpty()) {
            return;
        }
        do {
            System.out.print(data[i] + "->");
            i++;
            i = (i + 1) % data.length;
        } while (i != end);
        System.out.println("END");

    }
}
