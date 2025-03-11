class Solution {
    public int numberOfSubstrings(String s) {
        int[] count = {0, 0, 0}; // To track counts of 'a', 'b', and 'c'
        int left = 0, res = 0, n = s.length();

        for (int right = 0; right < n; right++) {
            count[s.charAt(right) - 'a']++;

            // Shrink the window when all 'a', 'b', and 'c' are present
            while (count[0] > 0 && count[1] > 0 && count[2] > 0) {
                res += n - right; // All substrings from 'left' to 'right' contribute
                count[s.charAt(left) - 'a']--;
                left++;
            }
        }

        return res;
    }
}
