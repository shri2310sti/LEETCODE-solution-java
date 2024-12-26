class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        
        // If the (target + sum) is odd or target is not achievable, return 0
        if ((target + sum) % 2 != 0 || sum < Math.abs(target)) {
            return 0;
        }
        
        int subsetSum = (target + sum) / 2;
        
        // Create DP array
        int[] dp = new int[subsetSum + 1];
        dp[0] = 1; // There's one way to form sum 0: select nothing
        
        // Update DP array for each number in nums
        for (int num : nums) {
            for (int j = subsetSum; j >= num; j--) {
                dp[j] += dp[j - num];
            }
        }
        
        return dp[subsetSum];
    }
}
