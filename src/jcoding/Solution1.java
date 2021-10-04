package jcoding;

public class Solution1 {
    public static void main(String[] args) {
        String s = "Zey";
       // String s = "hey";
        //String s = "0";
        Solution1 sol = new Solution1();
        System.out.println(sol.solution(s));
    }
    public String solution(String s){
        char c = s.charAt(0);
        if(c - 'A' >= 0 && c - 'A' < 26) {
            return "upper";

        }else if(c - 'a' >= 0 && c - 'a' < 26){
            return "lower";
        }else if(c - '0' >= 0 && c - '0' <= 9){
            return "digit";
        }else{
            return "other";
        }
    }
}
