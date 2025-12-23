import java.util.*;

class Solution {
    public int maxTwoEvents(int[][] events) {
        // Sort events by their end time
        Arrays.sort(events, (a, b) -> Integer.compare(a[1], b[1]));
        
        int maxSingleValue = 0;
        int maxSum = 0;
        
        TreeMap<Integer, Integer> endTimeToMaxValue = new TreeMap<>();
        
        for (int[] event : events) {
            int startTime = event[0];
            int endTime = event[1];
            int value = event[2];
            
            // Find the largest end time that doesn't overlap with this event
            Map.Entry<Integer, Integer> entry = endTimeToMaxValue.floorEntry(startTime - 1);
            int bestNonOverlappingValue = (entry != null) ? entry.getValue() : 0;
            
            // Update the maximum sum of two events
            maxSum = Math.max(maxSum, bestNonOverlappingValue + value);
            
            // Update the maximum value of a single event
            maxSingleValue = Math.max(maxSingleValue, value);
            
            // Store the best value so far for this end time
            endTimeToMaxValue.put(endTime, Math.max(endTimeToMaxValue.getOrDefault(endTime, 0), maxSingleValue));
        }
        
        return maxSum;
    }
}