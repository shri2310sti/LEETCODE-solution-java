import java.util.*;

class Solution {
    public List<String> wordSubsets(String[] words1, String[] words2) {
        // Step 1: Combine constraints from words2
        int[] maxFreq = new int[26];
        for (String b : words2) {
            int[] freq = countFreq(b);
            for (int i = 0; i < 26; i++) {
                maxFreq[i] = Math.max(maxFreq[i], freq[i]);
            }
        }
        
        // Step 2: Check each word in words1
        List<String> result = new ArrayList<>();
        for (String a : words1) {
            int[] freq = countFreq(a);
            if (isUniversal(freq, maxFreq)) {
                result.add(a);
            }
        }
        
        return result;
    }
    
    // Helper function to count character frequencies in a string
    private int[] countFreq(String s) {
        int[] freq = new int[26];
        for (char c : s.toCharArray()) {
            freq[c - 'a']++;
        }
        return freq;
    }
    
    // Helper function to check if a word satisfies the combined constraints
    private boolean isUniversal(int[] freq, int[] maxFreq) {
        for (int i = 0; i < 26; i++) {
            if (freq[i] < maxFreq[i]) {
                return false;
            }
        }
        return true;
    }
}
