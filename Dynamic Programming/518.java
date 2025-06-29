class Solution {
    public int change(int amount, int[] coins) {
        int[][]dp=new int[coins.length][amount+1];
        for(int[]arr:dp){
            Arrays.fill(arr,-1);
        }
        return solve(amount,coins,0,0,dp);
    }

    private int solve(int amount,int[]coins,int sum,int index,int[][]dp){
        if(index==coins.length|| sum>amount){
            return 0;
        }

        if(sum==amount) return 1;

        if(dp[index][sum]!=-1) return dp[index][sum];
        int count=0;
        
        count+=solve(amount,coins,sum+coins[index],index,dp);
        count+=solve(amount,coins,sum,index+1,dp);
        return dp[index][sum]=count;
    }
}