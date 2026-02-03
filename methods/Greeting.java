
public class Greeting {
    public static void main(String[] args) {
        // greet();
        String personalized = myGreet("Sadashray");
        System.out.println(personalized);

    }

    private static String myGreet(String name) {
        String message = "Hello" + name;
        return message;

    }

    /*
     * static void greet() {
     * System.out.println("Hey how are you");
     * }
     */

}
