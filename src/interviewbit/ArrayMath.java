package interviewbit;

import java.util.ArrayList;

public class ArrayMath {
    ArrayList<ArrayList<Integer>> a = new ArrayList<>();
    public static void main(String[] arg){
        ArrayMath sol = new ArrayMath();
        ArrayList<Integer> temp1 = new ArrayList<>();
        ArrayList<Integer> temp2 = new ArrayList<>();
        temp1.add(1);
        temp1.add(2);
        temp2.add(3);
        temp2.add(4);
        sol.a.add(temp1);
        sol.a.add(temp2);
        sol.rotate(sol.a);
        for(int i = 0; i < sol.a.size(); i++){
            for(int j = 0; j < sol.a.get(0).size(); j++){
                System.out.print(sol.a.get(i).get(j) + " ");
            }
            System.out.println();
        }
    }

    public void rotate(ArrayList<ArrayList<Integer>> a) {
        ArrayList<ArrayList<Integer>> temp = new ArrayList<ArrayList<Integer>>();
        int n = a.size();
        int m = a.get(0).size();
        for(int j = 0; j < m; j++){
            ArrayList<Integer> temp1 = new ArrayList<>();
            for(int i = n - 1; i >= 0; i--){
                temp1.add(a.get(i).get(j));
            }
            temp.add(temp1);

        }

        for(int i = 0; i < temp.size(); i++){

            a.set(i,temp.get(i));
        }

        return;
    }
}
