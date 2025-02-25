import java.util.*;

class Solution {
    public int majorityElement(int[] nums) {
        int candidate = 0, count = 0;

        for (int num : nums) {
            if (count == 0) {
                candidate = num;
            }
            if (num == candidate) {
                count += 1;  
            } else {
                count -= 1;  
            }
        }

        count = 0;
        for (int num : nums) {
            if (num == candidate) {
                count++;
            }
        }

        return (count > nums.length / 2) ? candidate : -1;
    }
}
