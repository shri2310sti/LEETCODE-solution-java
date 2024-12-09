class Solution {
    public boolean[] isArraySpecial(int[] nums, int[][] queries) {
        int n = nums.length;
        int[] specialPrefix = new int[n - 1];
        int[] cumulativeSpecial = new int[n];
        
        // Step 1: Preprocess to determine "special" pairs
        for (int i = 0; i < n - 1; i++) {
            if ((nums[i] % 2) != (nums[i + 1] % 2)) {
                specialPrefix[i] = 1;
            }
        }
        
        // Step 2: Create a cumulative array for quick range queries
        for (int i = 0; i < n - 1; i++) {
            cumulativeSpecial[i + 1] = cumulativeSpecial[i] + specialPrefix[i];
        }
        
        // Step 3: Process each query
        boolean[] result = new boolean[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int from = queries[i][0];
            int to = queries[i][1];
            
            // Number of pairs in the subarray
            int totalPairs = to - from;
            if (totalPairs == 0) {
                // Single element subarray is always "special"
                result[i] = true;
                continue;
            }
            
            // Count "special" pairs using the cumulative array
            int specialCount = cumulativeSpecial[to] - cumulativeSpecial[from];
            result[i] = (specialCount == totalPairs);
        }
        
        return result;
    }
}
