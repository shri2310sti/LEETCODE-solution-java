class Solution {
    public void sortColors(int[] nums) {
        int idx0 = 0, idx1 = 0, idx2 = 0;
        for(int i=0; i<nums.length; i++){
            if(nums[i] == 0) idx0++; //2
            else if(nums[i] == 1) idx1++; //2
            else idx2++; //2
        }
        for(int i=0; i<idx0; i++) nums[i] = 0;
        for(int i = idx0; i < idx0+idx1; i++) nums[i] = 1;
        for(int i = idx0+idx1; i < idx0+idx1+idx2; i++) nums[i] = 2;
    }
}