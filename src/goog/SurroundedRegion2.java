package goog;

import java.util.LinkedList;
import java.util.Queue;

public class SurroundedRegion2 {
    public static void main(String[] arg){
        //char[][] a = new char[][]{{'X', 'X', 'X', 'X'}, {'X', 'O', 'O', 'X'}, {'X', 'X', 'O', 'X'}, {'X', 'O', 'X', 'X'} };
        char[][] a = new char[][]{{'O', 'X', 'X', 'O', 'X'}, {'X', 'O', 'O', 'X', 'O'}, {'X', 'O', 'X', 'O', 'X'}, {'O', 'X', 'O', 'O', 'O'}, {'X', 'X', 'O', 'X', 'O'} };
        SurroundeRegions sol = new SurroundeRegions();
        sol.print(a);
        System.out.println();
        sol.solve(a);
        sol.print(a);
    }

    public void print(char[][] ch){
        int n = ch.length;
        int m = ch[0].length;

        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                System.out.print(ch[i][j] + " ");
            }
            System.out.println();
        }
    }

    public void solve(char[][] board) {
        int n = board.length;
        int m = board[0].length;
        boolean[][] bool = new boolean[n][m];

        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                bool[i][j] = true;
            }
        }
        Queue<Pair> q1 = new LinkedList<>();
        for(int i = 1; i < n - 1; i++){
            if(board[i][0] == 'O'){
                bool[i][0] = false;
                q1.add(new Pair(i, 0));
            }
            if(board[i][m - 1] == 'O'){
                bool[i][m - 1] = false;
                q1.add(new Pair(i, m - 1));
            }
        }

        for(int j = 0; j < m; j++){
            if(board[0][j] == 'O'){
                bool[0][j] = false;
                q1.add(new Pair(0, j));
            }
            if(board[n - 1][j] == 'O'){
                bool[n - 1][j] = false;
                q1.add(new Pair(n - 1, j));
            }
        }
        int[] incrementX = new int[]{-1, 0, 1, 0};
        int[] incrementY = new int[]{0, 1, 0, -1};
        while(!q1.isEmpty()){
            Pair temp = q1.poll();

            for(int k = 0; k < 4; k++){
                int x = temp.x + incrementX[k];
                int y = temp.y + incrementY[k];

                if(isValid(x, y, n, m)){
                    if(board[x][y] == 'O' && bool[x][y]){
                        bool[x][y] = false;
                        q1.add(new Pair(x, y));
                    }
                }
            }
        }
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(bool[i][j] && board[i][j] == 'O'){
                    board[i][j] = 'X';
                }
            }
        }

    }

    public boolean isValid(int i, int j, int n, int m){
        if((i >= 0 && i < n) && (j >= 0 && j < m))return true;
        return false;
    }

    static class Pair{
        int x;
        int y;
        Pair(int x, int y){
            this.x = x;
            this.y = y;
        }
    }


}


