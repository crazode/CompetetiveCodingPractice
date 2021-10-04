package gfgmustdo;

public class Factors {

    public static void main(String[] args) {
        int[] a = new int[]{5, 12, 20};
        int n = a.length;
        for(int i = 0; i < n; i++){
            System.out.println("factors for " + a[i]);
            for(int j = 1; j * j <= a[i]; j++){
                if((a[i]%j) == 0){
                    if(a[i]/j == j){
                        System.out.print(j + " ");
                    }else{
                        System.out.print(j + " " + (int)(a[i]/j) + " ");
                    }
                }
            }
            System.out.println();
        }
    }
}
