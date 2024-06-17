class Solution {
    public int climbStairs(int n) {
         if (n <= 1)
            return 1;
        
        // Array to store the number of ways to reach each step
        int[] dp = new int[n + 1];
        
        // Base cases
        dp[0] = 1; // There's one way to reach step 0 (by not taking any steps)
        dp[1] = 1; // There's one way to reach step 1 (by taking 1 step)
        
        // Iterate from step 2 to step n
        for (int i = 2; i <= n; i++) {
            // The number of ways to reach step i is the sum of the number of ways to reach
            // the previous two steps
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        
        // The result will be the number of ways to reach the nth step
        return dp[n];
    }
}