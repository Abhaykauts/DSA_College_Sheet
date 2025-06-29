class Solution {
    public int rob(int[] nums) {
        int[] dp = new int[nums.length];
        Arrays.fill(dp,-1);
        return solve(nums,dp,0);
    }

    private int solve(int[]nums,int[] dp,int index){
        if(index>=nums.length){
            return 0;
        }
        if(dp[index]!=-1) return dp[index];

        int Take=nums[index]+solve(nums,dp,index+2);
        int notTake=solve(nums,dp,index+1);

        return dp[index]=Math.max(Take,notTake);
    }
}