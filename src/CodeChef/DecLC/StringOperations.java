package CodeChef.DecLC;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class StringOperations {
    public static void main(String[] arg) throws Exception{
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(input.readLine());
        while(t-- > 0){
            String s = input.readLine();
            int count = getCount(s);
            System.out.println(count);
        }
    }
    public static int getCount(String s){
        int n = s.length();

        HashMap<Integer, ArrayList<String>> map = new HashMap<>();
        HashMap<Integer, ArrayList<String>> map2 = new HashMap<>();
        for(int i = 0; i < n; i++){
            StringBuilder sb = new StringBuilder("");
            int c1 = 0;
            for(int j = i; j < n; j++ ){
                sb = sb.append(s.charAt(j));
                if(s.charAt(j) == '1'){
                    c1++;
                }
                if(map2.containsKey(c1)){
                    if(!map2.get(c1).contains(sb.toString())){
                        ArrayList<String> a = map2.get(c1);
                        a.add(sb.toString());
                        map2.put(c1, a);
                        ArrayList<String> b = map.get(c1);
                        b.add(sb.toString());
                        map.put(c1, b);
                        map2 = addAllString(sb.toString(),c1, map2);

                    }
                }else{
                    ArrayList<String> a = new ArrayList<>();
                    a.add(sb.toString());
                    ArrayList<String> b = new ArrayList<>();
                    b.add(sb.toString());
                    map2.put(c1, a);
                    map.put(c1, b);
                    map2 = addAllString(sb.toString(),c1, map2);
                }
            }
        }
        int ans = 0;
        for (Map.Entry mapElement : map.entrySet()) {
            Integer key = (Integer) mapElement.getKey();
            ans = ans + map.get(key).size();
        }
        return ans;
    }
    public static  HashMap<Integer, ArrayList<String>> addAllString(String s, int c1, HashMap<Integer, ArrayList<String>> map2){
        int n = s.length();
        for(int i = 0; i < n; i++){
            StringBuilder start = new StringBuilder("");
            start.append(s, 0, i);
            StringBuilder mid = new StringBuilder("");
            int c = 0;
            for(int j = i; j < n; j++){
                mid.append(s.charAt(j));
                if(s.charAt(j) == '1'){
                    c++;
                }
                if(c%2 == 0){
                    StringBuilder mid_rev = mid.reverse();
                    StringBuilder temp = new StringBuilder("");
                    temp.append(start);
                    temp.append(mid_rev);
                    temp.append(s, j+1, n);
                    if(!map2.get(c1).contains(temp.toString())){
                        ArrayList<String> a = map2.get(c1);
                        a.add(temp.toString());
                        map2.put(c1, a);
                    }
                    mid.reverse();
                }
            }
        }
        return map2;
    }
}
