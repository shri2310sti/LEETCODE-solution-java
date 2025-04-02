class Solution {
    public long maximumTripletValue(int[] nums) {
        int n = nums.length;
        long maxTripletValue = 0;
        
        int max_i = nums[0]; // Maximum value seen before index j
        int max_diff = Integer.MIN_VALUE; // Maximum (nums[i] - nums[j]) seen before k

        for (int j = 1; j < n - 1; j++) {
            // Compute max_diff before reaching index k
            max_diff = Math.max(max_diff, max_i - nums[j]);

            // Compute the triplet value using max_diff
            maxTripletValue = Math.max(maxTripletValue, (long) max_diff * nums[j + 1]);

            // Update max_i (prefix max for i)
            max_i = Math.max(max_i, nums[j]);
        }
        
        return maxTripletValue;
    }
}
