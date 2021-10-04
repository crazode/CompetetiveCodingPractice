package goog;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class RemoveDuplicateChar {
    public static void main(String[] args) {
       //String s = "bcabc";
        //String s = "bcacb";
        String s = "cbacdcbc";
        RemoveDuplicateChar sol = new RemoveDuplicateChar();
        System.out.println(sol.removeDuplicateLetters(s));
    }
    public String removeDuplicateLetters(String s) {
        int n = s.length();
        HashMap<Integer, ArrayList> map = new HashMap<>();
        for(int i = 0; i < n; i++){
            int ascii = s.charAt(i) - 'a';
            if(map.containsKey(ascii)){
                ArrayList<Integer> a = map.get(ascii);
                a.add(i);
            }else{
                ArrayList<Integer> a = new ArrayList<Integer>();
                a.add(i);
                map.put(ascii, a);
            }
        }
        char[] ch = new char[n];
        Integer maxIndex = Integer.MIN_VALUE;
        for(int i = 25; i >= 0; i--){
            if(map.containsKey(i)){
                int index = getIndex(map.get(i), maxIndex);
                maxIndex = Math.max(maxIndex, index);
                if(index != -1)
                ch[index] = (char)((int)'a' + i);
                //System.out.println(index + " index");
                //System.out.println(ch[index]);
            }
        }
        String ans = "";
        for(int i = 0; i < n; i++){
            if(ch[i] != '\0'){
                ans = ans + ch[i];
            }
        }
        return ans;
    }
    public int getIndex(ArrayList<Integer> a, int i){
        int n = a.size();
        if(n == 1)return a.get(0);
        if(i == Integer.MIN_VALUE)return a.get(n - 1);
        int start = 0;
        int end = n - 1;
        int index = -1;
        while(end >= start){
            int mid = start + (end - start)/2;
            if(a.get(mid) < i){
                start = mid + 1;
            }else if(a.get(mid) >= i){
                index = a.get(mid);
                end = mid - 1;
            }
        }

        return index;
    }
}