class Solution {
    public int[] resultsArray(int[] nums, int k) {
        int n = nums.length;
        int[] results = new int[n - k + 1];
        
        for (int i = 0; i <= n - k; i++) {
            boolean isConsecutive = true;

            // Check if the subarray [i, i+k-1] is consecutive and sorted
            for (int j = i; j < i + k - 1; j++) {
                if (nums[j + 1] - nums[j] != 1) {
                    isConsecutive = false;
                    break;
                }
            }

            // If valid, assign the max element, otherwise assign -1
            results[i] = isConsecutive ? nums[i + k - 1] : -1;
        }
        
        return results;
    }
}
