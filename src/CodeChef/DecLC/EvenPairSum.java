package CodeChef.DecLC;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class EvenPairSum {
    public static void main(String[] arg) throws Exception{
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(input.readLine());
        while(t-- > 0){
            String[] s = input.readLine().split(" ");
            long a = Long.parseLong(s[0]);
            long b = Long.parseLong(s[1]);
            System.out.println(getPairCount(a, b ));
        }
    }

    public static long getPairCount(long a, long b){
        long aeven = a/2;
        long aodd = a - aeven;
        long beven = b/2;
        long bodd = b - beven;
        return (aeven * beven) + (aodd * bodd);
    }
}
