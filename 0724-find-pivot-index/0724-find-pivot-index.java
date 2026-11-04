class Solution {
    public int pivotIndex(int[] nums) {
        int total = 0;
        for(int num : nums) total += num;
        int currSum = 0;
        for(int i=0; i<nums.length; i++){
            currSum += nums[i];
            if(currSum-nums[i] == total-currSum) return i;
        }
        return -1;
    }
}