import java.util.*;

class Solution {
    public int minOperations(int[] nums, int k) {
        // Step 1: If any number < k, return -1
        for (int num : nums) {
            if (num < k) return -1;
        }

        // Step 2: Collect unique numbers > k
        TreeSet<Integer> greater = new TreeSet<>(Collections.reverseOrder());
        for (int num : nums) {
            if (num > k) {
                greater.add(num);
            }
        }

        

        return greater.size();
    }
}
