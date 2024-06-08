class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        // Create a dp array to store the minimum cost to reach each step
        int[] dp = new int[n + 1];
        
        // Base cases
        dp[0] = 0;
        dp[1] = 0;
        
        // Fill the dp array using the recurrence relation
        for (int i = 2; i <= n; i++) {
            dp[i] = Math.min(dp[i - 1] + cost[i - 1], dp[i - 2] + cost[i - 2]);
        }
        
        // The answer will be the minimum cost to reach the top (which is beyond the last step)
        return dp[n];
    }
}
