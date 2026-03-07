package Huffmancoding;

public class Main {
    public static void main(String[] args) throws Exception {
        String str = "abbccda";
        Huffmancoder hf = new Huffmancoder(str);
        String cs = hf.encode(str);
        System.out.println(cs);
        String dc = hf.decode(cs);
        System.out.println(dc);
    }

}
