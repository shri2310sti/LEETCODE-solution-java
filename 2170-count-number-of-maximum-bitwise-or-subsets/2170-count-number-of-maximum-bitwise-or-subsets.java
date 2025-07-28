class Solution {
    public int countMaxOrSubsets(int[] nums) {
        int n = nums.length;
        int maxOr = 0;

        // Step 1: Find the maximum OR possible with all elements
        for (int num : nums) {
            maxOr |= num;
        }

        // Step 2: Count subsets that match the maximum OR
        int count = 0;

        // Explore all possible subsets
        for (int mask = 0; mask < (1 << n); mask++) {
            int currentOr = 0;
            // Generate the subset based on the current mask
            for (int i = 0; i < n; i++) {
                if ((mask & (1 << i)) != 0) {
                    currentOr |= nums[i];
                }
            }

            // Check if the OR of this subset matches the max OR
            if (currentOr == maxOr) {
                count++;
            }
        }

        return count;
    }
}