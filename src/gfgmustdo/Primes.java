package gfgmustdo;

import java.util.Arrays;
import java.util.HashMap;

public class Primes {
    HashMap<Integer, Boolean> map = new HashMap<>();

    public static void main(String[] args) {
        Primes sol = new Primes();
        sol.getPrimeStatus(100000);
//        sol.getPrimeStatus(7);
//        System.out.println(sol.map);
        System.out.println(sol.willAliceWin(4));
    }
    public boolean willAliceWin(int n){
        int[] dp = new int[n + 1];
        //Arrays.fill(dp, -1);
        return sub(n, dp);
    }

    private boolean sub(int n, int[] dp) {
        if(dp[n] != 0){
            if(dp[n] == 1)return true;
            else return false;
        }
        if(map.get(n)){
            dp[n] = 1;
            return true;
        }
        boolean temp = true;
        for(int i = 1; i < n; i++){
            if(map.get(i)){
                temp = temp && !sub(n - i, dp);
            }
        }
        if(temp){
            dp[n] = 1;
            return true;
        }else dp[n] = 2;
        return false;
    }

    private void getPrimeStatus(int n){
        if(n > 0)map.put(1, true);
        if(n > 1)map.put(2, true);
        if(n > 2)map.put(3, true);
        for(int i = 3; i <= n; i++){
            for(int j = 2; j <= Math.sqrt(i); j++){
                if(i % j == 0){
                    map.put(i, false);
                    break;
                }
            }
            if(!map.containsKey(i))
            map.put(i, true);
        }
    }
}
