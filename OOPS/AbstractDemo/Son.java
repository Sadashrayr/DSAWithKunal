package OOPS.AbstractDemo;

public class Son extends Parent {
    public Son(int age) {
        this.age = age;
    }

    @Override
    void normal() {
        super.normal();
    }

    @Override
    void career() {
        System.out.println("I am gonna be doctor");
    }

    @Override
    void partner() {
        System.out.println("I love shree   she is 26");
    }

}
