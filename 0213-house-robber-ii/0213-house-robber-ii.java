class Solution {
    public int rob(int[] nums) {
        if(nums.length == 1) return nums[0];

        int[] dp = new int[nums.length-1];
        Arrays.fill(dp,-1);

        int[] arr = new int[nums.length-1];
        
        for(int i=0; i<arr.length; i++) arr[i] = nums[i];
        int f = helper1(arr,arr.length-1,dp);

        Arrays.fill(dp,-1);
        for(int i=0; i<arr.length; i++) arr[i] = nums[i+1];
        int s = helper1(arr,arr.length-1,dp);

        return  Math.max(f,s);
    }
    int helper1(int[] nums, int n, int[] dp){
        dp[0] = nums[0];
        
        for(int i=1; i<nums.length; i++){
            int pick = nums[i] + (i>1 ? dp[i-2]:0);
            int nonpick = 0 + dp[i-1];
            dp[i] = Math.max(pick, nonpick);
        }
        
        return dp[n];
    }
    int helper(int[] nums, int n, int[] dp){
        if(n==0) return nums[n];
        if(n<0) return 0;

        if(dp[n] != -1) return dp[n];

        int pick = nums[n] + helper(nums,n-2, dp);
        int nonpick = 0 + helper(nums,n-1, dp);
        
        return dp[n] = Math.max(pick, nonpick);
    }
}