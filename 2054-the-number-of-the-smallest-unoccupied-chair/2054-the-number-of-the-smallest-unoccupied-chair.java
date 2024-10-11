import java.util.*;

class Solution {
    public int smallestChair(int[][] times, int targetFriend) {
        int n = times.length;
        
        // Create a list to store both arrival and leaving events.
        List<int[]> events = new ArrayList<>();
        
        for (int i = 0; i < n; i++) {
            events.add(new int[] {times[i][0], i, 1}); // [arrival time, friend index, type (1 for arrival)]
            events.add(new int[] {times[i][1], i, 0}); // [leaving time, friend index, type (0 for leaving)]
        }
        
        // Sort events by time. If times are equal, prioritize departures over arrivals.
        Collections.sort(events, (a, b) -> (a[0] == b[0]) ? Integer.compare(a[2], b[2]) : Integer.compare(a[0], b[0]));
        
        PriorityQueue<Integer> availableChairs = new PriorityQueue<>();
        Map<Integer, Integer> friendToChair = new HashMap<>();
        
        // Initially, all chairs are available (0 to n - 1).
        for (int i = 0; i < n; i++) {
            availableChairs.add(i);
        }
        
        for (int[] event : events) {
            int time = event[0];
            int friend = event[1];
            int type = event[2];
            
            if (type == 1) { // Arrival event
                int assignedChair = availableChairs.poll(); // Get the smallest available chair
                friendToChair.put(friend, assignedChair);
                
                if (friend == targetFriend) {
                    return assignedChair; // Return if the target friend arrives
                }
            } else { // Leaving event
                int chair = friendToChair.get(friend);
                availableChairs.add(chair); // Chair becomes available again
            }
        }
        
        return -1; // Should never reach here for valid input
    }
}
