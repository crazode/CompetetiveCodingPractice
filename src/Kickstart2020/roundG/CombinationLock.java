package Kickstart2020.roundG;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class CombinationLock {

    public static void main(String[] arg) throws Exception {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(input.readLine());
        int p = 1;
        while (t-- > 0) {
            String[] line2 = input.readLine().split(" ");
            int w = Integer.parseInt(line2[0]);
            long n = Long.parseLong(line2[1]);
            long[] a = new long[w];
            String[] line3 = input.readLine().split(" ");
            for (int i = 0; i < w; i++) {
                a[i] = Long.parseLong(line3[i]);
            }
            Arrays.sort(a);
            System.out.println("Case #" + p +": " + getMinSteps(a, n));
            p++;
        }
    }
    public static long getMinSteps(long[] a, long n){
        Arrays.sort(a);
        int w = a.length;
        long[] S = new long[w];
        S[0] = a[0];

        for(int i = 1; i < w; i++){
            S[i] = S[i - 1] + a[i];
        }
        long minSteps = Long.MAX_VALUE;
        for(int i = 0; i < w; i++){
            long mirror = getMirror(a[i], n);
            int j = -1; //index for the mirror
            long otherMirror = 0;
            if(mirror >= a[i]){
                j = getIndexOfRightMirror(mirror, a);
            }else if(mirror < a[i]){
                j = getIndexOfLeftMirror(mirror, a);
            }
            int k = -1; // index for other mirror
            long sum1 = 0;
            long sum2 = 0;
            long sum3 = 0;
            long sum4 = 0;
            long sum = 0;
            if(i == j){
                //k = i;
                if(i != 0){
                    sum1 = S[i - 1] + i * (n - a[i]);
                }
                if(j != w - 1){
                    sum4 = (n + a[i]) * ((w - 1) - (j + 1) + 1) - (S[w - 1] - S[j]);
                }
            }else if(i < j){
                otherMirror = a[i] - (mirror - a[i]);
                if(otherMirror <= 0){
                    k = 0;
                }else{
                    k = getIndexOfLeftMirror(otherMirror, a);
                }

                //k= Math.max(0, 2 * i - j);
                if(k > 0){
                    sum1 = S[k - 1] + k * (n - a[i]);
                }
                if(i > 0){
                    if(k == 0){
                        sum2 = ((i - 1) - k + 1) * a[i] - S[i - 1];
                    }else if(k > 0){
                        sum2 = ((i - 1) - k + 1) * a[i] - (S[i - 1] - S[k - 1]);
                    }
                }
                sum3 = (S[j] - S[i]) - (j - i) * a[i];
                if(j < w - 1){
                    sum4 = ((w - 1) - (j + 1) + 1) * (n + a[i]) - (S[w - 1] - S[j]);
                }
            }else if(i > j){
                otherMirror = a[i] + (a[i] - mirror);
                if(otherMirror > a[w - 1]){
                    k = w - 1;
                }else{
                    k = getIndexOfRightMirror(otherMirror, a);
                }

                //k =     Math.min(2 * i - j, w - 1);
                if(j > 0){
                    sum1 = S[j - 1] + j * (n - a[i]);
                }
                if(j > 0){
                    sum2 = ((i - 1) - j + 1) * a[i] - (S[i - 1] - S[j - 1]);
                }else if (j == 0){
                    sum2 = ((i - 1) - j + 1) * a[i] - S[i - 1] ;
                }
                if(i < w - 1){
                    sum3 = (S[k] - S[i]) - (k - (i + 1) + 1) * a[i];
                }
                if(k < w - 1){
                    sum4 = ((w - 1) - (k + 1) + 1) * (n + a[i]) - (S[w - 1] - S[k]);
                }
            }
            sum = sum1 + sum2 + sum3 + sum4;
            minSteps = Math.min(sum, minSteps);

        }
        return minSteps;
    }



    // this retrieves the mirror number
    public static long getMirror(long ai, long n){
        if(ai + (n / 2) == n)
            return n;
        if(n % 2 == 0){
            return (ai + (n / 2)) % n;
        }else{
            if(ai + (n / 2) < n){
                return (ai + (n / 2)) % n;
            }

            return ((ai + (n / 2)) % n) + 1;
        }
    }

    // this method is used when the mirror is greater than the number that means the mirror lies right to the number
    public static int getIndexOfRightMirror(long mirror, long[] a){
        int n = a.length;
        int start = 0;
        int end = n - 1;
        int mid = (start + end) / 2;
        int index = -1;
        if(a[end]  < mirror)
            return end;
        while(start < end && start != mid){
            mid = (start + end) / 2;
            if(a[start] == mirror){
                index = start;
                break;
            }else if(a[end] == mirror){
                index = end;
                break;
            }else if(a[mid] == mirror){
                index = mid;
                break;
            }else if(a[mid] > mirror){
                end = mid;
            }else{
                start = mid;
            }

        }
        if(index == -1){
            index = mid;
        }
        while(index < n - 1 && (a[index + 1] <= mirror) ){
            index ++;
        }


        return index;

    }

    // this method is used when the mirror is smaller than the number that means the mirror lies left to the number
    public static int getIndexOfLeftMirror(long mirror, long[] a){
        int n = a.length;
        int start = 0;
        int end = n - 1;
        int mid = (start + end) / 2;
        int index = -1;
        if(a[start]  > mirror)
            return start;
        while(start < end && start != mid){
            mid = (start + end) / 2;
            if(a[start] == mirror){
                index = start;
                break;
            }else if(a[end] == mirror){
                index = end;
                break;
            }else if(a[mid] == mirror){
                index = mid;
                break;
            }else if(a[mid] > mirror){
                end = mid;
            }else{
                start = mid;
            }
        }
        if(index == -1){
            index = end;
        }
        while(index > 0 && (a[index - 1] >= mirror) ){
            index --;
        }


        return index;

    }


}

