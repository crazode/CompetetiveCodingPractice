package goog;

public class RangeSumQuery {
    static class NumMatrix {
        int[][] matrix;
        int[][] sumMatrix;
        public NumMatrix(int[][] matrix) {
            this.matrix = matrix;
            findSumMatrix();
        }

        public void findSumMatrix(){
            int n = matrix.length;
            int m = matrix[0].length;
            sumMatrix = new int[n][m];
            for(int i = 0; i < n; i++){
                for(int j = 0; j < m; j++){
                    sumMatrix[i][j] = matrix[i][j];
                }
            }

            for(int i = 0; i < n; i++){
                for(int j = 0; j < m; j++){
                    int top = 0;
                    int left = 0;
                    int topLeft = 0;
                    if(i > 0){
                        top = sumMatrix[i - 1][j];
                    }
                    if(j > 0){
                        left = sumMatrix[i][j - 1];
                    }
                    if(i > 0 && j > 0){
                        topLeft = sumMatrix[i - 1][j - 1];
                    }
                    sumMatrix[i][j] = matrix[i][j] + top + left - topLeft;
                }
            }
        }

        public void update(int row, int col, int val) {
            int diff = val - matrix[row][col];
            int n = matrix.length;
            int m = matrix[0].length;
            this.matrix[row][col] = val;
            for(int i = row ; i < n; i++){
                for(int j = col; j < m; j++){
                    sumMatrix[i][j] += diff;
                }
            }
        }

        public int sumRegion(int row1, int col1, int row2, int col2) {
            int ans = sumMatrix[row2][col2];
            if(row1 > 0){
                ans -= sumMatrix[row1 - 1][col2];
            }
            if(col1 > 0){
                ans -= sumMatrix[row2][col1 - 1];
            }
            if(row1 > 0 && col1 > 0){
                ans += sumMatrix[row1 - 1][col1 - 1];
            }

            return ans;
        }
    }
}
