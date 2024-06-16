class Solution {
    public void nextPermutation(int[] nums) {
        int n = nums.length;
        if (n <= 1) return;

        // Step 1: Find the longest non-increasing suffix
        int i = n - 2;
        while (i >= 0 && nums[i] >= nums[i + 1]) {
            i--;
        }

        // Step 2: If the entire array is non-increasing, reverse it
        if (i >= 0) {
            // Step 3: Find the successor to pivot
            int j = n - 1;
            while (nums[j] <= nums[i]) {
                j--;
            }

            // Step 4: Swap the pivot with the successor
            swap(nums, i, j);
        }

        // Step 5: Reverse the suffix
        reverse(nums, i + 1, n - 1);
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    private void reverse(int[] nums, int start, int end) {
        while (start < end) {
            swap(nums, start, end);
            start++;
            end--;
        }
    }
}
