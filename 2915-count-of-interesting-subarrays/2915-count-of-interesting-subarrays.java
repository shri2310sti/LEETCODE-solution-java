import java.util.*;

class Solution {
    public long countInterestingSubarrays(List<Integer> nums, int modulo, int k) {
        Map<Integer, Long> freq = new HashMap<>();
        freq.put(0, 1L); // Base case: prefix sum 0 has occurred once

        long res = 0;
        int prefixSum = 0;

        for (int num : nums) {
            // If num % modulo == k, treat as 1, else 0
            if (num % modulo == k) {
                prefixSum++;
            }

            // We want to find how many previous prefixSums exist such that:
            // (prefixSum - prevPrefixSum) % modulo == k
            // => prevPrefixSum % modulo == (prefixSum - k + modulo) % modulo
            int target = (prefixSum - k + modulo) % modulo;

            res += freq.getOrDefault(target, 0L);

            // Update freq map with current prefixSum % modulo
            int modded = prefixSum % modulo;
            freq.put(modded, freq.getOrDefault(modded, 0L) + 1);
        }

        return res;
    }
}
