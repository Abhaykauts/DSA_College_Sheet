class Solution {
    int n;
    public String longestPalindrome(String s) {
        n = s.length();
        int maxlen = 1;
        int start=0;
        Boolean[][] dp = new Boolean[n+1][n+1];
        for(int i=0;i<n;i++){
            for(int j=i;j<n;j++){
                if(solve(s,i,j,dp) && j-i+1>maxlen){
                    maxlen = j-i+1;
                    start = i;
                }
            }
        }
        return s.substring(start,start+maxlen);
    }

    private boolean solve(String s,int i,int j,Boolean[][]dp){
        if(i>=j) return true;
        if(dp[i][j]!=null) return dp[i][j];
        if(s.charAt(i)==s.charAt(j)){
            return dp[i][j]=solve(s,i+1,j-1,dp);
        }
        return dp[i][j]=false;
    }
}