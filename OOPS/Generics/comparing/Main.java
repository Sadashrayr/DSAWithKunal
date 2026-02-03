package OOPS.Generics.comparing;

public class Main {
    public static void main(String[] args) {

        Student rahul = new Student(10, 78.56f);
        Student kunal = new Student(39, 68.38f);

        if (kunal.compareTo(rahul)<0) {
            System.out.println("Rahul Has more marks");
        }
    }
}
