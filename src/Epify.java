import java.util.Arrays;
import java.util.Comparator;

public class Epify {
    public static void main(String[] args) {
        long[] pickup = new long[]{0, 2, 9, 10, 11, 12};
        long[] drop = new long[]{5, 9, 11,11, 14, 17};
        long[] tip = new long[]{1, 2, 3,2,2,1};
//        long[] pickup = new long[]{1, 2};
//        long[] drop = new long[]{3, 6};
//        long[] tip = new long[]{1, 1};
        Epify sol = new Epify();
        System.out.println(sol.getMaxFare(pickup, drop, tip));
    }
    public static long getMaxFare(long[] pickup, long[] drop, long[] tip){
        int n = tip.length;
        Pair[] pairs = new Pair[n];
        for(int i = 0; i < n; i++){
            pairs[i] = new Pair(pickup[i], drop[i], drop[i] - pickup[i] + tip[i]);
        }
        long[] dp = new long[n + 1];
        Arrays.fill(dp, -1);
        Arrays.sort(pairs, new Comparator<Pair>() {
            @Override
            public int compare(Pair o1, Pair o2) {
                long val = o1.p - o2.p;
                if(val == 0){
                    val = o2.t - o1.t;
                }
                if(val == 0)return 0;
                if(val > 0)return 1;
                return -1;
            }
        });

        return getMaxFareSubFun(0, 0, pairs, dp);
    }

    private static long getMaxFareSubFun(int startIndex, long startPoint, Pair[] pairs, long[] dp) {
        int n = pairs.length;
        if(startIndex >= n)return 0;
        if(dp[startIndex] != -1 && pairs[startIndex].p >= startPoint)return dp[startIndex];
        long ans = 0l;
        if(pairs[startIndex].p < startPoint){
            ans = getMaxFareSubFun(startIndex + 1, startPoint, pairs, dp);
        }else{
            ans = Math.max( getMaxFareSubFun(startIndex + 1, startPoint, pairs, dp),
                    pairs[startIndex].t + getMaxFareSubFun(startIndex + 1, pairs[startIndex].d, pairs, dp));
        }
        dp[startIndex] = ans;
        return ans;
    }

    public static class Pair{
        long p;
        long d;
        long t;
        Pair(long p, long d, long t){
            this.p = p;
             this. d = d;
             this.t = t;
        }
    }
}
