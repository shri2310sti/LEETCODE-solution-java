import java.util.*;

class Solution {
    public int findMinDifference(List<String> timePoints) {
        // List to store time in minutes
        List<Integer> minutes = new ArrayList<>();
        
        // Convert each time into minutes from "00:00"
        for (String time : timePoints) {
            String[] parts = time.split(":");
            int hours = Integer.parseInt(parts[0]);
            int mins = Integer.parseInt(parts[1]);
            minutes.add(hours * 60 + mins);
        }
        
        // Sort the time points
        Collections.sort(minutes);
        
        // Initialize the minimum difference as a large number
        int minDiff = Integer.MAX_VALUE;
        
        // Calculate the minimum difference between consecutive time points
        for (int i = 1; i < minutes.size(); i++) {
            minDiff = Math.min(minDiff, minutes.get(i) - minutes.get(i - 1));
        }
        
        // Check the circular difference (from the last time to the first time)
        int circularDiff = 1440 - (minutes.get(minutes.size() - 1) - minutes.get(0));
        minDiff = Math.min(minDiff, circularDiff);
        
        return minDiff;
    }
}
