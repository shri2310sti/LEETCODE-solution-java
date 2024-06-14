class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        // Ensure nums1 is the smaller array
        if (nums1.length > nums2.length) {
            return findMedianSortedArrays(nums2, nums1);
        }

        int m = nums1.length;
        int n = nums2.length;
        int low = 0;
        int high = m;

        while (low <= high) {
            int i = (low + high) / 2;
            int j = (m + n + 1) / 2 - i;

            // Calculate the partitions
            int leftPart1 = (i == 0) ? Integer.MIN_VALUE : nums1[i - 1];
            int rightPart1 = (i == m) ? Integer.MAX_VALUE : nums1[i];
            int leftPart2 = (j == 0) ? Integer.MIN_VALUE : nums2[j - 1];
            int rightPart2 = (j == n) ? Integer.MAX_VALUE : nums2[j];

            // Check the partitioning conditions
            if (leftPart1 <= rightPart2 && leftPart2 <= rightPart1) {
                if ((m + n) % 2 == 0) {
                    return (Math.max(leftPart1, leftPart2) + Math.min(rightPart1, rightPart2)) / 2.0;
                } else {
                    return Math.max(leftPart1, leftPart2);
                }
            } else if (leftPart1 > rightPart2) {
                high = i - 1;
            } else {
                low = i + 1;
            }
        }

        // This should never be reached, but to make the compiler happy
        throw new IllegalArgumentException("Input arrays are not sorted.");
    }
}