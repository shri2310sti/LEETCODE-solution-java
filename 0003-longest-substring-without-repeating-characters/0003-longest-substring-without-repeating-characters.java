class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        int maxlength = 0;
        for(int i=0; i<s.length(); i++){
            int hash[] = new int[256];
            for(int j=i; j<s.length(); j++){
                if(hash[s.charAt(j)] == 1) break;
                int len = j-i+1;
                maxlength = Math.max(len, maxlength);
                hash[s.charAt(j)] = 1;
            }
        }
        return maxlength;
    }
}