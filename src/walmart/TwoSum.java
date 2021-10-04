package walmart;

import java.util.HashMap;

public class TwoSum {
    public static void main(String[] args) {
        TwoSum sol = new TwoSum();
//        int[] nums = new int[]{2,7,11,15};
//        int target = 9;

        int[] nums = new int[]{3,2,4};
        int target = 6;
        int[] ans = sol.twoSum(nums, target);
        System.out.println(ans[0] + " " + ans[1]);
    }
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int n = nums.length;
        for(int i = 0; i < n; i++){
            if(map.containsKey(target - nums[i])){
                return new int[]{map.get(target - nums[i]), i};
            }else{
                map.put(nums[i], i);
            }
        }
        return new int[]{};

    }
}

