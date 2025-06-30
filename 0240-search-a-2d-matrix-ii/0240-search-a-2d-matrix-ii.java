class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        for(int i = 0 ; i < matrix.length; i++){
            if(bs(matrix[i], target)) return true;
        }
        return false;
    }
    static boolean bs(int[] nums, int target){
        int low = 0, high = nums.length - 1;
        while(low <= high){
            int mid = (low + high) / 2;
            if(nums[mid] == target) return true;
            else if(nums[mid] > target) high = mid - 1;
            else low = mid + 1;
        }
        return false;
    }
}