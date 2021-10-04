package walmart;

public class CoinChange {
    public static void main(String[] args) {
        CoinChange sol = new CoinChange();
//        int[] coins = new int[]{1, 2, 5};
//        int amount = 11;

        int[] coins = new int[]{2};
        int amount = 3;
        System.out.println(sol.coinChange(coins, amount));
    }
    public int coinChange(int[] coins, int amount) {
        int[] minCoins = new int[amount + 1];

        for(int i = 1; i <= amount; i++){
            minCoins[i] = Integer.MAX_VALUE;
            for(int j = 0; j < coins.length; j++){
                if(coins[j] <= i && minCoins[i - coins[j]] != Integer.MAX_VALUE){
                    minCoins[i] = Math.min(minCoins[i - coins[j]] + 1, minCoins[i]);
                }
            }
        }
        if(minCoins[amount] == Integer.MAX_VALUE)return -1;
        return minCoins[amount];
    }

}
