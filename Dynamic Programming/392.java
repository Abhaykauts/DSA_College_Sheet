class Solution {
    public boolean isSubsequence(String s, String t) {
        Boolean[][] dp = new Boolean[s.length()+1][t.length()+1];
        return solve(s, t, 0,0,dp);
    }

    private boolean solve(String s, String t, int sI,int tI,Boolean[][]dp) {
        if (sI==s.length())
            return true;
        if (tI == t.length()) {
            return false;
        }

        if(dp[sI][tI]!=null) return dp[sI][tI];

        if(s.charAt(sI)==t.charAt(tI)){
            dp[sI][tI]=solve(s,t,sI+1,tI+1,dp);
        }
        else{
            dp[sI][tI]=solve(s,t,sI,tI+1,dp);
        }
        return dp[sI][tI];
    }
}