package Kickstart2020.roundG;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import java.text.DecimalFormat;

public class MergeCards {
    public static void main(String[] arg) throws Exception{
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(input.readLine());
        while(t-- > 0){
            int n = Integer.parseInt(input.readLine());
            String[] line2 = input.readLine().split(" ");
            long[] a = new long[n];
            for(int i = 0; i < n; i++){
                a[i] = Long.parseLong(line2[i]);
            }
            double ans = 0;
            for(int x = 0; x < n - 1; x++){
                for(int i = x; i >= 0; i--){
                    ans = ans + (double)Math.round(a[i]*1000000d/(double)(x - i + 1))/1000000d;
                }
                for(int i = x + 1; i < n; i++){
                    ans = ans + (double)Math.round(a[i]*1000000d/(double)(i - x))/1000000d;
                }
            }
            DecimalFormat df = new DecimalFormat();
            df.setMaximumFractionDigits(6);
            System.out.println(df.format(ans));
            //ans = (double)Math.round(ans * 1000000d) / 1000000d;

        }

    }
}
