package OOPS.Staticexample;

// outside classes cannot be static

public class InnerClasses {
    static class Test {
        String name;

        public Test(String name) {
            this.name = name;
        }
    }

    public static void main(String[] args) {
        Test a = new Test("Shray");
        Test b = new Test("sada");

        System.out.println(a.name);
        System.out.println(b.name);
    }

}
