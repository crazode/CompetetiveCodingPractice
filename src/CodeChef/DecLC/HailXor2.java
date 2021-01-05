package CodeChef.DecLC;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class HailXor2 {
    static ArrayList<Long> twos = new ArrayList<>();

    public static void main(String[] arg) throws Exception {
        twos.add((long)1);
        for(int i = 1; i < 32; i++){
            twos.add(2*twos.get(i - 1));
        }
        try{
            BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
            String T = input.readLine().trim();
            int t = Integer.parseInt(T);
            while (t-- > 0) {
                String[] NXStrings = input.readLine().split(" ");
                int N = Integer.parseInt(NXStrings[0]);
                long X = Long.parseLong(NXStrings[1]);

                long[] A = new long[N];
                String[] aStrings = input.readLine().split(" ");
                for (int i = 0; i < N; i++) {
                    A[i] = Long.parseLong(aStrings[i]);
                }
                printSmallestPossible(A, X, twos);
            }
        }catch(Exception e){

        }

    }

    public static void printSmallestPossible(long[] arr, long x, ArrayList<Long> twos){
        int n = arr.length;
        int i = 0;

        for(long k = x; i < n-1 && k>0; k--){
            int flag = 0;
            int p = (int)Math.round(Math.log(arr[i])/Math.log(2));

            arr[i] ^= twos.get(p);
            for(int j = i+1; j < n ; j++){

                    if((arr[j]^twos.get(p)) < arr[j]){
                    arr[j] = arr[j]^twos.get(p);
                    flag = 1;
                    break;
                }
            }
            if(flag == 0){
                arr[n - 1] ^= (1l << p);
            }
            while(arr[i]<=0)i++;
            long z = k+1;
            if(z>0){
                if(n<3 && z%2==0){
                    arr[n-1] = arr[n-1]^1;
                    arr[n-2] = arr[n-2]^1;
                }
            }
        }

        for(int k = 0 ; k < n ; k++){
            System.out.print(arr[k] + " ");
        }
        System.out.println();
    }

}
