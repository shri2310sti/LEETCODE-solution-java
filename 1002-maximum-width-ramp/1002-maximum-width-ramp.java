import java.util.*;

class Solution {
    public int maxWidthRamp(int[] nums) {
        // Step 1: Store indices with values
        int n = nums.length;
        List<int[]> indexValuePairs = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            indexValuePairs.add(new int[] {nums[i], i});
        }
        
        // Step 2: Sort the array by values (and indices as tie-breaker)
        Collections.sort(indexValuePairs, (a, b) -> Integer.compare(a[0], b[0]));
        
        // Step 3: Track the minimum index encountered so far
        int minIndex = Integer.MAX_VALUE;
        int maxWidth = 0;
        
        // Step 4: Iterate through the sorted array to compute max width
        for (int[] pair : indexValuePairs) {
            int value = pair[0];
            int index = pair[1];
            
            // Calculate the width and update the maximum width if valid
            maxWidth = Math.max(maxWidth, index - minIndex);
            
            // Update the minimum index encountered so far
            minIndex = Math.min(minIndex, index);
        }
        
        return maxWidth;
    }
}
