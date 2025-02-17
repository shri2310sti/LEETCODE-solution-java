import java.util.HashSet;

class Solution {
    public int numTilePossibilities(String tiles) {
        int[] freq = new int[26];  // Since tiles only have uppercase letters
        for (char c : tiles.toCharArray()) {
            freq[c - 'A']++;
        }
        return backtrack(freq);
    }

    private int backtrack(int[] freq) {
        int count = 0;
        for (int i = 0; i < 26; i++) {
            if (freq[i] > 0) { // If this letter is available
                count++; // Count the new sequence
                freq[i]--; // Use this letter
                count += backtrack(freq); // Recur with reduced frequency
                freq[i]++; // Backtrack (restore the frequency)
            }
        }
        return count;
    }
}
