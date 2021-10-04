package amazonLeet;

public class DungeonGame2 {
    public static void main(String[] args) {
        DungeonGame2 sol = new DungeonGame2();
        int[][] dungeon = new int[][]{{-2,-3,3},{-5,-10,1},{10,30,-5}};
        //int[][] dungeon = new int[][]{{100}};
        //int[][] dungeon = new int[][]{{3,-20,30},{-3,4,0}};
        //int[][] dungeon = new int[][]{{1,-3,3},{0,-2,0},{-3,-3,-3}};
        System.out.println(sol.calculateMinimumHP(dungeon));
    }
    public int calculateMinimumHP(int[][] dungeon) {

        int n = dungeon.length;
        int m = dungeon[0].length;
        int[][] bal = new int[n][m];

        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                bal[i][j] = Integer.MAX_VALUE;
            }
        }
        if(dungeon[n - 1][m - 1] < 0){
            bal[n - 1][m - 1] = -1 * dungeon[n - 1][m - 1] + 1;
        } else{
            bal[n - 1][m - 1] = 1;
        }
        int[] xInc = new int[]{0, 1};
        int[] yInc = new int[]{1, 0};
        for(int i = n - 1; i >= 0; i--){
            for(int j = m - 1; j >= 0; j--){
                for(int k = 0; k < 2; k++){
                    int newX = i + xInc[k];
                    int newY = j + yInc[k];
                    if(isValid(newX, newY, n, m)){
                       if(bal[newX][newY] - dungeon[i][j] <= 0 ){
                           bal[i][j] = 1;
                       }else{
                           bal[i][j] = Math.min(bal[newX][newY] - dungeon[i][j], bal[i][j]) ;
                       }
                    }
                }

            }
        }

//        for(int i = 0 ; i < n ; i++){
//            for(int j = 0 ; j < m ; j++){
//                System.out.print(bal[i][j]+" ");
//            }
//            System.out.println("");
//        }

        return bal[0][0];
    }
    private boolean isValid(int newX, int newY, int n, int m) {
        if((newX >= 0 && newX < n) && (newY >= 0 && newY < m))return true;
        return false;
    }
}
