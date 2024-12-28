class Solution {
    public int[] maxSumOfThreeSubarrays(int[] nums, int k) {
        int n = nums.length;
        int[] windowSums = new int[n - k + 1];
        int[] left = new int[n - k + 1];
        int[] right = new int[n - k + 1];
        int[] result = new int[3];

        // Calculate the sum of each window of size k
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += nums[i];
            if (i >= k - 1) {
                windowSums[i - k + 1] = sum;
                sum -= nums[i - k + 1];
            }
        }

        // Left array: Best starting index for subarray [0, i]
        int bestLeft = 0;
        for (int i = 0; i < windowSums.length; i++) {
            if (windowSums[i] > windowSums[bestLeft]) {
                bestLeft = i;
            }
            left[i] = bestLeft;
        }

        // Right array: Best starting index for subarray [i, n-1]
        int bestRight = windowSums.length - 1;
        for (int i = windowSums.length - 1; i >= 0; i--) {
            if (windowSums[i] >= windowSums[bestRight]) {
                bestRight = i;
            }
            right[i] = bestRight;
        }

        // Find the best combination of left, middle, and right
        int maxSum = 0;
        for (int mid = k; mid < windowSums.length - k; mid++) {
            int l = left[mid - k];
            int r = right[mid + k];
            int total = windowSums[l] + windowSums[mid] + windowSums[r];
            if (total > maxSum) {
                maxSum = total;
                result[0] = l;
                result[1] = mid;
                result[2] = r;
            }
        }

        return result;
    }
}
