import java.util.Arrays;

class Solution {
    public long countFairPairs(int[] nums, int lower, int upper) {
        Arrays.sort(nums); // Step 1: Sort the array
        long count = 0;
        int n = nums.length;
        
        for (int i = 0; i < n; i++) {
            // Step 2: Use binary search to find valid range for j > i
            int left = lowerBound(nums, i + 1, n - 1, lower - nums[i]);
            int right = upperBound(nums, i + 1, n - 1, upper - nums[i]);
            count += (right - left);
        }
        
        return count;
    }
    
    // Finds first index where nums[index] >= target
    private int lowerBound(int[] nums, int start, int end, int target) {
        int low = start, high = end + 1;
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] < target) low = mid + 1;
            else high = mid;
        }
        return low;
    }

    // Finds first index where nums[index] > target
    private int upperBound(int[] nums, int start, int end, int target) {
        int low = start, high = end + 1;
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] <= target) low = mid + 1;
            else high = mid;
        }
        return low;
    }
}
