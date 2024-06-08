class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int left = 1;  // Minimum possible eating speed
        int right = getMaxPile(piles);  // Maximum possible eating speed (largest pile)

        while (left < right) {
            int mid = left + (right - left) / 2;  // Mid-point of current bounds
            if (canEatAllBananas(piles, mid, h)) {
                right = mid;  // Try to find a slower speed if possible
            } else {
                left = mid + 1;  // Increase speed because mid is too slow
            }
        }
        
        return left;  // Minimum eating speed to finish within h hours
    }

    // Helper function to find the maximum number of bananas in a single pile
    private int getMaxPile(int[] piles) {
        int maxPile = 0;
        for (int pile : piles) {
            maxPile = Math.max(maxPile, pile);
        }
        return maxPile;
    }

    // Helper function to determine if Koko can eat all bananas with speed k in h hours
    private boolean canEatAllBananas(int[] piles, int k, int h) {
        int hoursNeeded = 0;
        for (int pile : piles) {
            hoursNeeded += (pile + k - 1) / k;  // Equivalent to Math.ceil(pile / (double)k)
            if (hoursNeeded > h) {
                return false;  // If hours exceed h, k is too slow
            }
        }
        return true;  // k is sufficient
    }
}
