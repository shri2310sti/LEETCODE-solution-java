import java.util.*;

class Solution {
    public int minimumOperations(int[] nums) {
        int operations = 0;
        int i = 0;
        int n = nums.length;
        
        while (i < n) {
            Set<Integer> set = new HashSet<>();
            for (int j = i; j < n; j++) {
                set.add(nums[j]);
            }
            if (set.size() == n - i) {
                // All elements from i to end are distinct
                return operations;
            } else {
                // Remove 3 elements from start
                i += 3;
                operations++;
            }
        }
        return operations;
    }
}
