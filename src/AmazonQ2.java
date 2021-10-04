public class AmazonQ2 {
    static class BIT{
        int[] tree;
        BIT(int n){
            this.tree = new int[n + 1];
        }
        int get(int i){
            int sum = 0;
            for(int j = i; j > 0; j -= (j & (-j))){
                sum +=tree[j];
            }
            return sum;
        }
        void update(int i, int c){
            for(int j = i; j < tree.length; j+= (j & (-j))){
                tree[j] += c;
            }
        }
    }
    int[] countSmaller(int[] a){
        int[] ans = new int[a.length];
        if(a.length == 0)return ans;
        BIT bIT = new BIT(a.length);
        for(int i = 0; i < a.length; i++){
            ans[i] = bIT.get(a[i]);
            bIT.update(a[i], 1);
        }
        return ans;
    }
    int getBuildingCount(int N, int[] A, int[] K){
        int[] smaller = countSmaller(A);
        int count = 0;
        int max = Integer.MIN_VALUE;
        for(int i = 0; i < A.length; i++){
            if(smaller[i] <= K[i] && max <= A[i]){
                count++;
            }
            max = Math.max(max, A[i]);
        }
        return count;
    }
}
