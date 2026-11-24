class Solution {
    public int rob(int[] nums) {
        int[] dp = new int[nums.length];
        Arrays.fill(dp,-1);
        return helper(nums, nums.length-1,dp);
    }
    int helper(int[] nums, int n, int[] dp){
        dp[0] = nums[0];
        
        for(int i=1; i<nums.length; i++){
            int pick = nums[i] + (i>1 ? dp[i-2]:0);
            int nonpick = 0 + dp[i-1];
            dp[i] = Math.max(pick, nonpick);
        }
        
        return dp[n];
    }

}