class Solution {
    public int numOfSubarrays(int[] arr) {
        int MOD = 1000000007;
        int oddCount = 0, evenCount = 1; // evenCount starts with 1 (empty subarray sum is considered even)
        int prefixSum = 0, result = 0;

        for (int num : arr) {
            prefixSum += num;
            if (prefixSum % 2 == 0) {
                result = (result + oddCount) % MOD;
                evenCount++;
            } else {
                result = (result + evenCount) % MOD;
                oddCount++;
            }
        }
        
        return result;
    }
}
