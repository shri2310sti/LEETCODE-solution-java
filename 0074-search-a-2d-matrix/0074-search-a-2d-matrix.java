class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int n = matrix.length;
        int m = matrix[0].length;
        for(int i = 0; i < matrix.length; i++){
            if(matrix[i][0] <= target && target <= matrix[i][m-1]){
                return binarySearch(matrix[i], target);
            }
        }
        return false;
    }
    static boolean binarySearch(int[] mat, int target){
        int low = 0, high = mat.length - 1;
        while(low <= high){
            int mid = (low + high) / 2;
            if(mat[mid] == target) return true;
            if(mat[mid] > target) high = mid - 1;
            else low = mid + 1;
        }
        return false;
    }
}