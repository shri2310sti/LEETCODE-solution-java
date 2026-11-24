class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;

        if(m==1 && n==1) {
            if(obstacleGrid[m-1][n-1] == 1) return 0;
            else return 1;
        }
        int[][] dp = new int[m][n];
        for(int i=0; i<m; i++) Arrays.fill(dp[i], -1);
        return helper(m-1,n-1,dp,obstacleGrid);
    }
    int helper(int m, int n, int[][] dp, int[][] obstacleGrid){
        if(obstacleGrid[m][n] == 1) return 0;
        if(m==0 && n==0) return 1;
        
        if(dp[m][n] != -1) return dp[m][n];
        
        int a = 0; int b = 0;

        if(m>0) a = helper(m-1,n,dp,obstacleGrid);
        if(n>0) b = helper(m,n-1,dp,obstacleGrid);
        return dp[m][n] = a+b;
    }
}