package OOPS.Staticexample;

public class Main {
    public static void main(String[] args) {
        /*
         * Human shray = new Human(22, "Sadashray", 20000, false);
         * Human sada = new Human(12, "Rastogi", 00, true);
         * System.out.print(shray.name);
         * System.out.println(" " + sada.name);
         * // Don't do like this while working with static variable or object
         * // Answer will be the same but warning is there
         * System.out.println(shray.population);
         * // Conventionally
         * System.out.println(Human.population);
         */
        Main funn = new Main();
        funn.fun2();

    }

    // this is not dependent on objects
    static void fun() {
        // greeting();// you cant use this bcoz it requiresa instances
        // but the functions u r using it does not depend on object

        // u cannot access nonstatic stuff without referencing
        // their instances in a static context

        // hence here We are referencing it
        Main obj = new Main();
        obj.greeting();
    }

    void fun2() {
        greeting();
    }

    // we know that something which is not static,
    // belongs to an object.
    void greeting() {
        System.out.println("hello world");
    }

}
