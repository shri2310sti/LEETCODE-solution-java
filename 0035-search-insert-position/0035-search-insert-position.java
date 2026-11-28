class Solution {
    public int searchInsert(int[] nums, int target) {
        int ans = nums.length;
        for(int i=0; i<nums.length; i++){
            if(target <= nums[i]) {
                ans = i;
                break;
            }
        }
        return ans;
    }
}