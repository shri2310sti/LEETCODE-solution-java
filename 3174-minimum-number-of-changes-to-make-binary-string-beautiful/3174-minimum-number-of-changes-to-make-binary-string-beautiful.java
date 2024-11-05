class Solution {
    public int minChanges(String s) {
        int changes = 0;
        // Iterate through the string by pairs
        for (int i = 0; i < s.length(); i += 2) {
            // Check the current pair (s[i], s[i + 1])
            if (s.charAt(i) != s.charAt(i + 1)) {
                // If the characters in the pair are different, we need one change
                changes++;
            }
        }
        return changes;
    }
}
