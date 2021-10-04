package goog;

import java.util.Stack;

public class DecodeString {
    public static void main(String[] args) {
        DecodeString sol = new DecodeString();
        //System.out.println(sol.decodeString("3[a]2[bc]"));
        //System.out.println(sol.decodeString("2[abc]3[cd]ef"));
        System.out.println(sol.decodeString("3[a2[c]]"));
    }
    public String decodeString(String s) {
        boolean open = false;
        StringBuilder sbCount = new StringBuilder("");
        StringBuilder sbTemp = new StringBuilder("");
        StringBuilder sbMain = new StringBuilder("");
        int n = s.length();
        int count = 0;
        for(int i = 0; i < n; i++){
            char ch = s.charAt(i);

            if(ch == '['){
                open = true;
                count = Integer.valueOf(sbCount.toString());
                sbCount = new StringBuilder("");
                continue;
            }else if(ch == ']'){
                open = false;
                String tempStr = sbTemp.toString();
                sbTemp = new StringBuilder("");
                while(count != 0){
                    sbMain.append(tempStr);
                    count--;
                }
            }else if(!open){
                sbCount.append(ch);
                continue;
            }
            else{
                sbTemp.append(ch);
            }
        }
        return sbMain.toString();
    }
}
