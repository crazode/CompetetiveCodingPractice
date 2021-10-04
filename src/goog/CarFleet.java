package goog;

import java.util.Arrays;
import java.util.Comparator;

public class CarFleet {
    public static void main(String[] args) {
        CarFleet sol = new CarFleet();
//        int target = 12;
//        int[] position = new int[]{10,8,0,5,3};
//        int[] speed = new int[]{2,4,1,1,3};
        int target = 10;
        int[] position = new int[]{6, 8};
        int[] speed = new int[]{3, 2};

//        int target = 10;
//        int[] position = new int[]{0,4,2};
//        int[] speed = new int[]{2,1,3};
        System.out.println(sol.carFleet(target, position, speed));
    }
    public int carFleet(int target, int[] position, int[] speed) {
        int n = position.length;
        Pair[] pair = new Pair[n];
        for(int i = 0; i < n; i++){
            pair[i] = new Pair(position[i] * 1.0, speed[i] * 1.0, (target * 1.0 - position[i])/ (1.0 * speed[i]));
        }
        Arrays.sort(pair, new Comparator<Pair>() {
            @Override
            public int compare(Pair o1, Pair o2) {
                if(o1.position - o2.position > 0)return 1;
                if(o1.position - o2.position < 0)return -1;
                return 0;
            }
        });

        int count = 1;
        double time = pair[n - 1].timeToReadDestination;
        for(int i = n - 2; i >= 0 ; i--){
           if( time < pair[i].timeToReadDestination){
               count++;
               time = pair[i].timeToReadDestination;
            }
        }
        return count;

    }
    static class Pair{
        double position;
        double speed;
        double timeToReadDestination;
        Pair(double position, double speed, double timeToReadDestination){
            this.position = position;
            this.speed = speed;
            this.timeToReadDestination = timeToReadDestination;
        }
    }
}
