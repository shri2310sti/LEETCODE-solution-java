class Solution {
    public int maxSubArray(int[] nums) {
        // int maxSum = Integer.MIN_VALUE;
        // for(int i=0; i<nums.length; i++){
        //     int sum = 0;
        //     for(int j=i; j<nums.length; j++){
        //         // int sum = 0;
        //         // for (int k=i; k<=j; k++){
        //             sum += nums[j];
        //         // }
        //         if(sum > maxSum) maxSum = sum;
        //     }
        // }
        // return maxSum;

        int maxSum = Integer.MIN_VALUE;
        int sum = 0;
        for(int i=0; i<nums.length; i++){
            sum += nums[i];
            maxSum = Math.max(sum, maxSum);
            if(sum < 0) sum = 0;
        }
        return maxSum;
    }
}