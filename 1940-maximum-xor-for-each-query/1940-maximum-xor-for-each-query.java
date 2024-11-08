class Solution {
    public int[] getMaximumXor(int[] nums, int maximumBit) {
        int n = nums.length;
        int[] result = new int[n];
        
        // Calculate the maximum possible value with maximumBit bits
        int max_possible = (1 << maximumBit) - 1;
        
        // Calculate the cumulative XOR for the whole array
        int numsXor = 0;
        for (int num : nums) {
            numsXor ^= num;
        }
        
        // Process each query in reverse order
        for (int i = 0; i < n; i++) {
            // k is found by XORing numsXor with max_possible
            result[i] = numsXor ^ max_possible;
            
            // Remove the last element's effect from numsXor for the next iteration
            numsXor ^= nums[n - 1 - i];
        }
        
        return result;
    }
}
