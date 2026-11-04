class Solution {
    public void sortColors(int[] nums) {
        int l = 0, c = 0, h = nums.length-1;
        while(c <= h){
            if(nums[c] == 0) {
                int temp = nums[l];
                nums[l] = nums[c];
                nums[c] = temp;
                l++;
                c++;
            } 
            else if(nums[c] == 1) c++;
            else {
                int temp = nums[h];
                nums[h] = nums[c];
                nums[c] = temp;
                h--;
            }
        }
    }
}