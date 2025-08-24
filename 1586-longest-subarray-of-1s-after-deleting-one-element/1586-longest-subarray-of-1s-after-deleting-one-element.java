class Solution {
    public int longestSubarray(int[] nums) {
        int left = 0, right = 0;
        int zeroCount = 0;
        int maxLength = 0;

        while (right < nums.length) {
            if (nums[right] == 0) {
                zeroCount++;
            }

            while (zeroCount > 1) {
                if (nums[left] == 0) {
                    zeroCount--;
                }
                left++;
            }

            maxLength = Math.max(maxLength, right - left);
            right++;
        }

        // Since we must delete one element, the length of the subarray is reduced by 1
        return maxLength;
    }
}
