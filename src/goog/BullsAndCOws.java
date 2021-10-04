package goog;

import java.util.ArrayList;
import java.util.HashMap;

public class BullsAndCOws {
    public static void main(String[] args) {
        BullsAndCOws sol = new BullsAndCOws();
        //System.out.println(sol.getHint("1123", "0111"));
        //System.out.println(sol.getHint("1", "1"));
        //System.out.println(sol.getHint("011", "110"));
        System.out.println(sol.getHint("11", "10"));
    }
    public String getHint(String secret, String guess) {
        int a = 0;
        int b = 0;
        HashMap<Character, ArrayList<Integer>> map = new HashMap<>();
        String ans = "";
        int n1 = secret.length();
        int n2 = secret.length();
        for(int i = 0; i < n1; i++){
            char ch = secret.charAt(i);
            ArrayList<Integer> indices = new ArrayList<>();
            if(map.containsKey(ch)){
                indices = map.get(ch);
                indices.add(i);
                map.put(ch, indices);
            }else{
                indices.add(i);
                map.put(ch, indices);
            }
        }
        int[] bulls = new int[n1];
        for(int i = 0; i < n2; i++){
            char ch = guess.charAt(i);
            if(map.containsKey(ch)){
                if(map.get(ch).contains(i)){
                    a++;
                    bulls[i] = 1;
                    map.get(ch).remove(0);
                }
                if(map.get(ch).size() == 0){
                    map.remove(ch);
                }
            }
        }
        for(int i = 0; i < n2; i++) {
            char ch = guess.charAt(i);
            if (map.containsKey(ch) && bulls[i] != 1) {
                b++;
                map.get(ch).remove(0);
                if (map.get(ch).size() == 0) {
                    map.remove(ch);
                }
            }
        }
        return String.valueOf(a) + "A" + String.valueOf(b) + "B";
    }
}
