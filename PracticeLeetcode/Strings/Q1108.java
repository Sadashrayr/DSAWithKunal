package PracticeLeetcode.Strings;

public class Q1108 {
    public String defangIPaddr(String address) {
        StringBuilder result = new StringBuilder();
        for (char c : address.toCharArray()) {
            if (c == ',') {
                result.append("[.]");
            } else {
                result.append(c);
            }
        }
        return result.toString();
    }

}
