class Solution {
    public int smallestDivisor(int[] nums, int threshold) {
        int max = Integer.MIN_VALUE;
        

        for(int i = 0; i < nums.length; i++){
            if(max < nums[i]) max = nums[i];
        }

        int low = 1, high = max;
        int ans = 0;
        while(low <= high){
            int mid = (low + high) / 2;
            if(sum(nums, mid) <= threshold) {
                ans = mid;
                high = mid - 1;
            }
            else low = mid + 1;
        }
        return ans;
    }
    static int sum(int[] nums, int n){
        int ans = 0;
        for(int i = 0; i < nums.length; i++){
            ans += Math.ceil((double)(nums[i])/(double)(n));
        }
        return ans;
    }
}