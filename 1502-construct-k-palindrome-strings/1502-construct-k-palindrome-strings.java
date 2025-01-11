class Solution {
    public boolean canConstruct(String s, int k) {
        // If k is greater than the length of s, it's impossible
        if (k > s.length()) {
            return false;
        }
        
        // Count the frequency of each character
        int[] charCount = new int[26];
        for (char c : s.toCharArray()) {
            charCount[c - 'a']++;
        }
        
        // Count characters with odd frequencies
        int oddCount = 0;
        for (int count : charCount) {
            if (count % 2 != 0) {
                oddCount++;
            }
        }
        
        // Check if we can construct k palindromes
        return oddCount <= k;
    }
}
