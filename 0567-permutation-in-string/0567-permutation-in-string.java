class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()) return false;

        int[] s1Count = new int[26];  // Frequency count for s1
        int[] s2Count = new int[26];  // Frequency count for s2's current window

        // Fill s1's frequency array
        for (int i = 0; i < s1.length(); i++) {
            s1Count[s1.charAt(i) - 'a']++;
            s2Count[s2.charAt(i) - 'a']++;
        }

        // Check if the initial window matches
        if (matches(s1Count, s2Count)) return true;

        // Start sliding the window
        for (int i = s1.length(); i < s2.length(); i++) {
            // Include new character in the window
            s2Count[s2.charAt(i) - 'a']++;
            // Exclude the old character from the window
            s2Count[s2.charAt(i - s1.length()) - 'a']--;

            // Check if this new window matches
            if (matches(s1Count, s2Count)) return true;
        }

        return false;
    }

    // Helper function to check if two frequency arrays are equal
    private boolean matches(int[] s1Count, int[] s2Count) {
        for (int i = 0; i < 26; i++) {
            if (s1Count[i] != s2Count[i]) {
                return false;
            }
        }
        return true;
    }
}
