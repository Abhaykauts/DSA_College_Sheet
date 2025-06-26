class Solution {
    public int fib(int n) {
        int[] dp = new int[31];
        Arrays.fill(dp,-1);
        dp[0]=0;
        dp[1]=1;
        return fibn(n,dp);
    }

    private int fibn(int n,int[]dp){
        if(dp[n]!=-1) return dp[n];
        return dp[n]=fibn(n-1,dp)+fibn(n-2,dp);
    }
}