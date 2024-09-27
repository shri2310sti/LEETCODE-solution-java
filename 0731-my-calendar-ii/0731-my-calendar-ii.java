import java.util.ArrayList;
import java.util.List;

class MyCalendarTwo {
    List<int[]> events;
    List<int[]> overlaps;

    public MyCalendarTwo() {
        events = new ArrayList<>();
        overlaps = new ArrayList<>();
    }
    
    public boolean book(int start, int end) {
        // Check for triple booking by seeing if the new event overlaps with an already double-booked time.
        for (int[] overlap : overlaps) {
            if (Math.max(start, overlap[0]) < Math.min(end, overlap[1])) {
                // There is an overlap, so it would cause a triple booking.
                return false;
            }
        }
        
        // Check for overlaps with the existing single bookings and update the overlaps list.
        for (int[] event : events) {
            int overlapStart = Math.max(start, event[0]);
            int overlapEnd = Math.min(end, event[1]);
            if (overlapStart < overlapEnd) {
                overlaps.add(new int[]{overlapStart, overlapEnd});
            }
        }
        
        // If no triple booking, add the event to the events list.
        events.add(new int[]{start, end});
        return true;
    }
}

/**
 * Your MyCalendarTwo object will be instantiated and called as such:
 * MyCalendarTwo obj = new MyCalendarTwo();
 * boolean param_1 = obj.book(start,end);
 */
