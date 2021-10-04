package Kickstart2020.roundG;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class RoundF1 {
    public static void main(String[] arg) throws Exception{
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(input.readLine());
        int j = 1;
        while(t-->0){
            int n = Integer.parseInt(input.readLine());
            String s = input.readLine();
            char[] ch = s.toCharArray();
            int[] dist = new int[n];
            Arrays.fill(dist, Integer.MAX_VALUE);
            int nearest = Integer.MAX_VALUE;
            for(int i = 0; i < n; i++){
                if(ch[i] == '1'){
                    dist[i] = 0;
                    nearest = i;
                }else if(nearest != Integer.MAX_VALUE){
                    dist[i] = Math.min(Math.abs(i - nearest), dist[i]);
                }
            }
            for(int i = n - 1; i >= 0 ; i--){
                if(ch[i] == '1'){
                    dist[i] = 0;
                    nearest = i;
                }else if(nearest != Integer.MAX_VALUE){
                    dist[i] = Math.min(Math.abs(i - nearest), dist[i]);
                }
            }
            int ans = 0;
            for(int i = n - 1; i >= 0 ; i--){
                ans = ans + dist[i];
            }
            System.out.println("Case #" + j + ": " + ans);
            j++;
        }
    }
}
