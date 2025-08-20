class Solution {
    public int countSquares(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] dp = new int[m][n];
        int count = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 1) {
                    if (i == 0 || j == 0) {
                        // If it's in the first row or first column, it can only be a 1x1 square
                        dp[i][j] = 1;
                    } else {
                        // Update dp with the minimum square size that can be formed at (i, j)
                        dp[i][j] = 1 + Math.min(dp[i - 1][j], Math.min(dp[i][j - 1], dp[i - 1][j - 1]));
                    }
                    // Add the current dp[i][j] to the count
                    count += dp[i][j];
                }
            }
        }
        
        return count;
    }
}