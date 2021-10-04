package goog;

import java.util.ArrayList;
import java.util.HashMap;

public class DistinctSubsequences {
    public static void main(String[] args) {
        DistinctSubsequences sol = new DistinctSubsequences();
        String s = "babgbag";
        String t = "bag";
        System.out.println(sol.numDistinct(s, t));
    }
    public int numDistinct(String s, String t) {
            int n = s.length();
            int m = t.length();
            int[][] dp = new int[m + 1][n + 1];

            for(int j = 1; j <= n; j++){
                if(s.charAt(j - 1) == t.charAt(0)){
                    dp[1][j] = 1 + dp[1][j - 1];
                }else{
                    dp[1][j] = dp[1][j - 1];
                }
            }
            for(int i = 2; i <= m; i++){
                for(int j = 1; j <= n; j++){
                    if(t.charAt(i - 1) == s.charAt(j - 1)){
                        dp[i][j] = dp[i - 1][j - 1] + dp[i][j - 1];
                    }else{
                        dp[i][j] = dp[i][j - 1];
                    }
                }
            }
            return dp[m][n];
    }
}