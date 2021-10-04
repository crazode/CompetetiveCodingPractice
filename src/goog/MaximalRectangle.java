package goog;

public class MaximalRectangle {
    public static void main(String[] arg) {
        //char[][] a = new char[][]{{'1', '0', '1', '0', '0'}, {'1', '0', '1', '1', '1'}, {'1', '1', '1', '1', '1'},{'1', '0', '0', '1', '0'}};
        //char[][] a = new char[][]{};
        //char[][] a = new char[][]{{'0', '1'}, {'0', '1'}};
        char[][] a = new char[][]{{'1', '0', '0', '0', '1'}, {'1', '1', '0', '1', '1'}, {'1', '1', '1', '1', '1'}};
        MaximalRectangle sol = new MaximalRectangle();
        System.out.println(sol.maximalRectangle(a));

    }

    public int maximalRectangle(char[][] matrix) {
        int n = matrix.length;
        if (n == 0) return 0;
        int m = matrix[0].length;

        int ans = 0;

        // prepare the initial cells
        Cell[][] cells = new Cell[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (matrix[i][j] == '0') {
                    cells[i][j] = new Cell(0);
                } else {
                    cells[i][j] = new Cell(1);

                }
            }
        }
        // calculation answer for last column(vertical rects)
        for (int i = 1; i < n; i++) {
            if (matrix[i][m - 1] == '1') {
                cells[i][m - 1].v = 1 + cells[i - 1][m - 1].v;
                cells[i][m - 1].v_ = 1 + cells[i - 1][m - 1].v_;
            }
        }

        //calculate ans for first row(horizontal rects)
        for (int j = m - 2; j >= 0; j--) {
            if (matrix[0][j] == '1') {
                cells[0][j].h = 1 + cells[0][j + 1].h;
                cells[0][j].h_ = 1 + cells[0][j + 1].h_;
            }
        }


        // calculating h
        for (int i = 1; i < n; i++) {
            for (int j = m - 2; j >= 0; j--) {
                if (matrix[i][j] == '1') {
                    cells[i][j].h = 1 + cells[i][j + 1].h;
                }
            }
        }
        //calculating v
        for (int j = 0; j < m; j++) {
            for (int i = 1; i < n; i++) {
                if (matrix[i][j] == '1') {
                    cells[i][j].v = 1 + cells[i - 1][j].v;
                }
            }
        }

        for (int i = 0; i < n; i++) {
            ans = Math.max(ans, cells[i][m - 1].v);

        }
        for (int j = 0; j < m; j++) {
            ans = Math.max(ans, cells[0][j].h);

        }

        for (int i = 1; i < n; i++) {
            for (int j = m - 2; j >= 0; j--) {

                if (matrix[i][j] == '1') {
                    int tempAns1 = 0;
                    int tempAns2 = 0;
                    int tempv1 = 0;
                    int temph1 = 0;
                    int tempv2 = 0;
                    int temph2 = 0;
                    if (matrix[i - 1][j + 1] == '1') {
                        tempv1 = 1 + Math.min(cells[i - 1][j].v, cells[i - 1][j + 1].v);
                        temph1 = 1 + Math.min(cells[i][j + 1].h, cells[i - 1][j + 1].h);

                        tempAns1 = tempv1 * temph1;
                    }
                    if (cells[i][j + 1].h > cells[i - 1][j].v) {
                        temph2 = 1 + cells[i][j + 1].h;
                        tempv2 = 1;
                    } else {
                        tempv2 = 1 + cells[i - 1][j].v;
                        temph2 = 1;
                    }
                    tempAns2 = temph2 * tempv2;


                    if (tempAns1 > tempAns2) {
                        cells[i][j].h_ = temph1;
                        cells[i][j].v_ = tempv1;
                    } else {
                        cells[i][j].h_ = temph2;
                        cells[i][j].v_ = tempv2;
                    }

                }
                ans = Math.max(ans, cells[i][j].h_ * cells[i][j].v_);
            }
        }
        return ans;

    }

    static class Cell {
        int v;
        int h;
        int v_;
        int h_;

        Cell(int val) {
            this.h = val;
            this.v = val;
            this.h_ = val;
            this.v_ = val;
        }
    }
}
