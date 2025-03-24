import java.util.Arrays;

class Solution {
    public int countDays(int days, int[][] meetings) {
        Arrays.sort(meetings, (a, b) -> Integer.compare(a[0], b[0])); // Sort by start day
        
        int totalMeetingDays = 0, prevEnd = 0;
        
        for (int[] meeting : meetings) {
            int start = meeting[0], end = meeting[1];
            
            if (start > prevEnd + 1) { 
                totalMeetingDays += end - start + 1; // Count new meeting days
            } else if (end > prevEnd) {
                totalMeetingDays += end - prevEnd; // Extend the last merged meeting
            }
            
            prevEnd = Math.max(prevEnd, end);
        }
        
        return days - totalMeetingDays;
    }
}
