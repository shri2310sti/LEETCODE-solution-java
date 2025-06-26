class Solution {
    public int longestSubsequence(String s, int k) {
        int longestLength = 0; 
        int decimalValue = 0;  
        
        for (int index = s.length() - 1; index >= 0; --index) {
            
            if (s.charAt(index) == '0') {
                ++longestLength;
            }
            
            else if (longestLength < 30 && (decimalValue | (1 << longestLength)) <= k) {
                
                decimalValue |= 1 << longestLength;
                ++longestLength;
            }
        }
        return longestLength; 
    }
}
