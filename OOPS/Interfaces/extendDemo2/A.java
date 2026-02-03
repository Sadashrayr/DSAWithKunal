package OOPS.Interfaces.extendDemo2;

public interface A {
    // static interface method should have some body
    // Call via interface name
    static void greeting() {
        System.out.println("Hi i am in static ");
    }

    default void fun() {
        System.out.println("fun");
    };
}
