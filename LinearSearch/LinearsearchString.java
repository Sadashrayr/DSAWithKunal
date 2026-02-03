package LinearSearch;

import java.util.Scanner;

public class LinearsearchString {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter the String");
        String name = in.nextLine();
        System.out.println("Enter the character u want to search ");
        char target = in.next().charAt(0);
        search(name, target);
        in.close();
    }

    static void search(String Name, char target) {
        int found = 0;
        for (int i = 0; i < Name.length(); i++) {
            if (target == Name.charAt(i)) {
                found++;
            }
        }
        if (found > 0) {
            System.out.println(" The character" + target + "is present in string " + Name + " " + found + " times");
        }
        if (found == 0) {
            System.out.println("The character" + target + "is not present in the String " + Name);
        }
    }

}
