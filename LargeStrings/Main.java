package LargeStrings;

import java.util.Random;
import java.text.DecimalFormat;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        // Constructor 1

        StringBuffer sb = new StringBuffer();

        // constructor 2
        StringBuffer sb2 = new StringBuffer("Sadashray Rastogi ");
        // constructor 3
        StringBuffer sb3 = new StringBuffer(30);
        // System.out.println(sb.capacity());
        sb.append("WeMakeDevs");
        sb2.append("WeMakeDevs");
        sb.append("is nice!");
        // sb.insert(2, "Rahul");

        sb.replace(1, 5, "Rastogi");

        // System.out.println(sb3.capacity());
        // String str = sb.toString();
        // String str1 = sb2.toString();
        // System.out.println(str);
        // System.out.println(str1);

        int n = 20;
        String name = RandomString.generate(n);
        System.out.println(name);
        // remove WhiteSpaces
        String sentence = "Hi h hjh hjkso  siowi     w";
        System.out.println(sentence);
        System.out.println(sentence.replaceAll("\\s", ""));
        // split
        String arr = "Sadashray,Mohak,Aishu,Samarpita";
        String[] names = arr.split(",");
        System.out.println(Arrays.toString(names));
        // rounding off
        DecimalFormat df = new DecimalFormat("0.0000");
        System.out.println(df.format(7.29899));

    }

}
