package gfgmustdo;

import java.util.HashMap;

public class CountTheTriplets {
    public static void main(String[] args){
       // int[] a = new int[]{1, 5, 3, 2};
       // int[] a = new int[]{2, 2, 5, 5, 5, 7};
        int[] a = new int[]{5, 2, 5, 7, 5, 2};
        int n = a.length;
        int ans = countTriplet(a, n);
        System.out.println(ans);
    }


    public static int countTriplet(int[] a, int n){
        int ans = 0;
        int sum = 0;
        for(int i = 0; i < n; i++){
            sum = a[i];
            HashMap<Integer, Integer> map = new HashMap<>();
            for(int j = 0; j < n; j++){
                if(i == j)continue;
                if(map.containsKey(a[j])){
                    map.put(a[j], map.get(a[j]) + 1);
                }else{
                    map.put(a[j], 1);
                }
                if(map.containsKey(sum - a[j])){
                    ans += map.get(sum - a[j]) ;

                }

            }
        }

        return ans;
    }
}
