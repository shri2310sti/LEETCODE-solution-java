class Solution {
    public int minPatches(int[] nums, int n) {
        int patches = 0;
        long miss = 1; // Start with the smallest number we need to be able to form
        int i = 0;
        
        while (miss <= n) {
            if (i < nums.length && nums[i] <= miss) {
                miss += nums[i]; // Extend the range with the current number in nums
                i++;
            } else {
                miss += miss; // Add a patch (miss itself)
                patches++;
            }
        }
        
        return patches;
    }
}
