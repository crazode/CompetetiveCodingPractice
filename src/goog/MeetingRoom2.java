package goog;

import interviewbit.MergeIntervals;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Stack;

public class MeetingRoom2 {

    public static void main(String[] args) {
        MeetingRoom2 sol = new MeetingRoom2();
        //int[][] intervals = new int[][]{{0, 30}, {5, 10}, {15, 20}};
        //int[][] intervals = new int[][]{{7, 10}, {2, 4}};
        int[][] intervals = new int[][]{{13, 15}, {1, 13}};
        System.out.println(sol.minMeetingRooms(intervals));
    }

    public int minMeetingRooms(int[][] intervals) {
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });
        int ans = Integer.MIN_VALUE;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        //Stack<Integer> st = new Stack<>();
        int n = intervals.length;
        for(int i = 0; i < n; i++){
            if(pq.isEmpty()){
                pq.add(intervals[i][1]);
            }else{
                while(!pq.isEmpty() && intervals[i][0] >= pq.peek()){
                    pq.poll();
                }
                pq.add(intervals[i][1]);
            }
            ans = Math.max(ans, pq.size());
        }
        return ans;
    }
}
