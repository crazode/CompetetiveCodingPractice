package goog;

import java.util.LinkedList;
import java.util.Queue;

public class MinSidewaysJump {
    public static void main(String[] args) {
        //int[] obstacles = new int[]{0,1,2,3,0};
       // int[] obstacles = new int[]{0,2,1,0,3,0};
       // int[] obstacles = new int[]{0,1,1,3,3,0};
        int[] obstacles = new int[]{0,2,2,1,0,3,0,3,0,1,3,1,1,0,1,3,1,1,1,0,2,0,0,3,3,0,3,2,2,0,0,3,3,3,0,0,2,0,0,3,3,0,
                3,3,0,0,3,1,0,1,0,2,3,1,1,0,3,3,0,3,1,3,0,2,2,0,1,3,0,1,0,3,0,1,3,1,2,2,0,0,3,0,1,3,2,3,2,1,0,3,2,2,0,3,
                3,0,3,0,0,1,0,2,0,0,0,2,1,2,0,2,2,3,3,3,0,0,1,1,3,0,0,0,1,2,2,1,2,1,3,2,2,3,1,3,0,1,1,1,3,0,0,0,2,0,2,0,
                3,1,2,3,3,2,2,2,0,0,0,1,0,0,0,0,3,0,0,0,3,0,2,1,2,3,1,0,3,3,2,0,1,1,0,1,0,2,2,2,1,3,0,3,0,2,1,1,3,1,0,1,
                2,2,0,2,2,0,0,3,3,1,3,0,1,1,0,3,0,2,1,2,2,0,0,0,1,2,3,1,2,1,1,2,2,1,1,0,2,3,3,3,0,2,3,2,0,0,0,1,0,2,2,0,
                0,2,0,2,0,1,1,0,3,1,3,3,0,1,0,3,0,3,1,2,3,1,0,0,2,3,2,0,0,3,1,2,3,2,2,3,1,3,3,2,0,1,3,0,3,2,2,3,2,1,2,2,
                0,3,2,0,2,1,2,2,3,1,3,2,2,0,0,1,0,3,1,3,3,0,0,2,2,2,2,0,1,0,3,1,3,3,3,0,2,3,2,0,3,3,3,3,3,3,2,2,1,1,0,3,
                1,3,2,3,0,0,0,2,1,1,3,1,3,2,1,3,0,1,1,3,2,2,1,0,0,3,2,1,3,2,3,3,2,1,2,0,2,2,0,2,2,3,2,0,2,3,3,1,1,2,0,1,
                1,1,2,3,2,1,2,1,0,2,3,1,1,3,3,2,0,1,3,2,3,3,0,1,2,3,2,1,1,2,1,0,0,1,0,3,1,1,1,0,2,0,2,2,3,0,1,0,2,0,0,3,
                1,1,2,0,0,2,1,1,0,2,2,2,3,1,2,0,1,2,0,1,2,1,2,3,1,1,1,1,0,3,3,2,1,0,0,1,0,3,0,0,2,2,2,1,1,2,1,2,1,1,2,0,
                3,1,3,2,1,2,2,3,1,0,1,1,1,0,0,0,1,3,3,2,2,1,2,0,0,0,3,1,3,2,3,1,3,2,3,1,3,2,0,1,2,1,1,2,1,3,0,1,1,1,3,3,
                1,0,0,3,2,2,3,1,1,0,3,0,0,3,0,3,1,2,0,2,3,2,3,0,3,2,3,0,2,2,3,0,3,3,3,1,0,1,2,2,0,3,3,1,3,2,2,3,2,1,1,0,
                0,0,0,2,1,0,1,1,1,1,0,3,0,1,0,0,1,0,2,0,0,1,2,0,0,0,3,3,1,0,3,2,1,2,3,2,0,3,3,0,2,3,1,1,0,2,2,3,3,0,1,0,
                0,3,1,2,3,0,1,2,3,2,2,0,1,2,0,3,0,3,0,1,1,3,2,2,2,3,1,2,0,0,3,0,2,3,3,1,0,3,3,0,0,0,3,2,1,1,3,1,1,1,1,1,
                1,3,3,3,0,0,1,1,1,1,2,2,0,1,0,2,2,0,2,1,3,1,1,1,2,1,1,0,3,1,0,2,3,0,1,2,0,0,3,1,2,3,0,0,3,1,0,2,2,0,1,1,
                2,2,1,3,1,2,1,0,1,2,3,2,3,0,3,1,3,0,2,0,3,1,1,0,3,2,0,3,0,2,0,0,3,3,1,1,1,0,0,1,1,1,2,3,1,3,1,2,0,0,3,3,
                0,3,3,0,0,0,3,3,0,3,3,2,3,3,3,3,1,1,1,3,1,1,3,3,1,0,0,3,1,2,0,2,0,3,0,2,1,0,1,0,2,3,3,3,2,3,3,2,0,0,0,2,
                2,3,0,0,3,0,2,3,0,1,3,2,1,2,0,1,3,2,2,0,1,1,3,3,0,2,3,0,3,3,1,2,3,2,1,0,2,3,2,2,2,3,0,1,1,3,1,0,2,1,3,2,
                2,2,3,3,1,1,1,3,2,3,1,0,2,3,0,2,3,0,1,3,3,1,1,1,1,0,1,1,2,2,0,2,1,1,0,1,0,3,1,1,1,3,3,2,1,2,3,2,2,3,1,0,
                3,2,0,1,0,1,3,3,3,0,3,3,2,3,1,2,2,1,1,0,0,3,0};
        MinSidewaysJump sol = new MinSidewaysJump();
        System.out.println(sol.minSideJumps(obstacles));
    }
    public int minSideJumps(int[] obstacles) {
        int n = obstacles.length;
        int[][] dp = new int[n][4];
        dp[0][1] = 1;
        dp[0][2] = 0;
        dp[0][3] = 1;
        for(int i = 1; i < n; i++){
            for(int j = 1; j <= 3; j++){
                    dp[i][j] = Integer.MAX_VALUE;
                    if(obstacles[i] == j)continue;
                    for(int k = 1; k <= 3; k++){
                        if(obstacles[i - 1] != k && obstacles[i] != k){
                            if(k == j){
                                dp[i][j] = Math.min(dp[i][j], dp[i - 1][k]);
                            }else{
                                dp[i][j] = Math.min(dp[i][j], dp[i - 1][k] + 1);
                            }
                        }
                    }
            }
        }
        int ans = dp[n -1][1];
        ans = Math.min(ans, dp[n - 1][2]);
        ans = Math.min(ans, dp[n - 1][3]);
        return ans;
    }


}