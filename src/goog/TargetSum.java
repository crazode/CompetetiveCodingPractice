package goog;

public class TargetSum {
    static int count = 0;

    public static void main(String[] args) {
        TargetSum sol = new TargetSum();
//        int[] nums = new int[]{1, 1, 1, 1, 1};
//        int target = 3;
//        int[] nums = new int[]{1, 1};
//        int target = 1;
        int[] nums = new int[]{1};
        int target = 1;
        count = 0;
        System.out.println(sol.findTargetSumWays(nums, target));

    }
    public int findTargetSumWays(int[] nums, int target) {
        updateCount(nums, 1, target, nums[0]);
        updateCount(nums, 1, target, -1*nums[0]);
        return count;
    }

    private void updateCount(int[] nums, int i, int target, int sum) {
        if(sum == target && i == nums.length)count++;
        if(i == nums.length)return;
        updateCount(nums, i + 1, target, sum + nums[i]);
        updateCount(nums, i + 1, target, sum - nums[i]);
    }
}
