package goog;

import java.io.BufferedReader;
import java.io.InputStreamReader;
public class Sol2 {
    public static void main(String[] args) throws Exception{
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(input.readLine());
        int i = 1;
        while(t-- > 0){
            long G = Long.parseLong(input.readLine());
            System.out.println("Case #" + i +": " + alienGen(G));
            i++;
        }
    }
    static long alienGen(long G){
        long g = (int) Math.ceil(Math.sqrt(2 * G));
        long ans = 0;
        for(long i = 1; i <= g; i++){
            if(validPair(i, G))ans++;
        }
        return ans;
    }
    static boolean validPair(long i, long G){
        if((2 * G) % i != 0)return false;
        long other = 2 * G/i;
        if((i + other - 1) % 2 != 0 || (other - 1 - i) % 2 != 0)return false;
        long n1 = (i + other - 1)/ 2;
        long n2 = (other - 1- i)/2;
        if(n1 > G || n1 < 0)return false;
        if(n2 > G || n2 < 0)return false;
        return true;
    }
}
