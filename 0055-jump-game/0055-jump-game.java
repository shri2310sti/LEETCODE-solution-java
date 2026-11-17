class Solution {
    public boolean canJump(int[] nums) {
        int i=0;
        int maxReach = 0;
        if(nums.length == 1) return true;
        while(i<nums.length){
            if(i>maxReach) return false;
            int sum = i+nums[i];
            maxReach = Math.max(maxReach, sum);
            i++;
        }
        
        return true;
    }
}