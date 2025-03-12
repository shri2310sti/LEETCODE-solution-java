class Solution {
    public int maximumCount(int[] nums) {
        int negCount = findFirstPositive(nums);
        int posCount = nums.length - findFirstNonPositive(nums);
        return Math.max(negCount, posCount);
    }

    private int findFirstPositive(int[] nums) {
        int left = 0, right = nums.length;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < 0) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }

    private int findFirstNonPositive(int[] nums) {
        int left = 0, right = nums.length;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] <= 0) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }
}
