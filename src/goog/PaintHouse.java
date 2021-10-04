package goog;

import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;

public class PaintHouse {
//    public static void main(String[] args) {
//        PriorityQueue<Pair> pq = new PriorityQueue<>(new Comparator<Pair>() {
//            @Override
//            public int compare(Pair o1, Pair o2) {
//                if(o1.value > o2.value)return 1;
//                if(o1.value < o2.value)return -1;
//                return 0;
//            }
//        });
//        int[] a = new int[]{7, 5, 8, 4};
//        int n = a.length;
//        for(int i = 0; i < n; i++){
//            pq.add(new Pair(i, a[i]));
//        }
//        System.out.println(pq.peek().index);
//    }
//static class Pair{
//        int index;
//        int value;
//        Pair(int index, int value){
//            this.index = index;
//            this.value = value;
//        }
//}
public int minCost(int[][] costs) {
    int n = costs.length;
    int m = costs[0].length;
    int[][] bestCost = new int[n][m];
    for(int j = 0; j < m; j++){
        bestCost[0][j] = costs[0][j];
    }
    for(int i = 1; i < n; i++){
        PriorityQueue<Pair> pq = new PriorityQueue<>(new Comparator<Pair>() {
            @Override
            public int compare(Pair o1, Pair o2) {
                if(o1.value > o2.value)return 1;
                if(o1.value < o2.value)return -1;
                return 0;
            }
        });
        for(int j = 0; j < m; j++){
            pq.add(new Pair(j, bestCost[i - 1][j]));
        }
        for(int j = 0; j < m; j++){
            if(j != pq.peek().index){
                bestCost[i][j] =  costs[i][j] + pq.peek().value;
            }else{
                Pair temp = pq.poll();
                bestCost[i][j] = costs[i][j] + pq.peek().value;
                pq.add(temp);
            }
        }
    }


    int sum = Integer.MAX_VALUE;
    for(int j = 0; j < m; j++){
        if(bestCost[n - 1][j] < sum){
            sum = Math.min(bestCost[n - 1][j], sum);
        }
    }


    return sum;
}
    static class Pair{
        int index;
        int value;
        Pair(int index, int value){
            this.index = index;
            this.value = value;
        }
    }
}