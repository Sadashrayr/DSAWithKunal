package OOPS.AbstractDemo;

public class Daughter extends Parent {
    public Daughter(int age) {
        super(age);
        
    }

    @Override
    void career() {
        System.out.println(" i want to be a musician ");
    }

    @Override
    void partner() {
        System.out.println(" I love shray. he is 28");

    }

}
