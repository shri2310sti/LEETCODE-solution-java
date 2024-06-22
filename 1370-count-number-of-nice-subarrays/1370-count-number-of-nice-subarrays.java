import java.util.HashMap;

public class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        HashMap<Integer, Integer> prefixCounts = new HashMap<>();
        prefixCounts.put(0, 1);  // Base case: one way to have zero odd numbers initially
        int oddCount = 0;
        int result = 0;

        for (int num : nums) {
            // Increment oddCount if the current number is odd
            if (num % 2 == 1) {
                oddCount++;
            }
            // Check how many times the oddCount - k has occurred
            result += prefixCounts.getOrDefault(oddCount - k, 0);
            // Update the count of current oddCount in the prefixCounts map
            prefixCounts.put(oddCount, prefixCounts.getOrDefault(oddCount, 0) + 1);
        }

        return result;
    }
}
