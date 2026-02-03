package OOPS.Cloning;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws CloneNotSupportedException {
        Human shray = new Human(22, "Sadashray Rastogi");
        // Human twin = new Human(shray);
        Human twin = (Human) shray.clone();
        System.out.println(twin.age + " " + twin.name);
        System.out.println(Arrays.toString(twin.arr));
        twin.arr[0] = 10;
        System.out.println("Shray :" + Arrays.toString(shray.arr));
        System.out.println(" Twin: " + Arrays.toString(twin.arr));
    }

}
