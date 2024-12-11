import java.util.Arrays;

class Solution {
    public int maximumBeauty(int[] nums, int k) {
        // Sort the array
        Arrays.sort(nums);
        
        int maxBeauty = 0;
        int n = nums.length;
        int left = 0;

        // Sliding window approach
        for (int right = 0; right < n; right++) {
            // Ensure the range [nums[right] - k, nums[right] + k] is valid
            while (nums[right] - nums[left] > 2 * k) {
                left++;
            }
            // Update the maximum beauty
            maxBeauty = Math.max(maxBeauty, right - left + 1);
        }

        return maxBeauty;
    }
}
