import java.util.*;

class Solution {
    public int minGroups(int[][] intervals) {
        // List to store the events (start or end of intervals)
        List<int[]> events = new ArrayList<>();
        
        // Add start events (+1) and end events (-1)
        for (int[] interval : intervals) {
            events.add(new int[]{interval[0], 1});  // start of an interval
            events.add(new int[]{interval[1] + 1, -1}); // end of an interval
        }
        
        // Sort the events by time. If two events have the same time, process end event first.
        Collections.sort(events, (a, b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);
        
        int maxGroups = 0, currentGroups = 0;
        
        // Sweep line: process each event
        for (int[] event : events) {
            currentGroups += event[1]; // +1 for start, -1 for end
            maxGroups = Math.max(maxGroups, currentGroups);
        }
        
        return maxGroups;
    }
}
