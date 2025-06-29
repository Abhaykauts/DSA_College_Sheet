class Solution {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int i : nums) {
            sum += i;
        }
        if (sum % 2 != 0)
            return false;

        int target = sum / 2;
        Boolean[][] dp = new Boolean[nums.length][target+1];
        return solve(nums, 0, 0, dp, target);
    }

    private boolean solve(int[] nums, int index, int sum, Boolean[][] dp, int target) {
        if (index == nums.length || sum > target)
            return false;
        if (sum == target)
            return true;

        if (dp[index][sum]!=null)
            return dp[index][sum];

        boolean isPossible = solve(nums, index + 1, sum + nums[index], dp, target)
                || solve(nums, index + 1, sum, dp, target);
        return dp[index][sum] = isPossible;
    }
}