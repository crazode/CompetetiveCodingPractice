package leetcode;

public class BeautifulArrangeMent {
    public static void main(String[] arg){
        int[] ans = getArrangement(6,5);
        for(int i = 0; i < ans.length; i++){
          System.out.print(ans[i] + " ");
        }
        System.out.println();
    }
    public static int[] getArrangement(int n, int k){
        int[] ans = new int[n];
        if(k == 0)return ans;
        ans[0] = 1;

        boolean[] used = new boolean[n+1];
        used[1] = true;
        int j = -1;
        for(int i = 1; i < n; i++){
           if(i % 2 == 1){
               if( ans[i - 1] + k <= n && !used[ans[i - 1] + k]){
                   ans[i] = ans[i - 1] + k;
                   used[ans[i - 1] + k] = true;
               }else{
                   j = i;
                   break;
               }
           }else{
               if(ans[i - 1] - k >= 0 && !used[ans[i - 1] - k]){
                   ans[i] = ans[i - 1] - k;
                   used[ans[i - 1] - k] = true;
               }else{
                   j = i;
                   break;
               }
           }
           if(k > 1)k--;

        }
        int q = 1;

        while(j < n && j != -1){
            while(q <= n && used[q]){
                q++;
            }
            ans[j] = q;
            used[q] = true;
            j++;

        }
        return ans;
    }
}
