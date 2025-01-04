import java.util.HashSet;
import java.util.Set;

class Solution {
    public int countPalindromicSubsequence(String s) {
        int n = s.length();
        int[] leftCount = new int[26];
        int[] rightCount = new int[26];

        // Count occurrences of each character in the string
        for (int i = 0; i < n; i++) {
            rightCount[s.charAt(i) - 'a']++;
        }

        Set<String> uniquePalindromes = new HashSet<>();

        // Iterate through the string
        for (int i = 0; i < n; i++) {
            char center = s.charAt(i);
            rightCount[center - 'a']--;

            // Check for palindromes with `center` as the middle character
            for (int ch = 0; ch < 26; ch++) {
                if (leftCount[ch] > 0 && rightCount[ch] > 0) {
                    String palindrome = "" + (char) ('a' + ch) + center + (char) ('a' + ch);
                    uniquePalindromes.add(palindrome);
                }
            }

            leftCount[center - 'a']++;
        }

        return uniquePalindromes.size();
    }
}
