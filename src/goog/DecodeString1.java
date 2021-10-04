package goog;

import java.util.Stack;

public class DecodeString1 {
    public static void main(String[] args) {
        DecodeString1 sol = new DecodeString1();
       // System.out.println(sol.decodeString("3[a]2[bc]"));
        System.out.println(sol.decodeString("100[leetcode]"));
        //System.out.println(sol.decodeString("2[abc]3[cd]ef"));
        //System.out.println(sol.decodeString("3[a2[c]]"));
        //System.out.println(sol.decodeString("abc3[cd]xyz"));
    }
    public String decodeString(String s) {
        Stack<Character> st = new Stack<>();
        int i = 0;
        int n = s.length();
        StringBuilder sb = new StringBuilder();
        StringBuilder sbTemp = new StringBuilder();
        while(i < n){
            char ch = s.charAt(i);
            if(ch == ']'){
                // compute temp string
                while(st.peek() != '['){
                    sbTemp.insert(0, st.pop());
                }
                st.pop();
                int count = getCount(st);
                String temp = sbTemp.toString();
                while(count - 1 > 0){
                    sbTemp.append(temp);
                    count--;
                }
                if(st.isEmpty()){
                    //add to main String
                    sb.append(sbTemp.toString());

                }else{
                    String stTemp = sbTemp.toString();
                    for(int j = 0; j < stTemp.length(); j++){
                        st.push(stTemp.charAt(j));
                    }
                }
                sbTemp = new StringBuilder("");
            }else{
                st.push(ch);
            }
            i++;
        }
        sbTemp = new StringBuilder("");
        if(!st.isEmpty()){
            while (!st.isEmpty()){
                sbTemp.insert(0, st.pop());
            }
            sb.append(sbTemp.toString());
            // compute the last string
        }
        return sb.toString();
    }

    private int getCount(Stack<Character> st) {
        if(!isInteger(st.peek())){
            return 1;
        }else{
            int ans = 0;
            String str = "";
            while(!st.isEmpty() && isInteger(st.peek())){
                str = st.pop() + str;
               // ans = ans * 10 + st.pop() - '0';
            }
            return Integer.valueOf(str);
        }
    }

    private boolean isInteger(Character peek) {
        int temp = peek - '0';
        if(temp >= 0 && temp <= 9)return true;
        return false;
    }
}
