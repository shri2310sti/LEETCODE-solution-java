class Solution {
    public long gridGame(int[][] grid) {
        int n = grid[0].length;
        
        // Step 1: Compute prefix sums for row 0 and suffix sums for row 1
        long[] prefixRow0 = new long[n];
        long[] suffixRow1 = new long[n];
        
        // Compute prefix sums for row 0
        prefixRow0[0] = grid[0][0];
        for (int i = 1; i < n; i++) {
            prefixRow0[i] = prefixRow0[i - 1] + grid[0][i];
        }
        
        // Compute suffix sums for row 1
        suffixRow1[n - 1] = grid[1][n - 1];
        for (int i = n - 2; i >= 0; i--) {
            suffixRow1[i] = suffixRow1[i + 1] + grid[1][i];
        }
        
        // Step 2: Minimize the maximum points Robot 2 can collect
        long result = Long.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            long abovePath = (i + 1 < n) ? prefixRow0[n - 1] - prefixRow0[i] : 0;
            long belowPath = (i - 1 >= 0) ? suffixRow1[0] - suffixRow1[i] : 0;
            
            long robot2Points = Math.max(abovePath, belowPath);
            result = Math.min(result, robot2Points);
        }
        
        return result;
    }
}
