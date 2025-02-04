class Solution {
    public int maxAscendingSum(int[] nums) {
        int maxSum = nums[0];  // Initialize maxSum with the first element
        int currentSum = nums[0];

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[i - 1]) {
                currentSum += nums[i];  // Extend the ascending subarray
            } else {
                currentSum = nums[i];   // Start a new ascending subarray
            }
            maxSum = Math.max(maxSum, currentSum);  // Update maxSum if needed
        }

        return maxSum;
    }
}
