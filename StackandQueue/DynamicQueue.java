package StackandQueue;

public class DynamicQueue extends Circularqueue {
    public DynamicQueue() {
        super();
    }

    public DynamicQueue(int size) {
        super(size);
    }

    @Override
    public boolean insert(int item) {
        // this takes care of being full
        if (isFull()) {
            // double the size of array
            int[] temp = new int[data.length * 2];
            // copy all the data in it
            for (int i = 0; i < data.length; i++) {
                temp[i] = data[(front + i) % data.length];
            }
            front = 0;
            end = data.length;
            data = temp;
        }
        return super.insert(item);

    }
}
