import java.util.HashMap;
import java.util.Map;

class Solution {
    public int lenLongestFibSubseq(int[] arr) {
        int n = arr.length;
        Map<Integer, Integer> indexMap = new HashMap<>();
        Map<String, Integer> dp = new HashMap<>();
        int maxLen = 0;

        // Store the index of each number in arr
        for (int i = 0; i < n; i++) {
            indexMap.put(arr[i], i);
        }

        // Iterate through pairs (i, j) and check if arr[i] + arr[j] exists
        for (int j = 0; j < n; j++) {
            for (int i = 0; i < j; i++) {
                int sum = arr[i] + arr[j];

                // Check if sum exists in the array
                if (indexMap.containsKey(sum)) {
                    int k = indexMap.get(sum);
                    String key = i + "," + j;
                    String nextKey = j + "," + k;

                    // If (i, j) pair has a previous sequence, extend it
                    dp.put(nextKey, dp.getOrDefault(key, 2) + 1);

                    // Update max length found
                    maxLen = Math.max(maxLen, dp.get(nextKey));
                }
            }
        }

        return maxLen >= 3 ? maxLen : 0;
    }
}
