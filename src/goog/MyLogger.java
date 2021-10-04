package goog;

public class MyLogger {
    int curTime;
    Trie root;
    /** Initialize your data structure here. */
    public MyLogger() {
        this.curTime = 0;
        this.root = new Trie();
    }

    /** Returns true if the message should be printed in the given timestamp, otherwise returns false.
     If this method returns false, the message will not be printed.
     The timestamp is in seconds granularity. */
    public boolean shouldPrintMessage(int timestamp, String message) {
            int n = message.length();
            return add(message, root, timestamp);

    }
    public boolean add(String msg, Trie root, int timestamp){
        Trie itr = root;
        int n = msg.length();
        for(int i = 0; i < n; i++){

            int index = (int)msg.charAt(i) - (int)'a';
          if(itr.children[index] == null){
              itr.children[index] = new Trie();
          }itr = itr.children[index];
        }
        if(itr.isEndOfTheWord){
            if(itr.recentOccuranceAt + 10 <= timestamp){
                itr.recentOccuranceAt = timestamp;
                return true;
            }else{
                return false;
            }
        }else{
            itr.isEndOfTheWord = true;
            itr.recentOccuranceAt = timestamp;
            return true;
        }

    }
    static class Trie{
        Trie[] children;
        boolean isEndOfTheWord;
        long recentOccuranceAt;
        Trie(){
            this.children = new Trie[26];
            this.isEndOfTheWord = false;
            this.recentOccuranceAt = -1;
        }
    }

    public static void main(String[] args) {
        MyLogger sol = new MyLogger();
        //System.out.println((int)'b' - (int)'a');
        System.out.println(sol.shouldPrintMessage(1, "foo"));
        System.out.println(sol.shouldPrintMessage(2, "bar"));
        System.out.println(sol.shouldPrintMessage(3, "foo"));
        System.out.println(sol.shouldPrintMessage(13, "foo"));
    }
}
