package goog;

import java.util.ArrayList;
import java.util.HashMap;

public class BullsAndCows2 {
    public static void main(String[] args) {
        BullsAndCOws sol = new BullsAndCOws();
        //System.out.println(sol.getHint("1123", "0111"));
        //System.out.println(sol.getHint("1", "1"));
        //System.out.println(sol.getHint("011", "110"));
        //System.out.println(sol.getHint("11", "10"));
        System.out.println(sol.getHint("1122", "1222"));
    }
    public String getHint(String secret, String guess) {
        int a = 0;
        int b = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        String ans = "";
        int n1 = secret.length();
        int n2 = secret.length();
        for(int i = 0; i < n1; i++){
            char ch = secret.charAt(i);
            ArrayList<Integer> indices = new ArrayList<>();
            if(map.containsKey(ch)){
                map.put(ch, map.get(ch) + 1);
            }else{
                map.put(ch, 1);
            }
        }

        for(int i = 0; i < n2; i++){
            char ch = guess.charAt(i);
            if(secret.charAt(i) == guess.charAt(i) && !map.containsKey(ch)){
                b--;
                a++;
                continue;
            }
            if(map.containsKey(ch)){
                if (secret.charAt(i) == guess.charAt(i)) {
                    a++;
                } else {
                    b++;
                }
                map.put(ch, map.get(ch) - 1);
                if(map.get(ch) == 0){
                    map.remove(ch);
                }
            }
        }
        return String.valueOf(a) + "A" + String.valueOf(b) + "B";
    }
}
