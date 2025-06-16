class Solution {
    public int singleNonDuplicate(int[] nums) {
        int low = 0, high = nums.length - 1;

        //edge cases
        if(nums.length == 1) return nums[0];
        if(nums[0] != nums[1]) return nums[0];
        if(nums[nums.length - 1] != nums[nums.length-2]) return nums[nums.length-1];

        while(low <= high){
            int mid = (low + high)/2;

            // check if mid is single element
            if(nums[mid] != nums[mid-1] && nums[mid] != nums[mid+1]) return nums[mid];

            // we are in left part of single element
            if((mid % 2 == 0 && nums[mid] == nums[mid+1]) || (mid % 2 != 0 && nums[mid] == nums[mid-1])) low = mid + 1;
            // we are in right part of single element
            else high = mid - 1;
        }
        return -1;
    }
}