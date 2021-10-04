package goog;

import java.util.LinkedList;
import java.util.Queue;

public class TheMaze {
    public static void main(String[] args) {
        TheMaze sol = new TheMaze();
        int[][] maze = new int[][]{{0,0,1,0,0},{0,0,0,0,0},{0,0,0,1,0},{1,1,0,1,1},{0,0,0,0,0}};
        int[] start = new int[]{0, 4};
        int[] destination = new int[]{4, 4};
        System.out.println(sol.hasPath(maze, start, destination));
    }
    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        int n = maze.length;
        int m = maze[0].length;
        Queue<int[]> q = new LinkedList<int[]>();
        q.add(start);
        boolean[][] visited = new boolean[n][m];
        int depth = 1;
        while(!q.isEmpty()){
            int size = q.size();
            while(size-- > 0){
                int[] top = q.poll();
                visited[top[0]][top[1]] = true;
                if(top[0] == destination[0] && top[1] == destination[1]){
                    return true;
                }
                int[] up =  getCell(top,1, maze, n, m);
                if(isValid(up, maze, visited)){
                    q.add(up);
                }
                int[] right = getCell(top,2, maze, n, m);
                if(isValid(right, maze, visited)){
                    q.add(right);
                }
                int[] down = getCell(top,3, maze, n, m);
                if(isValid(down, maze, visited)){
                    q.add(down);
                }
                int[] left = getCell(top,4, maze, n, m);
                if(isValid(left, maze, visited)){
                    q.add(left);
                }
            }
           depth++;
        }
        return false;
    }
    private int[] getCell(int[] top, int direction, int[][] maze, int m, int n){
        int i = top[0];
        int j = top[1];
        switch(direction){
            case 1://for top
                while(i > 0 && maze[i - 1][j] != 1){
                    i --;
                }
                    break;
            case 2:// for right
                while(j < m - 1 && maze[i][j+1] != 1){
                    j++;
                }
                break;

            case 3:
                while(i < n - 1 && maze[i+1][j] != 1){
                    i ++;
                }
                break;

            case 4:
                while(j > 0 && maze[i][j-1] != 1){
                    j--;
                }
                break;
            default:
                break;
        }
        return new int[]{i, j};
    }

    private boolean isValid(int[] in, int[][] maze, boolean[][] visited) {
        if(maze[in[0]][in[1]] == 0 && !visited[in[0]][in[1]])return true;
        return false;
    }

}