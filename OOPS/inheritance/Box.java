package OOPS.inheritance;

public class Box {
    double l;
    double h;
    double w;

    Box() {
        this.h = -1;
        this.l = -1;
        this.w = -1;
    }

    // cube
    Box(double side) {
        this.w = side;
        this.h = side;
        this.l = side;
    }

    Box(double l, double h, double w) {
        System.out.println("Box class construtor");
        this.w = w;
        this.h = h;
        this.l = l;
    }

    Box(Box old) {
        this.h = old.h;
        this.w = old.w;
        this.l = old.l;
    }

    public void information() {
        System.out.println("The box is running");
    }
}
