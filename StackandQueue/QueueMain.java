package StackandQueue;

public class QueueMain {
    public static void main(String[] args) throws Exception {
        // CustomQueue queue = new CustomQueue(5);
        Circularqueue queue = new Circularqueue(5);
        queue.insert(3);
        queue.insert(6);
        queue.insert(7);
        queue.insert(5);
        queue.insert(2);
        queue.display();
        System.out.println(queue.remove());
        queue.insert(133);
        queue.display();

    }
}
