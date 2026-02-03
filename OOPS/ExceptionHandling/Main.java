package OOPS.ExceptionHandling;

public class Main {
    public static void main(String[] args) {
        int a = 5;
        int b = 0;
        try {
            // divide(a, b);
            String name = "Shray";
            if (name.equals("Shray")) {
                throw new MyException("Name is shray");
            }

        } catch (MyException e) {
            System.out.println(e.getMessage());
        } catch (ArithmeticException e) {
            System.out.println(e.getMessage());
        } catch (Exception e) {
            System.out.println("Normal exception");
        } finally {
            System.out.println("This will always run");
        }

    }

    static int divide(int a, int b) throws ArithmeticException {
        if (b == 0) {
            throw new ArithmeticException("Do not divide by zero");
        }
        return a / b;
    }

}
