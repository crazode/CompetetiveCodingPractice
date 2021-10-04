package goog;

import java.util.HashMap;

public class MyLogger2 {
    HashMap<String, Integer> map;
    /** Initialize your data structure here. */
    public MyLogger2() {
       this.map = new HashMap<>();
    }

    /** Returns true if the message should be printed in the given timestamp, otherwise returns false.
     If this method returns false, the message will not be printed.
     The timestamp is in seconds granularity. */
    public boolean shouldPrintMessage(int timestamp, String message) {
           if(map.containsKey(message)){
               if(map.get(message) + 10 <= timestamp){
                   map.put(message, timestamp);
                   return true;
               }else{
                   return false;
               }
           }else{
               map.put(message, timestamp);
               return true;
           }

    }


    public static void main(String[] args) {
        MyLogger2 sol = new MyLogger2();
        //System.out.println((int)'b' - (int)'a');
        System.out.println(sol.shouldPrintMessage(1, "foo"));
        System.out.println(sol.shouldPrintMessage(2, "bar"));
        System.out.println(sol.shouldPrintMessage(3, "foo"));
        System.out.println(sol.shouldPrintMessage(13, "foo"));
        System.out.println(sol.shouldPrintMessage(100, "string with more than one word"));
    }
}
