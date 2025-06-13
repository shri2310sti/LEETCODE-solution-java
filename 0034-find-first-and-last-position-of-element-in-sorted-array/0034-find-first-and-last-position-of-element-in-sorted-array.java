class Solution {
    public int[] searchRange(int[] nums, int target) {
        int low = 0, high = nums.length - 1;
        int[] ans = {-1, -1};

        while(low <= high){
            int mid = (low + high) / 2;

            if(nums[mid] == target){
                ans[0] = mid;
                ans[1] = mid;
                // expanding left side
                while(ans[0] > 0 && nums[ans[0] - 1] == target){
                    ans[0] --;
                }
                while(ans[1] < nums.length - 1 && nums[ans[1] + 1] == target){
                    ans[1] ++;
                }
                return ans;
            }
            else if(nums[mid] < target) low = mid + 1;
            else high = mid -1;

        }
        return ans;
    }
}