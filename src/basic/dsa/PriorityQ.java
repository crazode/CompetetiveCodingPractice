package basic.dsa;

import java.util.Comparator;
import java.util.PriorityQueue;

public class PriorityQ {
    public static void main(String[] args) {
        PriorityQueue<Pair> pq = new PriorityQueue<Pair>(new Comparator<Pair>() {
            @Override
            public int compare(Pair o1, Pair o2) {
                return o1.dist - o2.dist;
            }
        });

    }
    public static class Pair{
        int node;
        int dist;
        Pair(int node, int dist){
            this.node= node;
            this.dist = dist;
        }
    }
}
