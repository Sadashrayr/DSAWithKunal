package OOPS.AbstractDemo;

public abstract class Parent {
    int age;
    final int VALUE;

    public Parent(int age) {
        this.age = age;
        VALUE = 32456789; 
    }

    // abstract Parent();
    static void hello() {
        System.out.println("hi");
    }

    abstract void career();

    abstract void partner();

    void normal() {
        System.out.println("this is a normal");
    }
}
