package CodeChef.DecLC;

import com.sun.org.glassfish.gmbal.ManagedAttribute;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class VaccineDistribution {
    public static void main(String[] arg) throws Exception{
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(input.readLine());
        while(t-- > 0){
            String[] s1 = input.readLine().split(" ");
            String[] s2 = input.readLine().split(" ");
            int n = Integer.parseInt(s1[0]);
            int d = Integer.parseInt(s1[1]);
            int[] a = new int[n];
            for(int i = 0; i < n; i++){
                a[i] = Integer.parseInt(s2[i]);
            }
            System.out.println(getDaysCount(a, n , d));
        }
    }
    public static int getDaysCount(int[] a, int n, int d){
        int count = 0;
        for(int i = 0; i < n; i++){
            if(a[i] <= 9 || a[i] >= 80){
                count++;
            }
        }
        double daysCount = 0;
        daysCount = Math.ceil(count/(d * 1.0));
        daysCount = daysCount + Math.ceil((n - count)/(d * 1.0));
        return (int) daysCount;
    }
}
