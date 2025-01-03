class Solution {
    public int waysToSplitArray(int[] nums) {
        // Calculate the total sum of the array
        long totalSum = 0;
        for (int num : nums) {
            totalSum += num;
        }

        // Initialize prefix sum and count of valid splits
        long prefixSum = 0;
        int validSplits = 0;

        // Iterate through the array to find valid splits
        for (int i = 0; i < nums.length - 1; i++) {
            prefixSum += nums[i];
            long suffixSum = totalSum - prefixSum;

            // Check if the current split is valid
            if (prefixSum >= suffixSum) {
                validSplits++;
            }
        }

        return validSplits;
    }
}
