package OOPS.inheritance;

public class Main {
    public static void main(String[] args) {
        /*
         * Box obj = new Box();
         * System.out.println(obj.l + " " + obj.h);
         * Box cube = new Box(10);
         * System.out.println(cube.l);
         */
        // Boxweight box3 = new Boxweight();
        // System.out.println(box3.h + "" + box3.weight);
        Box box5 = new Boxweight(2, 3, 4, 8);
        System.out.println(box5.w);

        // there are many variable in both child and classes
        // you are given access to variables that are in the ref type i.e. Boxweight
        // hence, you should have acess to weight variable
        // this also means, that the ones you are trying to acess should be intialised
        // but here, when the obj itself is of type parent class, how will you call the
        // constructor of child class

        // Boxweight box6=new Box(2,3,4);
        // System.out.println(box6);
        Boxprice box = new Boxprice(5, 8, 200);

    }

}
