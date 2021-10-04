package googleio;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class PreviousMinimum {
    ArrayList<Integer> A = new ArrayList<>();
    public static void main(String[] arg){
        PreviousMinimum sol = new PreviousMinimum();
//        sol.A.add(5);
//        sol.A.add(7);
//        sol.A.add(11);
//        sol.A.add(2);
//        sol.A.add(12);
//        sol.A.add(4);

          sol.A.add(2);
        sol.A.add(2);
        sol.A.add(2);
        sol.A.add(2);
        sol.A.add(2);
        sol.A.add(2);

//        sol.A.add(10);
//        sol.A.add(4);
//        sol.A.add(2);
//        sol.A.add(4);
//        sol.A.add(6);
//        sol.A.add(20);
//        sol.A.add(40);
//        sol.A.add(12);
//        sol.A.add(30);

        int[] ans = sol.minimumGap(sol.A);
        for(int i = 0; i < ans.length; i++){
            System.out.print(ans[i] + " ");
        }
        System.out.println();
    }

    public int[] minimumGap(final List<Integer> A) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int n = A.size();
        for(int i = 0; i < n; i++){
            if(!map.containsKey(A.get(i)))
            map.put(A.get(i), i);
        }

        int[] compArray = new int[n];
        compArray[0] = A.get(0);
        int[] ans = new int[n];
        ans[0] = -1;
        for(int i = 1; i < n; i++){
            if(A.get(i - 1) > A.get(i)){
                compArray[i] = A.get(i - 1);
            }else if(compArray[i - 1] == A.get(i)){
                compArray[i] = compArray[map.get(compArray[i - 1])];
            }else{
                compArray[i] = Math.max(compArray[i - 1], A.get(i));
            }
            if(compArray[i] == A.get(i)){
                ans[i] = -1;
            }else{
                ans[i] = map.get(compArray[i]);
            }
        }
        return ans;

    }

//    public int[] minimumGap(final List<Integer> A) {
//        HashMap<Integer, Integer> map = new HashMap<>();
//        int n = A.size();
//        for(int i = 0; i < n; i++){
//            map.put(A.get(i), i);
//        }
//
//        int[] compArray = new int[n];
//        compArray[0] = A.get(0);
//        int[] ans = new int[n];
//        ans[0] = -1;
//        for(int i = 1; i < n; i++){
//            if(A.get(i - 1) > A.get(i)){
//                compArray[i] = A.get(i - 1);
//            }else{
//                compArray[i] = Math.max(compArray[i - 1], A.get(i));
//            }
//            if(compArray[i] == A.get(i)){
//                ans[i] = -1;
//            }else{
//                ans[i] = map.get(compArray[i]);
//            }
//        }
//        return ans;
//
//    }


}
