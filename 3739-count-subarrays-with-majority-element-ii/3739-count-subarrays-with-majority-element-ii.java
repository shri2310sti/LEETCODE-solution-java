class Solution {
    public long countMajoritySubarrays(int[] nums, int target) {
        int n = nums.length;

        // Step 1: Build prefix balance array
        int[] partialBalance = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            partialBalance[i] = partialBalance[i - 1] + (nums[i - 1] == target ? 1 : -1);
        }

        final int SHIFT = n;  // to handle negative indices
        int[] count = new int[2 * n + 1];

        long ans = 0;
        long lBalance = 0;
        long lCount = 0;

        // Step 2: Count valid majority subarrays
        for (int i = 0; i <= n; i++) {
            while (lBalance < partialBalance[i] - 1) {
                lBalance++;
                lCount += count[(int) (lBalance + SHIFT)];
            }
            while (lBalance > partialBalance[i] - 1) {
                lBalance--;
                lCount -= count[(int) (lBalance + 1 + SHIFT)];
            }

            ans += lCount;
            count[partialBalance[i] + SHIFT]++;
        }

        return ans;
    }
}