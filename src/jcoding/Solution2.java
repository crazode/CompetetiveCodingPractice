package jcoding;

public class Solution2 {
    public static void main(String[] args) {
        Solution2 sol = new Solution2();
        System.out.println(sol.solution(100000000, 100000000));
    }
    public int solution(int A, int B){
        long C = (long)A * (long)B;
        int ans = 0;
        while(C > 0){
            ans += C%2;
            C = C/2;
        }
        return ans;
    }
}
