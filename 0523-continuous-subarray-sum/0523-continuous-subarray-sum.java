import java.util.HashMap;

class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        // HashMap to store the remainder and the corresponding index
        HashMap<Integer, Integer> remainderMap = new HashMap<>();
        remainderMap.put(0, -1); // Initialize with remainder 0 at index -1
        
        int prefixSum = 0; // Initialize the prefix sum
        
        for (int i = 0; i < nums.length; i++) {
            prefixSum += nums[i]; // Update the prefix sum with current element
            
            int remainder = prefixSum % k; // Compute the remainder when prefixSum is divided by k
            
            if (remainder < 0) {
                remainder += k; // Handle negative remainders by adjusting to positive equivalent
            }
            
            if (remainderMap.containsKey(remainder)) {
                int prevIndex = remainderMap.get(remainder);
                if (i - prevIndex > 1) {
                    return true; // Subarray length is at least 2
                }
            } else {
                remainderMap.put(remainder, i); // Store the remainder and index
            }
        }
        
        return false; // No good subarray found
    }
}
