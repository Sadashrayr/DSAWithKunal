package OOPS.Introduction;

 

public class Main {
    public static void main(String[] args) {
        // Data of 5 students:
        int[] rno = new int[5];
        String[] name = new String[5];
        float[] marks = new float[5];
        Student[] students = new Student[5];
        // Student shray;
        // shray= new Student();

        Student shray = new Student(14, "shray", 44.5f);
        Student rahul = new Student();
        // shray.rno = 13;
        // shray.name = "Sadashray rastogi";
        // shray.marks = 49.5f;
        System.out.println(shray.rno);
        System.out.println(shray.name);
        System.out.println(shray.marks);
        // shray.changeName("Shray");
        // shray.greeting();
        Student random = new Student(shray);
        System.out.println(random.name);
        Student random2 = new Student();
        System.out.println(random2.rno);

    }
}

// create a class
// for every single student
class Student {
    int rno;
    String name;
    float marks;

    // we need a way to add the values of the above properties
    // object by object
    // we need one word to access every object
    void greeting() {
        System.out.println("Hello my name is " + name);
    }

    void changeName(String newName) {
        name = newName;
    }

    Student(Student other) {
        this.name = other.name;
        this.rno = other.rno;
        this.marks = other.marks;
    }

    Student() {
        // this is how u call a constructor from another constructor;
        // internally: new Student();

        this(3, "default", 100f);
    }

    // Student arpit=new Student(17,"Arpit",89.4f)
    // here, this will be replaced with arpit
    Student(int rno, String name, float marks) {
        this.rno = rno;
        this.name = name;
        this.marks = marks;
    }
}
