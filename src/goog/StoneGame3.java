package goog;

import java.util.Arrays;

class StoneGame3 {
    public static void main(String[] args) {
        StoneGame3 sol = new StoneGame3();
        int[] piles = new int[]{2, 7, 9, 4, 4};
//        int[] piles = new int[]{2, 1};
        System.out.println(sol.stoneGameII(piles));
    }
    public int stoneGameII(int[] piles) {
        int n = piles.length;
        int[][] dp = new int[101][201];
        int[] sum = new int[n];
        sum[0] = piles[0];
        for(int i = 1; i < n; i++){
            sum[i] = sum[i - 1] + piles[i];
        }
        for(int i = 0; i < 101; i++)
        Arrays.fill(dp[i], -1);
        return (sum[n - 1] + getMaxAliceScore(0, 1, piles, dp, sum))/2;
    }
    public int getMaxAliceScore(int index, int m, int[] piles, int[][] dp, int[] sum){
        int n = piles.length;
        if(index >= n )return 0;
        if(dp[index][m] != -1)return dp[index][m];
        int ans = Integer.MIN_VALUE;
        for(int x = 1; x <= 2 * m; x++){
            if(index + x - 1 < n){
                    ans = Math.max(ans, getSum(index, x, sum) - getMaxAliceScore(index + x, Math.max(x, m), piles, dp, sum));


            }else break;
        }

            dp[index][m] = ans;


        return ans;
    }
    public int getSum(int index, int x, int[] sum){
        if(index == 0)return sum[index + x - 1];
        return sum[index + x - 1] - sum[index - 1];
    }
}