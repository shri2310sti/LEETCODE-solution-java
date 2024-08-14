import java.util.Arrays;

class Solution {
    public int smallestDistancePair(int[] nums, int k) {
        Arrays.sort(nums);  // Step 1: Sort the array
        int n = nums.length;
        
        // Step 2: Binary search on the distance
        int low = 0;
        int high = nums[n - 1] - nums[0];
        
        while (low < high) {
            int mid = (low + high) / 2;
            int count = 0;
            int left = 0;
            
            // Step 3: Count pairs with distance <= mid
            for (int right = 0; right < n; right++) {
                while (nums[right] - nums[left] > mid) {
                    left++;
                }
                count += right - left;
            }
            
            // Step 4: Adjust the search range based on the count
            if (count < k) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        
        return low;  // The k-th smallest distance
    }
}
