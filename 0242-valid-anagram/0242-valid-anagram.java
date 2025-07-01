class Solution {
    public boolean isAnagram(String s, String t) {
        //'a' to 'z' mapped to 0 to 25
        
        if (s.length() != t.length()) return false;

        int[] freq = new int[26];

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            freq[c - 'a']++; 
        }
        for (int i = 0; i < t.length(); i++) {
            char c = t.charAt(i);
            freq[c - 'a']--; 
            if (freq[c - 'a'] < 0) return false; 
        }

        return true;
    }
}
