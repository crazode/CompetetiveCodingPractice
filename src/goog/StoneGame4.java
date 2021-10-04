package goog;

import java.util.HashMap;

public class StoneGame4 {
 //HashMap<Integer, Boolean> map = new HashMap<>();

public static void main(String[] args) {
        StoneGame4 sol = new StoneGame4();
//        sol.getPrimeStatus(100000);
//        sol.getPrimeStatus(7);
//        System.out.println(sol.map);
        System.out.println(sol.willAliceWin(7));
        }
public boolean willAliceWin(int n){
    return winnerSquareGameIter(n);
        }

    private boolean winnerSquareGameIter(int n){
        boolean[] dp= new boolean[n+1];
        dp[0]= false;
        for(int i=1; i<=n; i++){
            boolean win= false;
            for(int j=1; !win && j*j<=i; j++)
                win= !dp[i-j*j];
            dp[i]= win;
        }
        return dp[n];
    }
}