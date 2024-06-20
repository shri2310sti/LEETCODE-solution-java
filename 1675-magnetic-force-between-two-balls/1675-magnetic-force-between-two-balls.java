class Solution {
    public int maxDistance(int[] position, int m) {
        // Sort the positions of the baskets
        Arrays.sort(position);
        
        // Define the search space for the minimum magnetic force
        int left = 1;
        int right = position[position.length - 1] - position[0];
        int result = 0;
        
        // Binary search for the maximum minimum magnetic force
        while (left <= right) {
            int mid = left + (right - left) / 2;
            
            if (canPlaceBalls(position, m, mid)) {
                result = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        
        return result;
    }
    
    private boolean canPlaceBalls(int[] position, int m, int minForce) {
        // Place the first ball at the first position
        int count = 1;
        int lastPosition = position[0];
        
        // Try to place the remaining m-1 balls
        for (int i = 1; i < position.length; i++) {
            if (position[i] - lastPosition >= minForce) {
                count++;
                lastPosition = position[i];
                if (count == m) {
                    return true;
                }
            }
        }
        
        return false;
    }
}
