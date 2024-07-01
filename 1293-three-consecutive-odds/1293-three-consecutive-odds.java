class Solution {
    public boolean threeConsecutiveOdds(int[] arr) {
        // Iterate through the array up to the third last element
        for (int i = 0; i <= arr.length - 3; i++) {
            // Check if the current element and the next two elements are odd
            if (arr[i] % 2 != 0 && arr[i + 1] % 2 != 0 && arr[i + 2] % 2 != 0) {
                return true; // Found three consecutive odd numbers
            }
        }
        return false; // No three consecutive odd numbers found
    }
}