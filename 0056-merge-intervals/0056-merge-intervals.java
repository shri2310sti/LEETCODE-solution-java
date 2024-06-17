import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public int[][] merge(int[][] intervals) {
        // Sort intervals based on start time
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        
        List<int[]> mergedIntervals = new ArrayList<>();
        
        for (int[] interval : intervals) {
            // If the merged intervals list is empty or the current interval doesn't overlap with the last merged interval
            if (mergedIntervals.isEmpty() || interval[0] > mergedIntervals.get(mergedIntervals.size() - 1)[1]) {
                mergedIntervals.add(interval);
            } else {
                // Merge overlapping intervals by updating the end time of the last merged interval
                mergedIntervals.get(mergedIntervals.size() - 1)[1] = Math.max(mergedIntervals.get(mergedIntervals.size() - 1)[1], interval[1]);
            }
        }
        
        return mergedIntervals.toArray(new int[mergedIntervals.size()][]);
    }
}
