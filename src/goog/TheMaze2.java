//package goog;
//
//import java.util.Arrays;
//import java.util.LinkedList;
//import java.util.Queue;
//
//public class TheMaze2 {
//    public static void main(String[] args) {
//        TheMaze2 sol = new TheMaze2();
////        int[][] maze = new int[][]{{0,0,1,0,0},{0,0,0,0,0},{0,0,0,1,0},{1,1,0,1,1},{0,0,0,0,0}};
////        int[] start = new int[]{0, 4};
////        int[] destination = new int[]{4, 4};
//
//        int[][] maze = new int[][]{{0,0,0,0,1,0,0},{0,0,1,0,0,0,0},{0,0,0,0,0,0,0},{0,0,0,0,0,0,1},{0,1,0,0,0,0,0},{0,0,0,1,0,0,0},{0,0,0,0,0,0,0},{0,0,1,0,0,0,1},{0,0,0,0,1,0,0}};
//        int[] start = new int[]{0, 0};
//        int[] destination = new int[]{8, 6};
//        System.out.println(sol.shortestDistance(maze, start, destination));
//    }
//    public int shortestDistance(int[][] maze, int[] start, int[] destination) {
//        int n = maze.length;
//        int m = maze[0].length;
//        Queue<int[]> q = new LinkedList<int[]>();
//        q.add(new int[]{start[0], start[1], 0});
//        //boolean[][] visited = new boolean[n][m];
//        int[][] dist = new int[n][m];
//        Arrays.fill(dist, Integer.MAX_VALUE);
//        int depth = 1;
//        int distance = Integer.MAX_VALUE;
//        while(!q.isEmpty()){
//            int size = q.size();
//            while(size-- > 0){
//                int[] top = q.poll();
//                dist[top[0]][top[1]] = top[2];
//                if(top[0] == destination[0] && top[1] == destination[1]){
//                    distance = Math.min(distance, top[2]);
//                }
//                int[] up =  getCell(top,1, maze, n, m);
//                if(isValid(up, maze) && dist[up[0]][up[1]] < ){
//                    q.add(new int[]{up[0], up[1], top[2] + Math.abs(top[0] - up[0]) + Math.abs(top[1] - up[1])});
//                }
//                int[] right = getCell(top,2, maze, n, m);
//                if(isValid(right, maze, visited)){
//                    q.add(new int[]{right[0], right[1], top[2] + Math.abs(top[0] - right[0]) + Math.abs(top[1] - right[1])});
//                }
//                int[] down = getCell(top,3, maze, n, m);
//                if(isValid(down, maze, visited)){
//                    q.add(new int[]{down[0], down[1], top[2] + Math.abs(top[0] - down[0]) + Math.abs(top[1] - down[1])});
//                }
//                int[] left = getCell(top,4, maze, n, m);
//                if(isValid(left, maze, visited)){
//                    q.add(new int[]{left[0], left[1], top[2] + Math.abs(top[0] - left[0]) + Math.abs(top[1] - left[1])});
//                }
//            }
//
//        }
//        if(distance != Integer.MAX_VALUE)return distance;
//        return -1;
//    }
//    private int[] getCell(int[] top, int direction, int[][] maze, int n, int m){
//        int i = top[0];
//        int j = top[1];
//        switch(direction){
//            case 1://for top
//                while(i > 0 && maze[i - 1][j] != 1){
//                    i --;
//                }
//                break;
//            case 2:// for right
//                while(j < m - 1 && maze[i][j+1] != 1){
//                    j++;
//                }
//                break;
//
//            case 3:
//                while(i < n - 1 && maze[i+1][j] != 1){
//                    i ++;
//                }
//                break;
//
//            case 4:
//                while(j > 0 && maze[i][j-1] != 1){
//                    j--;
//                }
//                break;
//            default:
//                break;
//        }
//        return new int[]{i, j};
//    }
//
//    private boolean isValid(int[] in, int[][] maze, boolean[][] visited) {
//        if(maze[in[0]][in[1]] == 0 && !visited[in[0]][in[1]])return true;
//        return false;
//    }
//
//}