class Solution {
    public int longestCommonSubstr(String s1, String s2) {
        // code here
        int[][]dp = new int[s1.length()+1][s2.length()+1];
        return solve(s1,s2,dp);
    }
    private int solve(String s1,String s2,int[][]dp){
        
        int result=0;
        
        for(int i=1;i<=s1.length();i++){
            for(int j=1;j<=s2.length();j++){
                if(s1.charAt(i-1)==s2.charAt(j-1)){
                    dp[i][j]=1+dp[i-1][j-1];
                    result=Math.max(dp[i][j],result);
                }
                else{
                     dp[i][j]=0;
                }
            }
        }
        
        return result;
    }
}