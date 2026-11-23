class Solution {
    public int climbStairs(int n) {
        int[] dp = new int[n+1];
        Arrays.fill(dp, -1);
        return func(n, dp);
    }
    public int func(int n, int[] dp){
        // if(n == 0 || n == 1) return 1;
        dp[0] = 1;
        dp[1] = 2;
        for(int i=2; i<n; i++){
            dp[i] = dp[i-1] + dp[i-2];
        }
        
        return dp[n-1];
    }
}