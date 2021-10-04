package goog;

import java.util.Comparator;
import java.util.PriorityQueue;

public class PaintHouse1 {
    public static void main(String[] args) {
        PaintHouse1 sol = new PaintHouse1();
        //int[][] costs = new int[][]{{17, 2, 17}, {16, 16, 5}, {14, 3, 19}};
        int[][] costs = new int[][]{{3, 5, 3}, {6, 17, 6}, {7, 13, 18}, {9, 10, 18}};
        System.out.println(sol.minCost(costs));
    }
    public int minCost(int[][] costs) {
        int n = costs.length;
        int m = costs[0].length;
        int[][] bestCost = new int[n][m];
        for(int j = 0; j < m; j++){
            bestCost[0][j] = costs[0][j];
        }
        for(int i = 1; i < n; i++){
            Pair firstMin = getFirstMin(bestCost[i - 1]);
            Pair secondMin = getSecondMin(bestCost[i - 1], firstMin.index);
            for(int j = 0; j < m; j++){
                if(j != firstMin.index){
                    bestCost[i][j] =  costs[i][j] + firstMin.value;
                }else{
                    bestCost[i][j] = costs[i][j] + secondMin.value;
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

    private Pair getSecondMin(int[] cost, int minIndex) {
        int n = cost.length;
        int min = Integer.MAX_VALUE;
        int index = minIndex;
        for(int i = 0; i < n; i++){
            if(cost[i] <= min && i != minIndex){
                index = i;
                min = cost[i];
            }
        }
        return new Pair(index, min);
    }

    private Pair getFirstMin(int[] cost) {
        int n = cost.length;
        int min = Integer.MAX_VALUE;
        int index = -1;
        for(int i = 0; i < n; i++){
            if(cost[i] < min){
                index = i;
                min = cost[i];
            }
        }
        return new Pair(index, min);
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