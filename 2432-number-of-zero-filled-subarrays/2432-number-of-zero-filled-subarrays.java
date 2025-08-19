class Solution {
    public long zeroFilledSubarray(int[] nums) {
        long res = 0;
        int n = nums.length;
        for(int right=0;right<n;right++){
            int left = right;
            while(right < n && nums[right] == 0){
                res += (right - left + 1);
                right++;
            }
        }
        return res;
    }
}