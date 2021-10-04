package goog;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Leetcode1499 {
    public static void main(String[] args) {
        PriorityQueue<Pair> pq = new PriorityQueue<>(new Comparator<Pair>() {
            @Override
            public int compare(Pair o1, Pair o2) {
                return o2.val - o1.val;
            }
        });

        pq.add(new Pair(0, 3));
        pq.add(new Pair(1, 5));
        pq.add(new Pair(2, 6));
        pq.add(new Pair(3, 4));
//        while(!pq.isEmpty()){
//            System.out.println(pq.poll().val);
//        }
//        int[][] points = new int[][]{{0, 3}, {1, 5}, {2, 6}, {3, 4}};
//        int k = 1;
//        int[][] points = new int[][]{{-17,5},{-10,-8},{-5,-13},{-2,7},{8,-14}};
//        int k = 4;
        int[][] points = new int[][]{{-19,-12},{-13,-18},{-12,18},{-11,-8},{-8,2},{-7,12},{-5,16},{-3,9},{1,-7},{5,-4},{6,-20},{10,4},{16,4},{19,-9},{20,19}};
        int k = 6;
        Leetcode1499 sol = new Leetcode1499();
        System.out.println(sol.findMaxValueOfEquation(points, k));

    }
    public int findMaxValueOfEquation(int[][] points, int k) {
        int n = points.length;
        PriorityQueue<Pair> pq = new PriorityQueue<>(new Comparator<Pair>(){
            @Override
            public int compare(Pair p1, Pair p2){
                return p2.val - p1.val;
            }
        });
        pq.add(new Pair(points[0][0], points[0][1] - points[0][0]));
        int ans = Integer.MIN_VALUE;
        for(int j = 1; j < n; j++){
            while(!pq.isEmpty() && points[j][0] - pq.peek().index > k){
                pq.poll();
            }
            if(!pq.isEmpty()){
                ans = Math.max(ans, pq.peek().val + points[j][0] + points[j][1]);
            }
            pq.add(new Pair(points[j][0], points[j][1] - points[j][0]));
        }
        return ans;
    }
    static class Pair{
        int index;
        int val;
        Pair(int index, int val){
            this.index = index;
            this.val = val;
        }
    }
}