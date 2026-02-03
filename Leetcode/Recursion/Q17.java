package Leetcode.Recursion;

public class Q17 {
    public static void main(String[] args) {
        pad("","78");
        
    }
    static void pad(String p,String up){
       if(up.isEmpty()){
        System.out.print(p+" ");
        return;
       } 
      int digit= up.charAt(0)-'0';
      for(int i=(digit-1)*3;i<digit*3;i++){
        char ch=(char)('a'+i);
        pad(p+ch,up.substring(1));
      }
    }
    
}
