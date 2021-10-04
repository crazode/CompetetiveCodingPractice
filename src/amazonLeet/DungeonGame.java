package amazonLeet;

import java.util.LinkedList;
import java.util.Queue;
// wrong approach jo value pta hai use use kr k as nikalo rather than traversing from the start
public class DungeonGame {
    public static void main(String[] args) {
        DungeonGame sol = new DungeonGame();
        //int[][] dungeon = new int[][]{{-2,-3,3},{-5,-10,1},{10,30,-5}};
        //int[][] dungeon = new int[][]{{100}};
        //int[][] dungeon = new int[][]{{3,-20,30},{-3,4,0}};
        int[][] dungeon = new int[][]{{1,-3,3},{0,-2,0},{-3,-3,-3}};
        System.out.println(sol.calculateMinimumHP(dungeon));
    }
    public int calculateMinimumHP(int[][] dungeon) {
        Queue<Coordinate> q = new LinkedList<>();
        int n = dungeon.length;
        int m = dungeon[0].length;
//        if(n == 1 && m == 1){
//            if(dungeon[0][0] >= 0)return 1;
//            else return -1 * dungeon[0][0] + 1;
//        }
        q.add(new Coordinate(0, 0));
        Pair[][] bal = new Pair[n][m];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                bal[i][j] = new Pair(Integer.MAX_VALUE, Integer.MAX_VALUE);
            }
        }
        if(dungeon[0][0] <= 0){
            bal[0][0] = new Pair(-1 * dungeon[0][0] + 1, 1 );
        }else{
            bal[0][0] = new Pair(1, dungeon[0][0] + 1);
        }

        int[] xInc = new int[]{0, 1};
        int[] yInc = new int[]{1, 0};
        while(!q.isEmpty()){
            Coordinate coordinate = q.poll();
            for(int i = 0; i < 2; i++){
                int newX = coordinate.x + xInc[i];
                int newY = coordinate.y + yInc[i];
                if(isValid(newX, newY, n, m)){
                    if(bal[coordinate.x][coordinate.y].left + dungeon[newX][newY] > 0){
                        if(bal[coordinate.x][coordinate.y].spent  < bal[newX][newY].spent){
                            bal[newX][newY] = new Pair(bal[coordinate.x][coordinate.y].spent, bal[coordinate.x][coordinate.y].left + dungeon[newX][newY]);
                            q.add(new Coordinate(newX, newY));
                        }
                    }else if(bal[coordinate.x][coordinate.y].spent + 1  - (dungeon[newX][newY] + bal[coordinate.x][coordinate.y].left)  < bal[newX][newY].spent  ){
                        //&& bal[coordinate.x][coordinate.y].left + dungeon[newX][newY] <= 0
                        bal[newX][newY] = new Pair(bal[coordinate.x][coordinate.y].spent + 1  - (dungeon[newX][newY] + bal[coordinate.x][coordinate.y].left), 1);
                        q.add(new Coordinate(newX, newY));
                    }
                }
            }
        }
        return Math.max(1, bal[n - 1][m - 1].spent);
    }

    private boolean isValid(int newX, int newY, int n, int m) {
        if((newX >= 0 && newX < n) && (newY >= 0 && newY < m))return true;
        return false;
    }

    static class Coordinate{
        int x;
        int y;
        Coordinate(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
    static class Pair{
        int spent;
        int left;
        Pair(int spent, int left){
            this.spent = spent;
            this.left = left;
        }
    }
}
