import java.util.Arrays;

class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums); // Sort the array to make it easier to handle
        
        int closestSum = nums[0] + nums[1] + nums[2]; // Initialize closestSum with the sum of the first three elements
        
        for (int i = 0; i < nums.length - 2; i++) {
            int left = i + 1; // Pointer for the element after nums[i]
            int right = nums.length - 1; // Pointer for the last element
            
            while (left < right) {
                int currentSum = nums[i] + nums[left] + nums[right];
                
                if (Math.abs(currentSum - target) < Math.abs(closestSum - target)) {
                    closestSum = currentSum; // Update closestSum if the current sum is closer to the target
                }
                
                if (currentSum < target) {
                    left++; // Move left pointer to increase the sum
                } else if (currentSum > target) {
                    right--; // Move right pointer to decrease the sum
                } else {
                    // If currentSum == target, this is the closest possible sum, so return it
                    return closestSum;
                }
            }
        }
        
        return closestSum;
    }
}
