class Solution {
    public long maxPoints(int[][] points) {
        int m = points.length;
        int n = points[0].length;
        
        // Initialize the dp array with the first row's points
        long[] dp = new long[n];
        for (int j = 0; j < n; j++) {
            dp[j] = points[0][j];
        }
        
        // Iterate over each row starting from the second one
        for (int i = 1; i < m; i++) {
            long[] newDp = new long[n];
            
            // Left to right pass to calculate max with penalties
            long maxLeft = dp[0];
            for (int j = 0; j < n; j++) {
                maxLeft = Math.max(maxLeft, dp[j] + j);
                newDp[j] = maxLeft - j + points[i][j];
            }
            
            // Right to left pass to calculate max with penalties
            long maxRight = dp[n - 1] - (n - 1);
            for (int j = n - 1; j >= 0; j--) {
                maxRight = Math.max(maxRight, dp[j] - j);
                newDp[j] = Math.max(newDp[j], maxRight + j + points[i][j]);
            }
            
            // Update dp to be the newly calculated dp
            dp = newDp;
        }
        
        // The result is the maximum value in the last dp array
        long result = 0;
        for (int j = 0; j < n; j++) {
            result = Math.max(result, dp[j]);
        }
        
        return result;
    }
}
