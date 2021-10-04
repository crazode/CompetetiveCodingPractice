package goog;

public class MinSidewaysJump2 {
    public static void main(String[] args) {
        //int[] obstacles = new int[]{0,1,2,3,0};
        //int[] obstacles = new int[]{0,2,1,0,3,0};
        //int[] obstacles = new int[]{0,1,1,3,3,0};
        int[] obstacles = new int[]{0,2,2,1,0,3,0,3,0,1,3,1,1,0,1,3,1,1,1,0,2,0,0,3,3,0,3,2,2,0,0,3,3,3,0,0,2,0,0,3,3,0,
                3,3,0,0,3,1,0,1,0,2,3,1,1,0,3,3,0,3,1,3,0,2,2,0,1,3,0,1,0,3,0,1,3,1,2,2,0,0,3,0,1,3,2,3,2,1,0,3,2,2,0,3,
                3,0,3,0,0,1,0,2,0,0,0,2,1,2,0,2,2,3,3,3,0,0,1,1,3,0,0,0,1,2,2,1,2,1,3,2,2,3,1,3,0,1,1,1,3,0,0,0,2,0,2,0,
                3,1,2,3,3,2,2,2,0,0,0,1,0,0,0,0,3,0,0,0,3,0,2,1,2,3,1,0,3,3,2,0,1,1,0,1,0,2,2,2,1,3,0,3,0,2,1,1,3,1,0,1,
                2,2,0,2,2,0,0,3,3,1,3,0,1,1,0,3,0,2,1,2,2,0,0,0,1,2,3,1,2,1,1,2,2,1,1,0,2,3,3,3,0,2,3,2,0,0,0,1,0,2,2,0,
                0,2,0,2,0,1,1,0,3,1,3,3,0,1,0,3,0,3,1,2,3,1,0,0,2,3,2,0,0,3,1,2,3,2,2,3,1,3,3,2,0,1,3,0,3,2,2,3,2,1,2,2,
                0,3,2,0,2,1,2,2,3,1,3,2,2,0,0,1,0,3,1,3,3,0,0,2,2,2,2,0,1,0,3,1,3,3,3,0,2,3,2,0,3,3,3,3,3,3,2,2,1,1,0,3,
                1,3,2,3,0,0,0,2,1,1,3,1,3,2,1,3,0,1,1,3,2,2,1,0,0,3,2,1,3,2,3,3,2,1,2,0,2,2,0,2,2,3,2,0,2,3,3,1,1,2,0,1,
                1,1,2,3,2,1,2,1,0,2,3,1,1,3,3,2,0,1,3,2,3,3,0,1,2,3,2,1,1,2,1,0,0,1,0,3,1,1,1,0,2,0,2,2,3,0,1,0,2,0,0,3,
                1,1,2,0,0,2,1,1,0,2,2,2,3,1,2,0,1,2,0,1,2,1,2,3,1,1,1,1,0,3,3,2,1,0,0,1,0,3,0,0,2,2,2,1,1,2,1,2,1,1,2,0,
                3,1,3,2,1,2,2,3,1,0,1,1,1,0,0,0,1,3,3,2,2,1,2,0,0,0,3,1,3,2,3,1,3,2,3,1,3,2,0,1,2,1,1,2,1,3,0,1,1,1,3,3,
                1,0,0,3,2,2,3,1,1,0,3,0,0,3,0,3,1,2,0,2,3,2,3,0,3,2,3,0,2,2,3,0,3,3,3,1,0,1,2,2,0,3,3,1,3,2,2,3,2,1,1,0,
                0,0,0,2,1,0,1,1,1,1,0,3,0,1,0,0,1,0,2,0,0,1,2,0,0,0,3,3,1,0,3,2,1,2,3,2,0,3,3,0,2,3,1,1,0,2,2,3,3,0,1,0,
                0,3,1,2,3,0,1,2,3,2,2,0,1,2,0,3,0,3,0,1,1,3,2,2,2,3,1,2,0,0,3,0,2,3,3,1,0,3,3,0,0,0,3,2,1,1,3,1,1,1,1,1,
                1,3,3,3,0,0,1,1,1,1,2,2,0,1,0,2,2,0,2,1,3,1,1,1,2,1,1,0,3,1,0,2,3,0,1,2,0,0,3,1,2,3,0,0,3,1,0,2,2,0,1,1,
                2,2,1,3,1,2,1,0,1,2,3,2,3,0,3,1,3,0,2,0,3,1,1,0,3,2,0,3,0,2,0,0,3,3,1,1,1,0,0,1,1,1,2,3,1,3,1,2,0,0,3,3,
                0,3,3,0,0,0,3,3,0,3,3,2,3,3,3,3,1,1,1,3,1,1,3,3,1,0,0,3,1,2,0,2,0,3,0,2,1,0,1,0,2,3,3,3,2,3,3,2,0,0,0,2,
                2,3,0,0,3,0,2,3,0,1,3,2,1,2,0,1,3,2,2,0,1,1,3,3,0,2,3,0,3,3,1,2,3,2,1,0,2,3,2,2,2,3,0,1,1,3,1,0,2,1,3,2,
                2,2,3,3,1,1,1,3,2,3,1,0,2,3,0,2,3,0,1,3,3,1,1,1,1,0,1,1,2,2,0,2,1,1,0,1,0,3,1,1,1,3,3,2,1,2,3,2,2,3,1,0,
                3,2,0,1,0,1,3,3,3,0,3,3,2,3,1,2,2,1,1,0,0,3,0};
        MinSidewaysJump2 sol = new MinSidewaysJump2();
        System.out.println(sol.minSideJumps(obstacles));
    }
    public int minSideJumps(int[] obstacles) {
        int n = obstacles.length;
        int ans  = getMinJumps(0, n, obstacles, 2);
        return ans;
    }

    private int getMinJumps(int point, int n, int[] obstacles, int curLane) {
        while(point < n - 1 && obstacles[point + 1] != curLane && obstacles[point] != curLane ){
            point++;
        }
        if(point == n - 1)return 0;
        else{
            int[] newLaneAndPoint = getNewPointAndLane(obstacles, point, curLane, n);
            return 1 + getMinJumps(newLaneAndPoint[0], n, obstacles, newLaneAndPoint[1]);
        }
    }

    private int[] getNewPointAndLane(int[] obstacles, int point, int curLane, int n) {
        int ansPoint = -1;
        int ansLane = -1;
        for(int i = 1; i <= 3; i++){
            if(i != curLane){
                if(obstacles[point] != i && obstacles[point + 1] != i){

                    int tempPoint = point;
                    while(tempPoint < n - 1 && obstacles[tempPoint + 1] != i){
                        tempPoint++;
                    }
                    if(tempPoint > ansPoint){
                        ansPoint = tempPoint;
                        ansLane = i;
                    }
                }
            }
        }
        return new int[]{ansPoint, ansLane};
    }

}
