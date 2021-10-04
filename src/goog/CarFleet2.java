package goog;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Stack;

public class CarFleet2 {
    public static void main(String[] args) {
        CarFleet2 sol = new CarFleet2();
       //int[][] cars = new int[][]{{1,2},{2,1},{4,3},{7,2}};
        int[][] cars = new int[][]{{3,4},{5,4},{6,3},{9,1}};
        double[] ans = sol.getCollisionTimes(cars);
        print(ans);
    }

    private static void print(double[] ans) {
        int n = ans.length;
        for(int i = 0; i < n; i++){
            System.out.print(ans[i] + " " );
        }
    }

    public double[] getCollisionTimes(int[][] cars) {
        int n = cars.length;
        Pair[] pair = new Pair[n];
        for(int i = 0; i  < n; i++){
            pair[i] = new Pair(cars[i][0], cars[i][1]);
        }
        Stack<Integer> st = new Stack<>();
        double[] ans = new double[n];

        for(int i = n - 1; i>= 0; i--){
            ans[i] = -1;
            while(!st.empty()){
                int j = st.peek();

                double tempTime = timeToCollide(i, j, pair);
                if(tempTime>0 && (ans[j] < 0 || tempTime<= ans[j])){
                    ans[i] = tempTime;
                    break;
                }
                st.pop();
            }
            st.push(i);
        }

        return ans;
    }

    private double timeToCollide(int i, Integer peek, Pair[] pair) {
        if(pair[i].speed <= pair[peek].speed)return -1;
        return (pair[peek].distance - pair[i].distance)/ (pair[i].speed - pair[peek].speed);
    }

    static class Pair{
        double distance;
        double speed;

        Pair(int distance, int speed){
            this.distance = distance * 1.0;
            this.speed = speed * 1.0;
        }
    }
}

