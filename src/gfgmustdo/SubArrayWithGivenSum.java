package gfgmustdo;

import java.util.ArrayList;

public class SubArrayWithGivenSum {
    public static void main(String[] args) {
        int[] a = {1, 2, 3, 7, 5};
        int n = a.length;
        int s = 12;
        ArrayList<Integer> ans = subArraySum(a, n, s);
        for (int i = 0; i < ans.size(); i++) {
            System.out.print(ans.get(i) + " ");
        }
        System.out.println();
    }
    public static ArrayList<Integer> subArraySum(int[] arr, int n, int s) {
        ArrayList<Integer> ans = new ArrayList<>();
        int csum=0,header=0,flag=0;
        for(int j=0;j<n;j++)
        {
            csum+=arr[j];
            while(csum>s)

            {
                csum=csum-arr[header];
                header++;
            }
            if(csum==s)
            {
                flag=1;
                ans.add(header + 1);
                ans.add(j + 1);
                return ans;
            }
        }
        ans.add(-1);
        return ans;
    }
}
