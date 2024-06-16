class Solution {
    public int[] searchRange(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;

       int[] result = {-1, -1};

        while(start<=end){
            int mid = start + (end - start)/2;
            if(nums[mid] == target){
                result[0] = mid;
                result[1] = mid;

                // Expand the range to the left
                while (result[0] > 0 && nums[result[0] - 1] == target) {
                    result[0]--;
                }
                // Expand the range to the right
                while (result[1] < nums.length - 1 && nums[result[1] + 1] == target) {
                    result[1]++;
                }
                return result;
            }
            else if(nums[mid]>target){
                end = mid-1;
                
            }
            else {
                start = mid+1;
            }
        }
        
        return result;
    }
}