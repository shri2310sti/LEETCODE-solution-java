import java.util.Arrays;

class Solution {
    public long countFairPairs(int[] nums, int lower, int upper) {
        Arrays.sort(nums);
        long count = 0;
        
        for (int i = 0; i < nums.length - 1; i++) {
            int left = findLowerBound(nums, i + 1, nums.length, lower - nums[i]);
            int right = findUpperBound(nums, i + 1, nums.length, upper - nums[i]);
            
            // The number of valid pairs with nums[i] as the first element
            count += right - left;
        }
        
        return count;
    }

    // Finds the first index where nums[index] >= target
    private int findLowerBound(int[] nums, int start, int end, int target) {
        int left = start, right = end;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] >= target) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    // Finds the first index where nums[index] > target
    private int findUpperBound(int[] nums, int start, int end, int target) {
        int left = start, right = end;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] > target) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }
}
