class Solution {
    public int longestSubarray(int[] nums) {
        int maxVal = 0;
        int maxLen = 0;
        int currentLen = 0;
        
        // Step 1: Find the maximum value in the array
        for (int num : nums) {
            if (num > maxVal) {
                maxVal = num;
            }
        }
        
        // Step 2: Find the longest subarray with the maximum value
        for (int num : nums) {
            if (num == maxVal) {
                currentLen++;
                maxLen = Math.max(maxLen, currentLen);
            } else {
                currentLen = 0;
            }
        }
        
        return maxLen;
    }
}