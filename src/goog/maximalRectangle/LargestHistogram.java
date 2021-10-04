package goog.maximalRectangle;

import java.util.Stack;

public class LargestHistogram {

    public static void main(String[] arg){
        LargestHistogram sol = new LargestHistogram();
        //int[] a = new int[]{2, 1, 5, 6, 2, 3};
        int[] a = new int[]{1, 1};
        sol.print(a);
        System.out.println(sol.getLargetRect(a));
    }

    public void print(int[] a){
        int n = a.length;
        for(int i = 0; i < n; i++){
            System.out.print(a[i] + " ");
        }
        System.out.println();
    }

    public int getLargetRect(int[] heights){
        int n = heights.length;
        int[] left = getJustPrevSmallerElementIndex(heights);
        int[] right = getJustNextSmallerElementIndex(heights);
        int ans = 0;
        for(int i = 0; i < n; i++){
            int area = heights[i] * (right[i] - left[i] + 1);
            ans = Math.max(ans, area );
            System.out.print(area + " ");
        }
        System.out.println();
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
        print(right);
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
        print(left);
        return left;
    }
}
