class Solution {
    public int minKBitFlips(int[] nums, int k) {
        int n = nums.length;
        int[] isFlipped = new int[n];
        int flips = 0, result = 0;

        for (int i = 0; i < n; ++i) {
            if (i >= k) {
                flips ^= isFlipped[i - k];
            }
            
            if ((nums[i] ^ flips) == 0) {
                if (i + k > n) return -1;
                flips ^= 1;
                isFlipped[i] = 1;
                result++;
            }
        }
        return result;
    }
}
