package goog;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Sol1 {
    public static void main(String[] args) throws Exception{
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(input.readLine());
        int i = 1;
        while(t-- > 0){
            String[] line2 = input.readLine().split(" ");
            int n = Integer.parseInt(line2[0]);
            int k = Integer.parseInt(line2[1]);
            String s = input.readLine();
            System.out.println("Case #" + i +": " + getPallindromeCount(s, n, k));
            i++;
        }
    }

    private static int getPallindromeCount(String s, int n, int k) {
        int[] a = new int[n];
        int[] b = new int[n];
        a[0] = s.charAt(0) - 'a' ;
        if(s.charAt(0) - 'a' <= s.charAt(n - 1) - 'a'){
            b[0] = 1;
        }
        long ans = a[0] + b[0];
        for(int i = 1; i <= (n-1)/2; i++){
            if(b[i - 1] > 1){
                a[i - 1] += b[i - 1] - 1;
                b[i - 1] = 1;
            }
            if(a[i - 1] > 0){
                a[i] = (a[i - 1]) * k ;
            }

            if(b[i - 1] > 0){
                b[i] = s.charAt(i) - 'a' + 1;
            }
            ans = Math.max(ans, a[i] + b[i])%1000000007;
        }
        if(isPallindrome(s, n)){
            ans--;
        }
        return (int)ans;
    }

    private static boolean isPallindrome(String s, int n) {
        for(int i = 0; i <= (n-1)/2; i++){
            if(s.charAt(i) != s.charAt(n - 1 - i))return false;
        }
        return true;
    }
}
