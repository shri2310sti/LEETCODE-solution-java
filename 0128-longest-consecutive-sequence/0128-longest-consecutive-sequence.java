class Solution {
    public int longestConsecutive(int[] nums) {
        if(nums.length == 0) return 0;
        Arrays.sort(nums);
        int count = 0;
        int c = 0;
        for(int i = 0; i<nums.length-1; i++){
            if(nums[i+1] == nums[i]) continue;
            else if(nums[i+1] - nums[i] == 1) c++;
            else c = 0;
            count = Math.max(count, c);
        }
        return ++count;
    }
}