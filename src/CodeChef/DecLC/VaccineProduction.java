package CodeChef.DecLC;

import java.util.Scanner;

public class VaccineProduction {
    public static void main(String[] arg){
        Scanner sc = new Scanner(System.in);
        int d1 = sc.nextInt();
        int v1 = sc.nextInt();
        int d2 = sc.nextInt();
        int v2 = sc.nextInt();
        int p = sc.nextInt();

        if(d2 < d1){
            int tempd = d1;
            int tempv = v1;
            d1 = d2;
            v1 = v2;
            d2 = tempd;
            v2 = tempv;

        }

        double temp = 0;

        if(p < (d2 - d1)*v1){
            temp = p/(v1*1.0);
        }else{
            temp = (p + (d2 - d1)*v2)/((v1 + v2)*1.0);
        }
        temp = temp + (d1 - 1);
        System.out.println((int)Math.ceil(temp));

    }
}
