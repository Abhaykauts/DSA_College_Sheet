class Solution {
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, -1); // -1 means "not computed yet"
        int res = solve(coins, amount, 0, 0, dp);
        return res == Integer.MAX_VALUE ? -1 : res;
    }

    private int solve(int[] coins, int amount, int currSum, int currSteps, int[] dp) {
        if (currSum > amount) return Integer.MAX_VALUE;
        if (currSum == amount) return currSteps;

        if (dp[currSum] != -1 && dp[currSum] <= currSteps) {
            // We've already reached this sum using fewer or equal coins
            return Integer.MAX_VALUE;
        }

        dp[currSum] = currSteps;

        int minSteps = Integer.MAX_VALUE;
        for (int coin : coins) {
            int result = solve(coins, amount, currSum + coin, currSteps + 1, dp);
            if (result != Integer.MAX_VALUE) {
                minSteps = Math.min(minSteps, result);
            }
        }

        return minSteps;
    }
}
