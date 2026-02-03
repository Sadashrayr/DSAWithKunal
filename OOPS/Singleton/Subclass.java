package OOPS.Singleton;

import OOPS.access.A;

public class Subclass extends A {
    public Subclass(int num, String name) {
        super(num, name);
    }

    public static void main(String[] args) {
        Subclass obj = new Subclass(45, "Rohit Sharma");
        // int n = obj.num;
    }
}

class SubSubclass extends Subclass {
    public SubSubclass(int num, String name) {
        super(num, name);
j
    }
}

class Subclass2 extends A {
    public Subclass2(int num, String name) {
        super(num, name);
    }

    public static void main(String[] args) {
        Subclass obj = new Subclass(45, "Rohit Sharma");

        System.out.println(obj instanceof A);
    }
}
