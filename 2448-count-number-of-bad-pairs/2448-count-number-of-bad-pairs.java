import java.util.HashMap;
import java.util.Map;

class Solution {
    public long countBadPairs(int[] nums) {
        Map<Integer, Integer> freqMap = new HashMap<>();
        long goodPairs = 0, n = nums.length;

        for (int i = 0; i < n; i++) {
            int key = nums[i] - i;
            goodPairs += freqMap.getOrDefault(key, 0);
            freqMap.put(key, freqMap.getOrDefault(key, 0) + 1);
        }

        long totalPairs = (n * (n - 1)) / 2;
        return totalPairs - goodPairs;
    }
}
