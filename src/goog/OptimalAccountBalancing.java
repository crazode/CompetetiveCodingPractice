package goog;

import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;

public class OptimalAccountBalancing {
    public static void main(String[] args) {
        OptimalAccountBalancing sol = new OptimalAccountBalancing();
        //int[][] transactions = new int[][]{{0, 1, 10}, {1, 0, 1}, {1, 2, 5}, {2, 0, 5}};
        //int[][] transactions = new int[][]{{1,5,8},{8,9,8},{2,3,9},{4,3,1}};
        int[][] transactions = new int[][]{{10,11,6},{12,13,7},{14,15,2},{14,16,2},{14,17,2},{14,18,2}};
        System.out.println(sol.minTransfers(transactions));
    }

    public int minTransfers(int[][] transactions) {
        int[] amount = new int[21];
        int n = transactions.length;
        for(int i = 0; i < n; i++){
            amount[transactions[i][0]] -= transactions[i][2];
            amount[transactions[i][1]] += transactions[i][2];
        }
        return getMinTransactionCount(amount);

    }

    private int getMinTransactionCount(int[] amount) {
        int ans = 0;

        while(true){
            int minIndex = getMinIndex(amount);
            int maxIndex = getMaxIndex(amount);
            if(amount[minIndex] != amount[maxIndex]){
                int temp = Math.min(amount[minIndex] + amount[maxIndex], 0);
                int diff = temp - amount[minIndex];
                amount[minIndex] = temp;
                amount[maxIndex] = amount[maxIndex] - diff;
                ans++;
            }else{
                break;
            }
        }
        return ans;
    }

    private int getMaxIndex(int[] amount) {
        int n = amount.length;
        int index= - 1;
        int max = Integer.MIN_VALUE;
        for(int i = 0; i < n; i++){
            if(amount[i] > max){
                max = amount[i];
                index = i;
            }
        }return index;
    }

    private int getMinIndex(int[] amount) {
        int n = amount.length;
        int index= - 1;
        int min = Integer.MAX_VALUE;
        for(int i = 0; i < n; i++){
            if(amount[i] < min){
                min = amount[i];
                index = i;
            }
        }return index;
    }


}
