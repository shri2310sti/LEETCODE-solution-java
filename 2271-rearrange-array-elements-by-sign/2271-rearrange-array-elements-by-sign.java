class Solution {
    public int[] rearrangeArray(int[] nums) {
        int[] ans = new int [nums.length];
        int posIdx = 0, negIdx = 1;
        for( int i = 0; i < nums.length; i++){
            if (nums[i] > 0) {
                ans[posIdx] = nums[i];
                posIdx += 2;
            } else {
                ans[negIdx] = nums[i];
                negIdx += 2;
            }
        }
        return ans;
    }
}