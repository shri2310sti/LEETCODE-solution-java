class Solution {
    public int longestNiceSubarray(int[] nums) {
        int left = 0, orMask = 0, maxLength = 0;
        
        for (int right = 0; right < nums.length; right++) {
            // If nums[right] conflicts with existing elements in the window, shrink the window
            while ((orMask & nums[right]) != 0) {
                orMask ^= nums[left]; // Remove nums[left] from OR mask
                left++;
            }
            
            // Add nums[right] to OR mask
            orMask |= nums[right];
            
            // Update max length
            maxLength = Math.max(maxLength, right - left + 1);
        }
        
        return maxLength;
    }
}
