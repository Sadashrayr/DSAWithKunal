package Hashmaps;

import java.util.HashMap;
import java.util.HashSet;

public class Main {
    public static void main(String[] args) {
        // HashMap<String, Integer> map = new HashMap<>();
        // map.put("shray", 98);
        // map.put("Karan", 99);
        // map.put("Rahul", 87);
        // System.out.println(map.get("Karan"));
        // HashSet<Integer> set = new HashSet<>();
        // set.add(56);
        // set.add(9);
        // set.add(83);
        // set.add(38);
        // set.add(56);
        // set.add(6);
        // System.out.println(set);
        MapUsingHash map = new MapUsingHash();
        map.put("Mango", "King of fruits");
        map.put("Apple", "A sweet red fruit");
        map.put("Litchi", "Mine favourite");
        System.out.println(map.get("Apple"));
    }
}
