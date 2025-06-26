class Solution {
    public int uniquePaths(int m, int n) {
        int[][] result = new int[m][n];
        for(int[] row:result){
            Arrays.fill(row,-1);
        }
        return countPaths(0,0,m,n,result);
    }

    private int countPaths(int i, int j,int m,int n,int[][] result){
        if(i>=m || j>=n) return 0;
        if(i==m-1 && j==n-1) return 1;

        if(result[i][j]!=-1) return result[i][j];

        return result[i][j]=countPaths(i+1,j,m,n,result)+countPaths(i,j+1,m,n,result);
        
    }
}