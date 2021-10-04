package goog;

public class IsSubsequence {
    public static void main(String[] args) {
        String s = "b";
        String t = "abc";
        IsSubsequence sol = new IsSubsequence();
        System.out.println(sol.isSubsequence(s, t));
    }
    public boolean isSubsequence(String s, String t) {
        int n = s.length();
        int m = t.length();
        if(n == 0)return true;
        int i = 0;
         for(int j = 0; j < m && i < n; j++){
             if(t.charAt(j) == s.charAt(i)){
                 i++;
             }
        }
         if(i == n)return true;
         return false;

    }
}