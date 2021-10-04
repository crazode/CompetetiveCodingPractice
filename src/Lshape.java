public class Lshape {
    public static void main(String[] arg){
//        boolean[][] boolRect = new boolean[4][6];
//        for(int i = 0; i < 4; i++){
//            for(int j = 0; j < 6; j++){
//                boolRect[i][j] = true;
//            }
//        }

//        boolean[][] boolRect = new boolean[][]{{false, true, false, true, true, true, true, true},
//            {false, true, true, true, true, true, true, true},
//            {false, true, true, true, true, true, true, false},
//            {true, true, true, true, true, false, false, true},
//            {true, true, true, true, true, false, false, true},
//            {true, true, false, true, false, true, false, true}};

        boolean[][] boolRect = new boolean[][]{
                {true, true, false, false, false, false, false, false, false, false, false, true, true, true, false, false, false, false, false, true, true},
                {true, false, false, false, false, false, false, false, false, false, false, false, true, true, false, false, false, false, false, true, true},
                {false, false, false, false, false, false, false, false, false, false, false, false, false, true, false, false, false, false, false, true, true},
                {false, false, false, false, true, true, true, true, false, false, false, false, false, true, true, true, false, false, false, true, true},
                {false, false, false, true, true, true, true, false, false, false, false, false, false, true, true, true, false, false, false, true, true},
                {false, false, false, true, true, true, false, false, false, false, false, false, false, true, true, true, false, false, false, true, true},
                {false, false, false, true, true, false, false, false, false, false, false, false, false, true, true, true, false, false, false, true, true},
                {false, false, false, true, false, false, false, false, false, false, false, false, false, true, true, true, false, false, false, true, true},
                {false, false, false, false, false, false, false, false, false, false, false, false, false, true, true, true, false, false, false, true, true},
                {false, false, false, false, false, false, false, false, false, true, false, false, false, true, true, true, false, false, false, true, true},
                {false, false, false, false, false, false, false, false, true, true, false, false, false, true, true, true, false, false, false, true, true},
                {false, false, false, false, false, false, false, true, true, true, false, false, false, true, true, true, false, false, false, true, true},
                {false, false, false, false, false, false, true, true, true, true, false, false, false, true, true, true, false, false, false, true, true},
                {false, false, false, false, false, true, true, true, true, false, false, false, false, true, true, true, false, false, false, true, true},
                {false, false, false, false, false, false, false, false, false, false, false, false, false, true, false, false, false, false, false, false, false},
                {true, false, false, false, false, false, false, false, false, false, false, false, true, true, false, false, false, false, false, false, false},
                {true, true, false, false, false, false, false, false, false, false, false, true, true, true, false, false, false, false, false, false, false},

        };
        int n = boolRect.length;
        int m = boolRect[0].length;
//        for(int i = 0; i < n; i++){
//            for(int j = 0; j < m; j++){
//                boolRect[i][j] = true;
//            }
//        }


        int[][] sq = new int[n][m];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(boolRect[i][j] == true){
                    sq[i][j] = 1;
                }
            }
        }

        if(n >= 2 && m >= 2){
            sq = getSquareTileSize(sq);
        }
//        for(int i = 0; i < n; i++){
//            for(int j = 0; j < m; j++){
//                    System.out.print(sq[i][j] + " ");
//                }
//            System.out.println();
//            }
        int ans = 0;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(sq[i][j] > 0){
                    ans = Math.max(ans, getMaxSizeL(sq, i , j));
                }

            }
        }
        System.out.println(ans);

    }
    public static int getMaxSizeL(int[][] sq, int i, int j){
        int n = sq.length;
        int m = sq[0].length;
        int start = 1;
        int end = Math.min(m , n)/2;
        int ans = 0;
        if(end == 1){
            if(kSizedLExists(i, j, 1, sq)){
                ans = 1;
            }
        }

        while(start  <= end){
            int mid = (start + end)/2;
            if(kSizedLExists(i, j, mid, sq)){
                ans = mid;
                if(start == end){
                    break;
                }
                start = mid + 1;
            }else{
                if(start == end){
                    break;
                }
                end = mid - 1;
            }
        }
        return ans;
    }
    public static boolean kSizedLExists(int i, int j, int k, int[][] sq){
        int n = sq.length;
        int m = sq[0].length;
        if(squaresExist(i, j , k, n, m)){
            if(sq[i][j] >= k && sq[i - k][j] >= k && sq[i][j + k] >= k){
                return true;
            }
        }
        return false;
    }
    public static boolean squaresExist(int i, int j, int k, int n, int m){

        if(((i >= 0 && i < n) && (j >= 0 && j < m)) &&
                ((i - k >= 0 && i - k < n)  &&
                (j +  k  >= 0 && j + k  < m))){
            return true;
        }
        return false;
    }
    public static int[][] getSquareTileSize(int[][] sq){
        int n = sq.length;
        int m = sq[0].length;
        for(int i = 1; i < n; i++){
            for(int j = m - 2; j >=0; j--){
                if(sq[i - 1][j] !=0 && sq[i - 1][j + 1] != 0 && sq[i][j  + 1] != 0 && sq[i][j] != 0){
                    sq[i][j] = 1 + Math.min(Math.min(sq[i - 1][j], sq[i - 1][j + 1]),sq[i][j  + 1]);
                }
            }
        }
        return sq;
    }

}
