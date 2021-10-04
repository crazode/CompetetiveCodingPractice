package goog;

import java.util.*;

public class MaxDistPath {

    int[][] grid = new int[][]{ {0, 1, 0}};

    public static void main(String[] arg){
        MaxDistPath sol = new MaxDistPath();
        int n = sol.grid.length;
        System.out.println(sol.getMaxDistPath(sol.grid, n));

    }

    public int getMaxDistPath(int[][] grid, int n){
        Queue<CoordinateDistPair> q = new LinkedList<>();
        Queue<Coordinate> parentQ = new LinkedList<>();



        for(int j = 0; j < n;  j++){
            if(grid[0][j] == 0){
                q.add(new CoordinateDistPair(0, j, 0));
                parentQ.add(new Coordinate(0, j));
            }
        }
        int[] xIncrement = new int[]{0, 0 ,1};
        int[] yIncrement = new int[]{-1, 1, 0};
        int ans = Integer.MIN_VALUE;
        while(!q.isEmpty()){
            CoordinateDistPair temp = q.poll();
            Coordinate parent = parentQ.poll();
            int curDist = temp.dist;

            if(temp.coordinate.x == n - 1){
                ans = Math.max(curDist, ans);
                continue;
            }
            for(int i  = 0; i < 3; i++){
                int xCoordinate = temp.coordinate.x + xIncrement[i];
                int yCoordinate = temp.coordinate.y + yIncrement[i];
                if(isValid(xCoordinate, yCoordinate, n, parent, grid)){
                    q.add(new CoordinateDistPair(xCoordinate, yCoordinate, curDist + 1));
                    parentQ.add(temp.coordinate);
                }
            }

        }
        if(ans == Integer.MIN_VALUE)return -1;
        return ans;
    }

    public boolean isValid(int x, int y, int n, Coordinate parent, int[][] grid){
        if((x < 0)|| (x >= n) || (y < 0) || (y >= n))return false;
        if(x == parent.x && y == parent.y)return false;
        if((x >= 0 && x < n) && (y >= 0 && y < n)){
            if(grid[x][y] == 0)return true;
        }
        return false;
    }

    static class CoordinateDistPair{
        Coordinate coordinate;
        int dist;

        CoordinateDistPair(int x, int y, int dist){
            this.coordinate = new Coordinate(x, y);
            this.dist = dist;
        }
    }

    static class Coordinate{
        int x;
        int y;

        Coordinate(int x, int y){
            this.x = x;
            this.y = y;
        }
    }


}
