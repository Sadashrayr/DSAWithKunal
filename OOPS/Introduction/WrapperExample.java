package OOPS.Introduction;

public class WrapperExample {
    public static void main(String[] args) {
        // int a = 10;
        // int b = 20;
        Integer num = 45;
        // Here Integer is a wrapper class.

        Integer a = 10;
        Integer b = 20;
        swap(a, b);
        System.out.println(a + " " + b);
        final A shray = new A("Sadashray Rastogi");
        shray.name = "name name";
        // when a non primitive is final, you cannot reassign it.

        shray = new A("New Object");
    }

    static void swap(Integer a, Integer b) {
        a = a + b;
        b = a - b;
        a = a - b;
    }

}

class A {
    final int num = 10;
    String name;

    public A(String name) {
        this.name = name;
    }

    @Override
    protected void finalize() throws Throwable {
        System.out.println("Object is destroyed");
    }

}
