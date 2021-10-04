//package SWE;
//
//import javax.management.StringValueExp;
//import java.util.ArrayList;
//import java.util.HashMap;
//import java.util.Map;
//
//public class prac {
//    public static void main(String[] arg){
//        int[] from = new int[]{1, 1, 2, 2};
//        int[] to = new int[]{3,3,4,4};
//        int n = 4;
//        int ans = myFun(n, from, to);
//        System.out.println(ans);
//    }
//    public static int myFun(int n, int[] from, int[] to, int[] wt){
//        HashMap<Integer, ArrayList<ArrayList<Integer>>> map = new HashMap<>();
//        for(int i = 0; i< n; i++){
////            String s1= String.valueOf(from[i] + "_" + to[i]);
////            String s2= String.valueOf(to[i] + "_" + from[i]);
//
//            if(map.containsKey(wt[i])){
//                map.put(wt[i], map.get(wt[i]) + 1);
//            }else{
////                map.put(,  1);
////                map.put(s2, 1);
//            }
//        }
//        int maxCon = Integer.MIN_VALUE;
//        int a= -1;
//        int b= -1
//        for(Map.Entry<String, Integer> entry : map){
//            String s = entry.getKey();
//            String s2 = "";
//            boolean found = false;
//            for(int i = 0; i < s.length(); i++){
//                if(s.charAt(i) == '_')
//                if(!found){
//                    s2 = s2 + s.charAt(i);
//                }
//            }
//
//            if (entry.getValue() > maxCon){
//
//            }
//        }
//
//    }
//}
