package goog.maximalRectangle;

import java.util.Stack;

public class MaximalRectangle {



    public static void main(String[] arg){
        MaximalRectangle sol = new MaximalRectangle();
        //char[][] a = new char[][]{{'1', '0', '1', '0', '0'}, {'1', '0', '1', '1', '1'}, {'1', '1', '1', '1', '1'},{'1', '0', '0', '1', '0'}};
        char[][] a = new char[][]{};
        System.out.println(sol.maximalRectangle(a));

    }

    public int maximalRectangle(char[][] matrix) {
        int ans = 0;
        int n = matrix.length;
        if(n == 0)return  0;
        int m = matrix[0].length;

        int[][] ht = new int[n][m];

        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                ht[i][j] = matrix[i][j] - '0';
            }
        }
        for(int i = 1; i < n; i++){
            for(int j = 0; j < m; j++){
                if(ht[i][j] == 1){
                    ht[i][j] = 1 + ht[i - 1][j];
                }
            }
        }
        for(int i = 0; i < n; i++){
            ans = Math.max(ans, getLargetRectArea(ht[i]));
        }


        return ans;
    }

    public int getLargetRectArea(int[] heights){
        int n = heights.length;
        int[] left = getJustPrevSmallerElementIndex(heights);
        int[] right = getJustNextSmallerElementIndex(heights);
        int ans = 0;
        for(int i = 0; i < n; i++){
            int area = heights[i] * (right[i] - left[i] + 1);
            ans = Math.max(ans, area );
            //System.out.print(area + " ");
        }
        //System.out.println();
        return ans;
    }

    public int[] getJustNextSmallerElementIndex(int[] a) {
        int n = a.length;
        int[] right = new int[n];
        right[n - 1] = n - 1;
        Stack<Integer> st = new Stack<>();
        st.push(n - 1);
        for(int i = n - 2; i >= 0; i--){
            while(!st.isEmpty() && a[st.peek()] >= a[i]){
                st.pop();
            }
            if(st.isEmpty()){
                right[i] = n - 1;
            }else{
                right[i] = st.peek() - 1;
            }
            st.push(i);
        }
        //print(right);
        return right;
    }

    public int[] getJustPrevSmallerElementIndex(int[] a){
        int n = a.length;
        int[] left = new int[n];
        left[0] = 0;
        Stack<Integer> st = new Stack<>();
        st.push(0);
        for(int i = 1; i < n; i++){
            while(!st.isEmpty() && a[st.peek()] >= a[i]){
                st.pop();
            }
            if(st.isEmpty()){
                left[i] = 0;
            }else{
                left[i] = st.peek() + 1;
            }
            st.push(i);
        }
        //print(left);
        return left;
    }
}
