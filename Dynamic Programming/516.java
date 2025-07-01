class Solution {
    public int longestPalindromeSubseq(String s) {
         int[][]dp = new int[s.length()+1][s.length()+1];
        for(int[]i:dp){
            Arrays.fill(i,-1);
        }
        String reversed = new StringBuilder(s).reverse().toString();
        return solve(s,reversed,0,0,dp);
    }
    private int solve(String s, String t, int sI,int tI,int[][]dp) {
        if (sI==s.length() || tI==t.length())
            return 0;

        if(dp[sI][tI]!=-1) return dp[sI][tI];

        if(s.charAt(sI)==t.charAt(tI)){
            dp[sI][tI]=1+solve(s,t,sI+1,tI+1,dp);
        }
        else{
            int skip_t = solve(s,t,sI,tI+1,dp);
            int skip_s = solve(s,t,sI+1,tI,dp);
            dp[sI][tI]=Math.max(skip_t,skip_s);

        }
        return dp[sI][tI];
    }
}