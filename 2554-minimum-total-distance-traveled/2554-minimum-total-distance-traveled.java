import java.util.Arrays;
import java.util.List;

class Solution {
    public long minimumTotalDistance(List<Integer> robot, int[][] factory) {
        int n = robot.size();
        int m = factory.length;
        
        // Sort robots and factories by position
        robot.sort(Integer::compareTo);
        Arrays.sort(factory, (a, b) -> Integer.compare(a[0], b[0]));

        // DP array to hold minimum distances
        long[][] dp = new long[n + 1][m + 1];
        
        // Initialize dp array with large values, as we are looking for the minimum
        for (int i = 0; i <= n; i++) {
            Arrays.fill(dp[i], Long.MAX_VALUE);
        }
        
        // Base case: 0 robots to repair requires 0 distance
        dp[0][0] = 0;

        for (int j = 1; j <= m; j++) {  // Factories
            int factoryPos = factory[j - 1][0];
            int limit = factory[j - 1][1];
            
            for (int i = 0; i <= n; i++) {  // Robots
                // Case where we don't use the j-th factory
                dp[i][j] = dp[i][j - 1];
                
                // Try to repair k robots at this factory
                long distance = 0;
                for (int k = 1; k <= limit && i - k >= 0; k++) {
                    distance += Math.abs(factoryPos - robot.get(i - k));
                    if (dp[i - k][j - 1] != Long.MAX_VALUE) {
                        dp[i][j] = Math.min(dp[i][j], dp[i - k][j - 1] + distance);
                    }
                }
            }
        }
        
        // The answer is the minimum distance to repair all robots with all factories
        return dp[n][m];
    }
}
