package goog;

import org.omg.CORBA.INTERNAL;

import java.util.*;

public class MaxPointOnALIne {

    public static void main(String[] arg){
        MaxPointOnALIne sol = new MaxPointOnALIne();
        //int[][] points = new int[][]{{1, 1}, {3, 2}, {5, 3}, {4, 1}, {2, 3}, {1, 4}};
//        int[][] points = new int[][]{{7,3},{19,19},{-16,3},{13,17},{-18,1},{-18,-17},{13,-3},
//                {3,7},{-11,12},{7,19},{19,-12},{20,-18},{-16,-15},{-10,-15},
//                {-16,-18},{-14,-1},{18,10},{-13,8},{7,-5},{-4,-9},{-11,2},
//                {-9,-9},{-5,-16},{10,14},{-3,4},{1,-20},{2,16},{0,14},{-14,5},
//                {15,-11},{3,11},{11,-10},{-1,-7},{16,7},{1,-11},{-8,-3},{1,-6},{19,7},{3,6},{-1,-2},
//                {7,-3},{-6,-8},{7,1},{-15,12},{-17,9},{19,-9},{1,0},{9,-10},{6,20},{-12,-4},
//                {-16,-17},{14,3},{0,-1},{-18,9},{-15,15},{-3,-15},{-5,20},{15,-14},
//                {9,-17},{10,-14},{-7,-11},{14,9},{1,-1},{15,12},{-5,-1},{-17,-5},{15,-2},{-12,11},{19,-18},
//                {8,7},{-5,-3},{-17,-1},{-18,13},{15,-3},{4,18},{-14,-15},{15,8},{-18,-12},{-15,19},
//                {-9,16},{-9,14},{-12,-14},{-2,-20},{-3,-13},{10,-7},{-2,-10},{9,10},
//                {-1,7},{-17,-6},{-15,20},{5,-17},{6,-6},{-11,-8}
//        };

        //int[][] points = new int[][]{{1, 1}};
        int[][] points = new int[][]{{0,0},{2,2},{-1,-1}};
        System.out.println(sol.maxPoints(points));

    }
    public int maxPoints(int[][] points) {
        int ans = 1;

        int n = points.length;
        for(int i = 0; i < n; i++){
            Map<MCPair, Set<Integer>> map = new HashMap<>();
            for(int j = i + 1; j < n; j++){
                MCPair mcPair = new MCPair(0, 0, 0);
                if(points[i][0] == points[j][0]){
                    //x1 == x2
                    mcPair = new MCPair(0, 1, -1 * points[i][1]);
                }else if(points[i][1] == points[j][1]){
                    mcPair = new MCPair(1, 0, -1 * points[i][0]);
                }else{
                    mcPair = new MCPair(getSlope(points[i], points[j]), -1, getConst(points[i], points[j]));
                }
                Set<Integer> set = new HashSet<>();
                if(map.containsKey(mcPair)){
                    set = map.get(mcPair);
                    set.add(i);
                    set.add(j);
                    map.put(mcPair, set);
                }else{
                    set.add(i);
                    set.add(j);
                    map.put(mcPair, set);
                }
                ans = Math.max(ans, map.get(mcPair).size());
            }
        }

        return ans;
    }

    public float getConst(int[] point1, int[] point2) {
        float num = point2[0] * point1[1] - point1[0] * point2[1];
        float deno = point2[0] - point1[0];
        return num/deno;
    }

    public float getSlope(int[] point1, int[] point2) {
        float num = point2[1] - point1[1];
        float deno = point2[0] - point1[0];
        return num/deno;
    }

    static class MCPair{
        float a;
        float b;
        float c;
        MCPair(float a, float b, float c){
            this.a = a;
            this.b = b;
            if(c == -0.0){
                this.c = (float) 0.0;
            }else
             this.c = c;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            MCPair mcPair = (MCPair) o;
            return Float.compare(mcPair.a, a) == 0 &&
                    Float.compare(mcPair.b, b) == 0 &&
                    Float.compare(mcPair.c, c) == 0;
        }

        @Override
        public int hashCode() {
            int result = 17;
            result = 31 * result + (int)a;
            result = 31 * result + (int)b;
            result = 31 * result + (int)c;
//            return Objects.hash(a, b, c);
            return result;
        }
    }

}

