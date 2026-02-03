package OOPS.Polymorphism;

public class Objectprint extends Object {
    int num;

    public Objectprint(int num) {
        this.num = num;
    }

    @Override
    public String toString() {
        return "ObjectPrint{" + "num=" + num + '}';
    }

    public static void main(String[] args) {
        Objectprint obj = new Objectprint(54);
        System.out.println(obj);
    }

}
