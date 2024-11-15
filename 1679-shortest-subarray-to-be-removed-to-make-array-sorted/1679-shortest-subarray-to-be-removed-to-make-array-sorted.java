class Solution {
    public int findLengthOfShortestSubarray(int[] arr) {
        int n = arr.length;
        
        // Step 1: Find the longest non-decreasing prefix
        int left = 0;
        while (left < n - 1 && arr[left] <= arr[left + 1]) {
            left++;
        }
        
        // If the entire array is already sorted, no need to remove anything
        if (left == n - 1) {
            return 0;
        }
        
        // Step 2: Find the longest non-decreasing suffix
        int right = n - 1;
        while (right > 0 && arr[right - 1] <= arr[right]) {
            right--;
        }
        
        // Step 3: Calculate the minimum length to remove
        int minLengthToRemove = Math.min(n - left - 1, right); // Remove all after prefix or all before suffix
        
        // Step 4: Try to merge prefix and suffix
        int i = 0, j = right;
        while (i <= left && j < n) {
            if (arr[i] <= arr[j]) {
                minLengthToRemove = Math.min(minLengthToRemove, j - i - 1);
                i++;
            } else {
                j++;
            }
        }
        
        return minLengthToRemove;
    }
}
