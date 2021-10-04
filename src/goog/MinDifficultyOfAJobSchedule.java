package goog;

import java.util.Arrays;

public class MinDifficultyOfAJobSchedule {
    public static void main(String[] args) {
        MinDifficultyOfAJobSchedule sol = new MinDifficultyOfAJobSchedule();
        int[] jobDifficulty = new int[]{6,5,4,3,2,1};
        int d = 2;
        System.out.println(sol.minDifficulty(jobDifficulty, d));
    }
    public int minDifficulty(int[] jobDifficulty, int d) {
        if(d > jobDifficulty.length)return -1;
        int n = jobDifficulty.length;
        int[][] dp = new int[d + 1][n];
        for(int[] a: dp) Arrays.fill(a, -1);
        return dfs(jobDifficulty, d, dp, 0);
    }

    private int dfs(int[] jobDifficulty, int d, int[][] dp, int index) {
        int n = jobDifficulty.length;
        if(d == 1){
            int max = Integer.MIN_VALUE;
            for(int i = index; i < jobDifficulty.length; i++){
                max = Math.max(max, jobDifficulty[i]);
            }
            return max;
        }
        if(dp[d][index] != -1)return dp[d][index];
        int max = 0;
        int res = Integer.MAX_VALUE;
        for(int i = index; i < n - d + 1; i++){
            max = Math.max(max, jobDifficulty[i]);
            res = Math.min(res, max + dfs(jobDifficulty, d - 1, dp,  i + 1));
        }
        dp[d][index] = res;
        return dp[d][index];
    }

}
