class Solution {
    public int uniquePaths(int m, int n) {
        // Initialize the 2D array for dynamic programming
        int[][] dp = new int[m][n];
        
        // Initialize the base cases for the first row and first column
        for (int i = 0; i < m; i++) {
            dp[i][0] = 1;
        }
        for (int j = 0; j < n; j++) {
            dp[0][j] = 1;
        }
        
        // Calculate the number of unique paths for other cells
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }
        
        // Return the number of unique paths to reach the bottom-right corner
        return dp[m - 1][n - 1];
    }
}
