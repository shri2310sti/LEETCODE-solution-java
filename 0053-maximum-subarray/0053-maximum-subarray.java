class Solution {
    public int maxSubArray(int[] nums) {
        int currSum = 0, maxSum = Integer.MIN_VALUE;
        for(int num : nums){
            currSum += num;
            maxSum = Math.max(currSum , maxSum);
            if(currSum < 0) currSum = 0;
        }
        return maxSum;
    }
}