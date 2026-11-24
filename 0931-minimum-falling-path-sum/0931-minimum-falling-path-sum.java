class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] dp = new int[m][n];

        for(int i=0; i<n; i++) Arrays.fill(dp[i],Integer.MAX_VALUE);

        int min = Integer.MAX_VALUE;
        for(int i=0; i<n; i++){
            min = Math.min(min, helper(matrix, m-1, i, dp));
        }
        return min;
    }
    public int helper(int[][] matrix, int m, int n, int[][] dp){
        if(m==0) return matrix[m][n];
        if(dp[m][n] != Integer.MAX_VALUE) return dp[m][n];

        int p1 = Integer.MAX_VALUE;
        int p3 = Integer.MAX_VALUE;

        if(n>0) p1 = matrix[m][n] + helper(matrix,m-1,n-1,dp);

        int p2 = matrix[m][n] + helper(matrix,m-1,n,dp);

        if(n < matrix.length-1) p3 = matrix[m][n] + helper(matrix,m-1,n+1,dp);
        
        int ans = Math.min(p1, (Math.min(p2,p3)));

        return dp[m][n] = ans;
    }
}