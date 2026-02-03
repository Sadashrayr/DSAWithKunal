package OOPS.Singleton;

public class Main {
    public static void main(String[] args) {
        singleton obj = singleton.getInstance();
        singleton obj1 = singleton.getInstance();
        singleton obj2 = singleton.getInstance();
        // all 3 ref variables are pointing to just one object
    }

}
