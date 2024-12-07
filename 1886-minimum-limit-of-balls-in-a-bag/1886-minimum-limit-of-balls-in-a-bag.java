class Solution {
    public int minimumSize(int[] nums, int maxOperations) {
        int left = 1; // Minimum possible penalty
        int right = 0; // Maximum possible penalty
        for (int num : nums) {
            right = Math.max(right, num);
        }

        while (left < right) {
            int mid = left + (right - left) / 2;
            if (canAchievePenalty(nums, mid, maxOperations)) {
                right = mid; // Try for a smaller penalty
            } else {
                left = mid + 1; // Increase the penalty
            }
        }
        return left;
    }

    private boolean canAchievePenalty(int[] nums, int penalty, int maxOperations) {
        int operations = 0;
        for (int num : nums) {
            // Count how many operations are needed to make num <= penalty
            operations += (num - 1) / penalty;
            if (operations > maxOperations) {
                return false; // Exceeded the allowed operations
            }
        }
        return true;
    }
}
