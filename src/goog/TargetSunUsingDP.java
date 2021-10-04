package goog;

public class TargetSunUsingDP {
    public static void main(String[] args) {
        TargetSunUsingDP sol = new TargetSunUsingDP();
        int[] nums = new int[]{1, 1, 1, 1, 1};
        int target = 3;
//        int[] nums = new int[]{1, 1};
//        int target = 1;
//        int[] nums = new int[]{1};
//        int target = 1;
        System.out.println(sol.findTargetSumWays(nums, target));

    }
    public int findTargetSumWays(int[] nums, int target) {
        int n = nums.length;
        int[][] dp = new int[n + 1][2001];
        int origin = 1000;
        dp[0][origin] = 1;
        for(int i = 1; i <= n; i++){
            for(int sum = 0; sum < 2001; sum++){
                if(dp[i - 1][sum] > 0){
                    dp[i][sum + nums[i - 1]] += dp[i - 1][sum];
                    dp[i][sum - nums[i - 1]] += dp[i - 1][sum];
                }
            }
        }
        return dp[n][target + origin];
    }
}
