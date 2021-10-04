package interviewbit;

import java.util.ArrayList;

public class MergeIntervals {
    ArrayList<Interval> intervals = new ArrayList<>();
    public static void main(String[] arg){
        MergeIntervals sol = new MergeIntervals();
//        sol.intervals.add(new Interval(31935139, 38366404));
//        sol.intervals.add(new Interval(54099301, 76986474));
//        sol.intervals.add(new Interval(87248431, 94675146));

        sol.intervals.add(new Interval(1, 2));
        sol.intervals.add(new Interval(3, 5));
        sol.intervals.add(new Interval(6, 7));
        sol.intervals.add(new Interval(8, 10));
        sol.intervals.add(new Interval(12, 16));
        ArrayList<Interval> temp = sol.insert(sol.intervals, new Interval(4, 9));
        for(int i = 0; i < temp.size(); i++){
            System.out.println(temp.get(i));
        }
    }

    public ArrayList<Interval> insert(ArrayList<Interval> intervals, Interval newInterval) {
        ArrayList<Interval> ans = new ArrayList<>();
        newInterval = new Interval(Math.min(newInterval.start, newInterval.end), Math.max(newInterval.start, newInterval.end));
        int n = intervals.size();

        boolean inserted = false;
        int index = -1;
        for(int i = 0; i < n; i++){
            if(!inserted && newInterval.start <= intervals.get(i).start){
                ans.add(newInterval);
                ans.add(intervals.get(i));
                inserted = true;

                index = Math.max(i - 1, 0);
            }else{
                ans.add(intervals.get(i));
            }
        }
        if(!inserted){
            ans.add(newInterval);
            index = ans.size() - 2;
        }
        while(index < ans.size() - 1 && index >= 0){
            if(ans.get(index + 1).start >= ans.get(index).start && ans.get(index + 1).start <= ans.get(index).end){
                ans.set(index, new Interval(Math.min(ans.get(index + 1).start, ans.get(index).start), Math.max(ans.get(index + 1).end, ans.get(index).end)));
                ans.remove(index + 1);
            }else index++;
        }

        return ans;
    }



    public static class Interval {
    int start;
     int end;
    Interval() { start = 0; end = 0; }
     Interval(int s, int e) { start = s; end = e; }

        @Override
        public String toString() {
            return "Interval{" +
                    "start=" + start +
                    ", end=" + end +
                    '}';
        }
    }
}
