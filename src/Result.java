import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Result {
    public static void main(String[] args) {
        List<List<Integer>> allLocations = new ArrayList<>();
        ArrayList<Integer> p1 = new ArrayList<>();
        p1.add(1);
        p1.add(2);
        ArrayList<Integer> p2 = new ArrayList<>();
        p2.add(3);
        p2.add(4);
        ArrayList<Integer> p3 = new ArrayList<>();
        p3.add(1);
        p3.add(-1);
        allLocations.add(p1);
        allLocations.add(p2);
        allLocations.add(p3);
        Result sol = new Result();
        System.out.println("hi");
        List<List<Integer>> ans = sol.findRestaurants(allLocations, 2);

        for(int i = 0; i < ans.size(); i++){
            System.out.println("hi");
            System.out.println(ans.get(i).get(1));
        }

    }
    public static List<List<Integer>> findRestaurants(List<List<Integer>> allLocations, int numRestaurants){
        Collections.sort(allLocations, new Comparator<List<Integer>>() {
            @Override
            public int compare(List<Integer> o1, List<Integer> o2) {
                int a1 = o1.get(0);
                int b1 = o1.get(1);
                int a2 = o2.get(0);
                int b2 = o2.get(1);
                return a1 * a1 + b1 * b1 - a2 * a2 - b2 * b2 ;
            }
        });
        List<List<Integer>> ans = new ArrayList<>();
        for(int i = 0; i < Math.min(allLocations.size(), numRestaurants); i++){
            ans.add(allLocations.get(i));
        }
        return ans;
    }
}
