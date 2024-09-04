import java.util.HashSet;
import java.util.Set;

public class Solution {
    public int robotSim(int[] commands, int[][] obstacles) {
        // Directions array: [North, East, South, West]
        int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        
        // Convert obstacles to a set of strings for fast lookup
        Set<String> obstacleSet = new HashSet<>();
        for (int[] obstacle : obstacles) {
            obstacleSet.add(obstacle[0] + "," + obstacle[1]);
        }
        
        int x = 0, y = 0; // Starting position
        int directionIndex = 0; // Start facing North (index 0 in directions array)
        int maxDistance = 0;
        
        // Process each command
        for (int command : commands) {
            if (command == -1) {
                // Turn right
                directionIndex = (directionIndex + 1) % 4;
            } else if (command == -2) {
                // Turn left
                directionIndex = (directionIndex + 3) % 4;
            } else {
                // Move forward command units
                for (int i = 0; i < command; i++) {
                    int newX = x + directions[directionIndex][0];
                    int newY = y + directions[directionIndex][1];
                    
                    // Check if the new position is an obstacle
                    if (obstacleSet.contains(newX + "," + newY)) {
                        break; // Stop moving in this direction if there's an obstacle
                    }
                    
                    // Update the position
                    x = newX;
                    y = newY;
                    
                    // Update the maximum distance squared from the origin
                    maxDistance = Math.max(maxDistance, x * x + y * y);
                }
            }
        }
        
        return maxDistance;
    }
}
