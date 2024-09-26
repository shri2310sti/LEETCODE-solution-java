import java.util.ArrayList;
import java.util.List;

class MyCalendar {
    private List<int[]> events;

    public MyCalendar() {
        events = new ArrayList<>();
    }
    
    public boolean book(int start, int end) {
        // Check for overlap with all existing events
        for (int[] event : events) {
            int existingStart = event[0];
            int existingEnd = event[1];
            
            // Check if the new event overlaps with the current event
            if (Math.max(start, existingStart) < Math.min(end, existingEnd)) {
                return false;  // There is an overlap, booking fails
            }
        }
        
        // If no overlap, add the event to the list
        events.add(new int[]{start, end});
        return true;
    }
}

/**
 * Your MyCalendar object will be instantiated and called as such:
 * MyCalendar obj = new MyCalendar();
 * boolean param_1 = obj.book(start,end);
 */
