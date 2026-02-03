package OOPS.Generics;

public class CustomGenArrayList<T> {
    private T[] data;
    private static int DEFAULT_SIZE = 10;
    private int size = 0;// also working as index value

    // public CustomGenArrayList() {
    // this.data = new T[DEFAULT_SIZE];
    // }

    public void add(T num) {
        if (this.isFull()) {
            resize();
        }
        data[size++] = num;
    }

    private boolean isFull() {
        return size == data.length;

    }

    private void resize() {
        T[] temp = (T[]) new Object[data.length * 2];
        // Copy the current items in new array
        for (int i = 0; i < data.length; i++) {
            temp[i] = data[i];
        }
        data = temp;

    }

    public T remove() {
        T removed = data[--size];
        return removed;
    }

    public T get(int index) {
        return data[index];
    }

}
