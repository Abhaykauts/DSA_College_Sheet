class Solution {
    int n;

    public int findNumberOfLIS(int[] nums) {
        n = nums.length;
        int[] dp = new int[n + 1];
        int[] count = new int[n + 1];
        Arrays.fill(count, 1);
        Arrays.fill(dp, 1);
        return solve(nums, dp, count);
    }

    private int solve(int[] nums, int[] dp, int[] count) {
        int max = 1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    if (dp[i] < dp[j] + 1) {
                        dp[i] = dp[j] + 1;
                        count[i] = count[j];
                    } else if (dp[i] == dp[j] + 1) {
                        count[i] += count[j];
                    }
                }
            }
            max = Math.max(max, dp[i]);
        }

        int result = 0;

        for (int i = 0; i < n; i++) {
            if (dp[i] == max)
                result += count[i];
        }

        return result;
    }
}