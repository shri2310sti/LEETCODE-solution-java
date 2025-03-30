import java.util.*;

class Solution {
    public List<Integer> partitionLabels(String s) {
        List<Integer> result = new ArrayList<>();
        int[] lastIndex = new int[26];  // To store last occurrence index of each character
        
        for (int i = 0; i < s.length(); i++) {
            lastIndex[s.charAt(i) - 'a'] = i;
        }
        
        int start = 0, maxLast = 0;
        for (int i = 0; i < s.length(); i++) {
            maxLast = Math.max(maxLast, lastIndex[s.charAt(i) - 'a']);
            
            if (i == maxLast) {
                result.add(i - start + 1);
                start = i + 1;
            }
        }
        
        return result;
    }
}
