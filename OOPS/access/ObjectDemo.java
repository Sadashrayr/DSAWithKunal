package OOPS.access;

public class ObjectDemo {
    // we will go in details how to create it in hashmap lecture
    int num;
    float gpa;

    public ObjectDemo(int num, float gpa) {
        this.num = num;
        this.gpa = gpa;
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    @Override
    public String toString() {
        return super.toString();
    }

    @Override
    protected void finalize() throws Throwable {
        super.finalize();
    }

    public static void main(String[] args) {
        ObjectDemo obj = new ObjectDemo(12, 56.8f);
        ObjectDemo obj2 = new ObjectDemo(12, 78.9f);
        if (obj == obj2) {
            System.out.println("Obj is equal to  obj2");
        }
        if (obj.equals(obj2)) {
            System.out.println("Obj is equal to  obj2");
        }
        // System.out.println(obj.hashCode());
        // System.out.println(obj2.hashCode());
    }
}
