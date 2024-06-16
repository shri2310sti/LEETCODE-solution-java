class Solution {
    public int firstMissingPositive(int[] nums) {
        
        int count = 1;
        int n = nums.length;
        Arrays.sort(nums);
        for(int i = 0; i<n; i++){
            if(nums[i] == count){
                count++;   
            }
        }
        
        return count;
    }
}