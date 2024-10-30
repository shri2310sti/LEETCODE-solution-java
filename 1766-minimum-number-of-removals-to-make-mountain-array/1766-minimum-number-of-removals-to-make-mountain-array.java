class Solution {
    public int minimumMountainRemovals(int[] nums) {
        int n = nums.length;
        
        // Step 1: Calculate LIS for each element
        int[] lis = new int[n];
        Arrays.fill(lis, 1);
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    lis[i] = Math.max(lis[i], lis[j] + 1);
                }
            }
        }
        
        // Step 2: Calculate LDS for each element
        int[] lds = new int[n];
        Arrays.fill(lds, 1);
        for (int i = n - 2; i >= 0; i--) {
            for (int j = i + 1; j < n; j++) {
                if (nums[i] > nums[j]) {
                    lds[i] = Math.max(lds[i], lds[j] + 1);
                }
            }
        }
        
        // Step 3: Find the longest mountain length
        int maxMountainLen = 0;
        for (int i = 1; i < n - 1; i++) {
            if (lis[i] > 1 && lds[i] > 1) { // Valid peak for mountain
                maxMountainLen = Math.max(maxMountainLen, lis[i] + lds[i] - 1);
            }
        }
        
        // Step 4: Calculate the minimum removals
        return n - maxMountainLen;
    }
}
