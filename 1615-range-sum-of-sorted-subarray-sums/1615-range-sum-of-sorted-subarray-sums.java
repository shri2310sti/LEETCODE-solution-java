class Solution {
    public int rangeSum(int[] nums, int n, int left, int right) {
        int MOD = 1000000007;
        List<Integer> subarraySums = new ArrayList<>();
        
        // Calculate all subarray sums
        for (int start = 0; start < n; start++) {
            int sum = 0;
            for (int end = start; end < n; end++) {
                sum += nums[end];
                subarraySums.add(sum);
            }
        }
        
        // Sort subarray sums
        Collections.sort(subarraySums);
        
        // Calculate the sum from index 'left' to 'right' (1-based index)
        int sum = 0;
        for (int i = left - 1; i < right; i++) {
            sum = (sum + subarraySums.get(i)) % MOD;
        }
        
        return sum;
    }
}
