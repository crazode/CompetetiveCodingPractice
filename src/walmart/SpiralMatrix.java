package walmart;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {
    public static void main(String[] args) {
        SpiralMatrix sol = new SpiralMatrix();
        int[][] matrix = new int[][]{{1,2,3},{4,5,6},{7,8,9}};
        //int[][] matrix = new int[][]{{1,2,3,4},{5,6,7,8},{9,10,11,12}};
        List<Integer> ans = sol.spiralOrder(matrix);
        print(ans);
    }
    public static void print(List<Integer> ans){
        int n = ans.size();
        for(int i= 0; i < n; i++){
            System.out.print(ans.get(i) + " ");
        }
    }
    public List<Integer> spiralOrder(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        int count = Math.min(n, m) - 1;
        int x ;
        int y ;
        ArrayList<Integer> ans = new ArrayList<>();
        for(int c = 0; c <= count; c++){
            x = c;
            y = c;
            for(int j = y; j <= m - 1 - c; j++){
                ans.add(matrix[x][j]);
                y = j;
            }
            x = x + 1;
            for(int i = x; i <= n -1 - c; i++){
                ans.add(matrix[i][y]);
                x = i;
            }
            y = y - 1;
            for(int j = y; j >= c; j--){
                ans.add(matrix[x][j]);
                y = j;
            }
            x= x - 1;
            for(int i = x; i > c; i--){
                ans.add(matrix[i][y]);
                x = i;
            }
            y = y + 1;
        }
        return ans;
    }
}

