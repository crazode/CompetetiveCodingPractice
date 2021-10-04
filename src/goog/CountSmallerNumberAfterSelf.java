package goog;

import java.util.ArrayList;
import java.util.List;

public class CountSmallerNumberAfterSelf {

    public static void main(String[] arg){
        //int[] nums = new int[]{5, 2, 6, 1};
        //int[] nums = new int[]{8, 2, 7, 5, 2, 1, 3};
        int[] nums = new int[]{-1};
        CountSmallerNumberAfterSelf sol = new CountSmallerNumberAfterSelf();
        List<Integer> ans = sol.countSmaller(nums);
        sol.print(ans);
    }

    public void print(List<Integer> ans){
        int n = ans.size();
        for(int i = 0; i < n; i++){
            System.out.print(ans.get(i) + " ");
        }
        System.out.println();
    }
    public List<Integer> countSmaller(int[] nums) {
        int n = nums.length;
        Pair[] pairs = new Pair[n];
        for(int i = 0; i < n ; i++){
            pairs[i] = new Pair(nums[i], i);
            nums[i] = 0;
        }
        split(pairs, nums, 0, n - 1);
        ArrayList<Integer> ans = new ArrayList<>();
        for(int i = 0; i < n; i++){
            ans.add(nums[i]);
        }
        return ans;
    }

    public void split(Pair[] pairs, int[] nums, int start, int end){
        if(end > start){
            int mid = start + (end - start)/2;
            split(pairs, nums, start, mid);
            split(pairs, nums, mid + 1, end);
            merge(pairs, nums, start, mid, end);
        }
    }

    public void merge(Pair[] pairs, int[] nums, int start, int mid, int end){
        int n1 = mid - start + 1;
        int n2 = end - mid;
        Pair[] left = new Pair[n1];
        Pair[] right = new Pair[n1];
        for (int i = 0; i < n1; ++i)
            left[i] = pairs[start + i];
        for (int j = 0; j < n2; ++j)
            right[j] = pairs[mid + 1 + j];
        int i = 0, j = 0;
        int k = start;
        while (i < n1 ) {
            while(j < n2 && left[i].val > right[j].val){
                pairs[k] = right[j];
                j++;
                k++;
            }
            nums[left[i].index] += (j == n2 )? n2 : j  ;
            pairs[k] = left[i];
            i++;
            k++;
        }
    }

    static class Pair{
        int val;
        int index;
        Pair(int val, int index){
            this.val = val;
            this.index = index;
        }
    }
}
