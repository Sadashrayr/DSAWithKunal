package Arrays;

import java.util.ArrayList;

public class ArrayListExample {
    public static void main(String[] args) {
        // Syntax ArrayList<datatype> name=new ArrayList<>(initialCapacity)
        ArrayList<Integer> list = new ArrayList<>(10);
        list.add(67);
        list.add(34);
        System.out.println(list);

    }

}