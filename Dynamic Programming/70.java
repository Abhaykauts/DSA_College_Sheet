class Solution {
    public int climbStairs(int n) {
        int[]dp= new int[n];
        Arrays.fill(dp,-1);
        return count(n,0,dp);
    }

    private int count(int n,int i,int[]dp){
        if(i==n) return 1;
        if(i>n) return 0;
        if(dp[i]!=-1) return dp[i];
        return dp[i]=count(n,i+1,dp)+count(n,i+2,dp);
    }
}