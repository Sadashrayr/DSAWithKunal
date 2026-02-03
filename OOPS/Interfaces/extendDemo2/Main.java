package OOPS.Interfaces.extendDemo2;

public class Main implements A, B {
    @Override
    public void greet() {
        System.out.println("Morning");
    }

    public static void main(String[] args) {
        //Main obj = new Main();
        A.greeting();

    }

}
