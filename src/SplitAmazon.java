import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class SplitAmazon {

    public int minimumSplits(int N, int[] X, int[] Type){
        int result = 0;
       PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {
           @Override
           public int compare(Integer o1, Integer o2) {
               return o2 - o1;
           }
       });
        long heroCount = 1;
       for(int i = 0; i < N; i++){
           if(Type[i] == 2){
               while(!pq.isEmpty() && heroCount <= X[i] ){
                   result++;
                   heroCount += pq.poll() - 1;
               }
               if(pq.isEmpty() && heroCount <= X[i])return -1;
           }else{
               pq.add(X[i]);
           }
       }
        return result;
    }


}
