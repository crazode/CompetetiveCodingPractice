package goog;

public class WhereWillTheBallFall {
    public static void main(String[] args) {
        //int[][] grid = new int[][]{{1,1,1,-1,-1},{1,1,1,-1,-1},{-1,-1,-1,1,1},{1,1,1,1,-1},{-1,-1,-1,-1,-1}};
        int[][] grid = new int[][]{{1,1,1,1,1,1},{-1,-1,-1,-1,-1,-1},{1,1,1,1,1,1},{-1,-1,-1,-1,-1,-1}};
        WhereWillTheBallFall sol =  new WhereWillTheBallFall();
        int[] ans = sol.findBall(grid);
        for(int i = 0; i < grid[0].length; i++){
            System.out.print(ans[i] + " ");
        }
        System.out.println();
    }
    public int[] findBall(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int[] ans = new int[m];
        for(int i = 0; i < m; i++){
            ans[i] = willBallExit(0, i, grid, n, m);
        }
        return ans;
    }

    public int willBallExit(int x, int y, int[][] grid, int n, int m){
        int ans = -1;
        while(x < n){
            if(grid[x][y] == 1){
                if(y + 1 < m){
                    if(grid[x][y + 1] == 1){
                        x = x + 1;
                        y = y + 1;
                        ans = y ;
                        continue;
                    }else return -1;
                }else return -1;
            }else if(grid[x][y] == -1){
                if(y - 1 >= 0){
                    if(grid[x][y  -1] == -1){
                        x = x + 1;
                        y = y - 1;
                        ans = y ;
                        continue;
                    }else return -1;
                }else return -1;
            }
        }
        return ans;
    }
}