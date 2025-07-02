class Solution {
    public int longestStrChain(String[] words) {
       Arrays.sort(words, (a, b) -> a.length() - b.length());
        int n = words.length;
        int[] dp = new int[n];
        int result = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (1 + dp[j] > dp[i] && checkPossible(words[i], words[j])) {
                    dp[i] = 1 + dp[j];
                }
            }
            if (dp[i] > result) {
                result = dp[i];
            }
        }
        return result + 1;
    }

    private static boolean checkPossible(String s, String s1) {
        if (s.length() != s1.length() + 1) {
            return false;
        }
        int first = 0;
        int second = 0;

        while (first < s.length()) {
            if (second < s1.length() && s.charAt(first) == s1.charAt(second)) {
                first++;
                second++;
            } else {
                first++;
            }
        }
        if (first == s.length() && second == s1.length()) {
            return true;
        } else
            return false;
    }
}