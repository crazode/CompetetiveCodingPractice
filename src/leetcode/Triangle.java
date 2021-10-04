package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Triangle {
    List<List<Integer>> triangle = new ArrayList<>();


    public static void main(String[] arg){
        Triangle sol = new Triangle();
        ArrayList<Integer> temp1 = new ArrayList<>();
        temp1.add(2);
        ArrayList<Integer> temp2 = new ArrayList<>();
        temp2.add(2);
        temp2.add(2);
        ArrayList<Integer> temp3 = new ArrayList<>();
        temp3.add(11);
        temp3.add(7);
        temp3.add(5);

        sol.triangle.add(temp1);
        sol.triangle.add(temp2);
        sol.triangle.add(temp3);

        System.out.println(sol.minimumTotal(sol.triangle));


    }

    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();

        int[] dp = new int[n];
        dp[0] = triangle.get(0).get(0);
        for(int i = 1; i < n; i++){
            dp[i] = triangle.get(i).get(i) + dp[i - 1];
            for(int j = i - 1; j >= 0; j--){

                    dp[j] = triangle.get(i).get(j) + dp[j];
                    if(j > 0){
                        dp[j] = Math.min(dp[j], triangle.get(i).get(j) + dp[j - 1]);
                    }

            }
        }
        int ans = Integer.MAX_VALUE;
        for(int j = 0; j < n; j++){
            ans = Math.min(ans, dp[j]);
        }
        return ans;
    }

//    public int minimumTotal(List<List<Integer>> triangle) {
//        int n = triangle.size();
//
//        return minSum(1, 0, triangle.size() - 1, triangle, triangle.get(0).get(0));
//    }
//
//    public int minSum(int level, int oldIndex, int maxLevel, List<List<Integer>> triangle, int curSum){
//        if(level > maxLevel){
//            return curSum;
//        }else{
//            return Math.min(minSum(level + 1, oldIndex, maxLevel, triangle, curSum + triangle.get(level).get(oldIndex)),
//                    minSum(level + 1, oldIndex + 1, maxLevel, triangle, curSum + triangle.get(level).get(oldIndex + 1)));
//        }
//    }
}
