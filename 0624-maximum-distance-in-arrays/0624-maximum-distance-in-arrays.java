import java.util.List;

class Solution {
    public int maxDistance(List<List<Integer>> arrays) {
        // Initialize the result and min/max values from the first array
        int result = 0;
        int minVal = arrays.get(0).get(0);
        int maxVal = arrays.get(0).get(arrays.get(0).size() - 1);
        
        // Iterate from the second array onwards
        for (int i = 1; i < arrays.size(); i++) {
            List<Integer> currentArray = arrays.get(i);
            int currentMin = currentArray.get(0);
            int currentMax = currentArray.get(currentArray.size() - 1);
            
            // Calculate the potential maximum distance with the current array
            result = Math.max(result, Math.abs(currentMax - minVal));
            result = Math.max(result, Math.abs(maxVal - currentMin));
            
            // Update the global min and max
            minVal = Math.min(minVal, currentMin);
            maxVal = Math.max(maxVal, currentMax);
        }
        
        return result;
    }
}
