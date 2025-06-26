class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        int n = s.length();
        int[] dp = new int[n]; // -1 = unvisited, 1 = true, 0 = false
        Arrays.fill(dp, -1);
        
        return solve(0, s, new HashSet<>(wordDict), dp);
    }

    private boolean solve(int i, String s, Set<String> dict, int[] dp) {
        if (i == s.length()) return true;

        if (dp[i] != -1) return dp[i] == 1;

        for (String word : dict) {
            int currSize = word.length();

            if (i + currSize > s.length()) continue;

            // substring(i, i + len) gives s.substr(i, len) behavior
            if (s.substring(i, i + currSize).equals(word) && solve(i + currSize, s, dict, dp)) {
                dp[i] = 1;
                return true;
            }
        }

        dp[i] = 0;
        return false;
    }
}
