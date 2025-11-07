class Solution {
    public long maxPower(int[] stations, int r, int k) {
        int n = stations.length;
        
        // Step 1: Precompute initial power using difference array
        long[] powerDiff = new long[n + 1];
        
        for (int i = 0; i < n; i++) {
            int left = Math.max(0, i - r);
            int right = Math.min(n, i + r + 1);
            powerDiff[left] += stations[i];
            powerDiff[right] -= stations[i];
        }
        
        // Step 2: Binary search for maximum minimum power
        long minInitial = Arrays.stream(stations).min().getAsInt();
        long maxPossible = Arrays.stream(stations).asLongStream().sum() + k;
        long result = 0;
        
        while (minInitial <= maxPossible) {
            long mid = minInitial + (maxPossible - minInitial) / 2;
            
            if (isFeasible(powerDiff.clone(), mid, r, k)) {
                result = mid;
                minInitial = mid + 1; // Try for higher minimum
            } else {
                maxPossible = mid - 1; // Too high, try lower
            }
        }
        
        return result;
    }
    
    private boolean isFeasible(long[] powerDiff, long targetMin, int r, int k) {
        int n = powerDiff.length - 1;
        long currentPower = 0;
        long stationsUsed = 0;
        
        for (int i = 0; i < n; i++) {
            // Add the power contribution for current position
            currentPower += powerDiff[i];
            
            // If current power is less than target, we need to add stations
            if (currentPower < targetMin) {
                long additionalNeeded = targetMin - currentPower;
                
                // Check if we have enough stations remaining
                if (stationsUsed + additionalNeeded > k) {
                    return false;
                }
                
                stationsUsed += additionalNeeded;
                
                // Add station at the farthest possible position (i + r)
                // This station will cover from i to i + 2r
                int stationPos = Math.min(n, i + 2 * r + 1);
                powerDiff[stationPos] -= additionalNeeded;
                
                // The station contributes to current and future positions
                currentPower += additionalNeeded;
            }
        }
        
        return true;
    }
}