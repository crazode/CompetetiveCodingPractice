package goog;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class PathWithMinEffort {
    public static void main(String[] args) {
        //int[][] heights = new int[][]{{1, 3}, {5, 2}};
        //int[][] heights = new int[][]{{1, 2, 2}, {3, 8, 2}, {5, 3, 5}};
        //int[][] heights = new int[][]{{1,2,3},{3,8,4},{5,3,5}};
        int[][] heights = new int[][]{{1,2,1,1,1},{1,2,1,2,1},{1,2,1,2,1},{1,2,1,2,1},{1,1,1,2,1}};
        PathWithMinEffort sol = new PathWithMinEffort();
        System.out.println(sol.minimumEffortPath(heights));
    }
    public int minimumEffortPath(int[][] heights) {
        int n = heights.length;
        int m = heights[0].length;
        int ans = Integer.MAX_VALUE;
        PriorityQueue<Pair> pq = new PriorityQueue<Pair>(new Comparator<Pair>(){
            @Override
            public int compare(Pair p1, Pair p2){
                return Math.abs(p1.hMod - p2.hMod);
            }
        });
        int[][] a = new int[n][m];
        for(int i = 0; i < n; i++){
            Arrays.fill(a[i], Integer.MAX_VALUE);
        }
        a[0][0] = 0;
        pq.add(new Pair(0, 0, 0));

        int[] xIncrement = new int[]{0, -1, 0, 1};
        int[] yIncrement = new int[]{-1, 0, 1, 0};

        while(!pq.isEmpty()){
            Pair pair = pq.poll();
            if(pair.xSelf == n - 1 && pair.ySelf == m - 1){
                ans = Math.min(ans, pair.hMod);
                continue;
            }
            for(int i = 0; i < 4; i++){
                int x = pair.xSelf + xIncrement[i];
                int y = pair.ySelf + yIncrement[i];
                if(isValid(x, y, n, m)){
                    int hMod = Math.max(Math.abs(heights[x][y] - heights[pair.xSelf][pair.ySelf]), pair.hMod);
                    if(hMod < a[x][y]){
                        a[x][y] = hMod;
                        pq.add(new Pair(x, y, hMod));
                    }

                }
            }
        }
        return ans;
    }
    public boolean isValid(int x, int y, int n, int m){
        if((x >= 0 && x < n) && (y >= 0 && y < m)){
            return true;
        }
        return false;
    }
    static class Pair{
        int xSelf;
        int ySelf;
        int hMod;

        Pair(int xS, int yS, int hMod){
            this.xSelf = xS;
            this.ySelf = yS;
            this.hMod = hMod;
        }
    }
}
