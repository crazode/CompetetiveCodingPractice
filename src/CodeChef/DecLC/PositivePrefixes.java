package CodeChef.DecLC;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class PositivePrefixes {
    public static void main(String[] arg) throws Exception{
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        int[] b = new int[1000001];
        //int sum = 0;
        int[] sum = new int[1000001];
        for(int i = 1; i <= 1000000; i++){
            if(sum[i-1] - i > 0){
                b[i] = -i;
                sum[i] = sum[i-1] - i;
            }else{
                b[i] = i;
                sum[i] = sum[i-1] + i;
            }
        }
        int t = Integer.parseInt(input.readLine());
        while(t-- > 0){
            String[] s = input.readLine().split(" ");
            int n = Integer.parseInt(s[0]);
            int k = Integer.parseInt(s[1]);
            print(b, n, k);
        }
    }
    public static void print(int[] b, int n, int k){
        StringBuilder sb = new StringBuilder("");

        for(int i = 1; i <= k - 1 ;i++){
            sb.append(b[i]);
            sb.append(" ");
            //System.out.print(b[i] + " ");
        }
        if(n == k){
            sb.append(b[k]);
            sb.append(" ");

            System.out.println(sb.toString());
            return;
        }
        if(n > k){
            if(b[k + 1] < 0){
                sb.append(-1 * b[k]);
                sb.append(" ");
                sb.append(-1 * b[k+1]);
                sb.append(" ");

            }else{
                sb.append(b[k]);
                sb.append(" ");
                sb.append(-1 * Math.abs(b[k+1]));
                sb.append(" ");

            }
            for(int i = k + 2; i <= n; i++){
                sb.append(-1 * i);
                sb.append(" ");

            }
        }
        System.out.println(sb.toString());
    }

}
