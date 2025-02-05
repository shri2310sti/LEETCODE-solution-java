class Solution {
    public boolean areAlmostEqual(String s1, String s2) {
        if (s1.equals(s2)) return true; // If both strings are already equal, return true

        int n = s1.length();
        int first = -1, second = -1; // To store the indices of mismatched characters
        int count = 0; // Count of mismatched characters

        for (int i = 0; i < n; i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                count++;
                if (count > 2) return false; // More than two mismatches => can't be fixed with one swap
                if (first == -1) {
                    first = i; // Store first mismatch index
                } else {
                    second = i; // Store second mismatch index
                }
            }
        }

        // If there are exactly two mismatches, they must be swappable
        return count == 2 && s1.charAt(first) == s2.charAt(second) && s1.charAt(second) == s2.charAt(first);
    }
}
