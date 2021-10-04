package Paypal;

import java.util.Arrays;

public class Q1 {
    public static void main(String[] args) {
        //int[][] task = new int[][]{{1, 1}, {2, 3}};
        int[][] task = new int[][]{{1, 1}, {2, 10}, {3, 1}, {4, 1}};
        Q1 sol = new Q1();
        //System.out.println(sol.getMaxTaskDone(task, task.length, 7));
        System.out.println(sol.getMaxTaskDone(task, task.length, 21));
    }

    public static int getMaxTaskDone(int[][] task, int n, int t){
        int[][] dp = new int[t + 1][n + 1];
        for(int i = 0; i <= t; i++){
            Arrays.fill(dp[i], -1);
        }
        return getMaxTaskCount(t, 0, n, task, dp, 0);
    }

    private static int getMaxTaskCount(int t, int i, int n, int[][] task, int[][] dp, int lastAt) {
        if(i >= n)return 0;
        if(dp[t][i] != -1)return dp[t][i];
        int temp1 = Integer.MIN_VALUE;
        if(t - 2 *(task[i][0] - lastAt) - task[i][1] >= 0){
            temp1 = 1 + getMaxTaskCount(t - 2 *(task[i][0] - lastAt) - task[i][1], i + 1, n, task, dp, task[i][0]);
        }
        int temp2 = getMaxTaskCount(t, i  +1, n, task, dp, lastAt);
        dp[t][i] = Math.max(temp1, temp2);
        return dp[t][i];
    }

}
