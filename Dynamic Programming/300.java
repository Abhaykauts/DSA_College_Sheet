class Solution {
    public int lengthOfLIS(int[] nums) {
        // int[][] dp = new int[nums.length+1][nums.length + 1];
        return solve(nums);
    }

    // private int solve(int[] nums, int index, int prev, Integer[][] dp) {
    //     if (index == nums.length)
    //         return 0;
    //     if (dp[index][prev + 1] != null)
    //         return dp[index][prev + 1];

    //     int take = 0;
    //     if (prev == -1 || nums[index] > nums[prev]) {
    //         take = 1 + solve(nums, index + 1, index, dp);
    //     }

    //     int nottake = 0 + solve(nums, index + 1, prev, dp);

    //     return dp[index][prev + 1] = Math.max(take, nottake);
    // }

    // private int solve(int[] nums, int[][] dp) {
    //     for (int index = nums.length - 1; index >= 0; index--) {
    //         for (int prev = index - 1; prev >= -1; prev--) {
    //             int take = 0;
    //             if (prev == -1 || nums[index] > nums[prev]) {
    //                 take = 1 + dp[index+1][index+1];
    //             }

    //            dp[index][prev + 1] = Math.max(take, 0 + dp[index+1][prev+1]);

                 
    //         }
    //     }
    //     return dp[0][0];
    // }

    private int solve(int[]nums){
        int n=nums.length;
        int[]dp = new int[n];
        Arrays.fill(dp,1);
        int result=1;
        for(int index=0;index<n;index++){
            for(int prev=0;prev<=index;prev++){
                if(nums[index]>nums[prev]){
                    dp[index]=Math.max(dp[index],1+dp[prev]);
                }
            }
            result=Math.max(result,dp[index]);
        }
        return result;
    }
}