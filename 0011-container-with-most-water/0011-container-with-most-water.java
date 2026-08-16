class Solution {
    public int maxArea(int[] nums) {
        int i = 0; 
        int j = nums.length-1;
        int maxA = Integer.MIN_VALUE;

        while(i < j){
            int area = Math.min(nums[i], nums[j]) * (j-i);
            maxA = Math.max(maxA, area);
            if(nums[i] < nums[j]) i++;
            else j--;
        }
        return maxA;
    }
}