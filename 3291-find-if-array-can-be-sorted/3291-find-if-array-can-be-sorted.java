class Solution {
    public boolean canSortArray(int[] nums) {
        // Initialize the previous maximum value to the lowest possible value.
        int prevMax = Integer.MIN_VALUE;
      
        // Index 'i' will track the start of each segment with equal bit count.
        int i = 0;
        // 'n' holds the length of the input array.
        int n = nums.length;
      
        // Loop through the elements of the array.
        while (i < n) {
            // 'j' will track the end of the current segment.
            int j = i + 1;
            // 'bitCount' stores the number of 1-bits in current array element.
            int bitCount = Integer.bitCount(nums[i]);
            // 'min' and 'max' track the minimum and maximum of the current segment.
            int min = nums[i], max = nums[i];
          
            // Continue to next elements if they have the same bit count.
            while (j < n && Integer.bitCount(nums[j]) == bitCount) {
                min = Math.min(min, nums[j]);
                max = Math.max(max, nums[j]);
                j++;
            }
          
            // If the max value of the previous segment is greater than the min of the current, it can't be sorted.
            if (prevMax > min) {
                return false;
            }
            // Update the prevMax to the max value of the current segment.
            prevMax = max;
          
            // Move 'i' to the start of the next segment.
            i = j;
        }
        // If all segments are in the correct order, return true.
        return true;
    }
}
