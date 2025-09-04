class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        // If the starting cell has an obstacle, no paths are possible
        if (obstacleGrid[0][0] == 1) return 0;

        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;

        // dp[i][j] stores the number of unique paths to reach cell (i, j)
        int dp[][] = new int[m][n];

        // Initialize first column
        // Stop filling once an obstacle is encountered
        for (int i = 0; i < m; i++) {
            if (obstacleGrid[i][0] == 1) {
                break; // All cells after this in the column are unreachable
            } else {
                dp[i][0] = 1;
            }
        }

        // Initialize first row
        // Stop filling once an obstacle is encountered
        for (int j = 0; j < n; j++) {
            if (obstacleGrid[0][j] == 1) {
                break; // All cells after this in the row are unreachable
            } else {
                dp[0][j] = 1;
            }
        }

        // Fill the rest of the DP table
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (obstacleGrid[i][j] == 1) {
                    dp[i][j] = 0; // Cannot pass through an obstacle
                } else {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                }
            }
        }

        // The bottom-right cell contains the number of unique paths
        return dp[m - 1][n - 1];
    }
}