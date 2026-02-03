package OOPS.inheritance;

public class Boxweight extends Box {
    double weight;

    public Boxweight() {
        this.weight = -1;
    }

    Boxweight(Boxweight other) {
        super(other);
        weight = other.weight;

    }

    Boxweight(double side, double weight) {
        super(side);
        this.weight = weight;
    }

    public Boxweight(double l, double h, double w, double weight) {

        super(l, h, w);// calling parent class constructor
        // use to initialize value present in parent class
        // System.out.println(super.w);
        this.weight = weight;

    }
}
