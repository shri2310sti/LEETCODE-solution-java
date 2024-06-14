import java.util.Arrays;

class Solution {
    public int minIncrementForUnique(int[] nums) {
        Arrays.sort(nums);
        int moves = 0;
        
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] <= nums[i - 1]) {
                int newValue = nums[i - 1] + 1;
                moves += newValue - nums[i];
                nums[i] = newValue;
            }
        }
        
        return moves;
    }
}
