package leetcode;

import java.util.HashMap;
import java.util.List;

public class BriclWalls {
    public int leastBricks(List<List<Integer>> wall) {

        HashMap<Integer, Integer> map = new HashMap<>();

        int n = wall.size();
        for(List<Integer> row : wall){
            int curSum = 0;
            for(int i = 0; i < row.size() - 1; i++){
                int key = row.get(i) + curSum;
                if(map.containsKey(key)){
                    map.put(key, map.get(key) + 1);
                }else{
                    map.put(key, 1);
                }
                curSum = key;
            }
        }
        int ans = 0;
        for(Integer val : map.values()){
            ans = Math.max(ans, val);
        }
        return n - ans;
    }
}
