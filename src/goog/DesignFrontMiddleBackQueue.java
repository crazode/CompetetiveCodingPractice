package goog;

import java.util.LinkedList;

public class DesignFrontMiddleBackQueue {
    LinkedList<Integer> list;
    public DesignFrontMiddleBackQueue() {
        this.list = new LinkedList<>();

    }

    public void pushFront(int val) {
        list.addFirst(val);

    }

    public void pushMiddle(int val) {
        int mid = (list.size() / 2);


        list.add(mid, val);
    }

    public void pushBack(int val) {
        list.addLast(val);
    }

    public int popFront() {
        if(list.isEmpty())return -1;
        int ans = list.getFirst();
        list.removeFirst();

        return ans;
    }

    public int popMiddle() {
        if(list.isEmpty())return -1;
       int mid = (list.size() - 1)/2;


        int ans = list.get(mid);
        list.remove(mid);
        //System.out.println(sb.toString());
        return ans;
    }

    public int popBack() {
        if(list.isEmpty())return -1;
        int ans = list.getLast();
        list.removeLast();
        return ans;
    }

    public static void main(String[] args) {
        DesignFrontMiddleBackQueue sol = new DesignFrontMiddleBackQueue();
        sol.pushFront(1);
        sol.pushBack(2);
        sol.pushMiddle(3);
        sol.pushMiddle(4);
//        System.out.println(sol.sb.toString());
        System.out.println(sol.popFront());
        System.out.println(sol.popMiddle());
        System.out.println(sol.popMiddle());
        System.out.println(sol.popBack());
        System.out.println(sol.popFront());
    }
}

