class Solution {
    public int lengthOfLongestSubstring(String s) {

        Stack<Character> st = new Stack<>();
        int maxLen = 0;

        for(int i=0; i<s.length(); i++){

            if(st.contains(s.charAt(i))){
                while(st.contains(s.charAt(i))){
                    st.remove(0);
                }
            }
            st.push(s.charAt(i));
            maxLen = Math.max(maxLen, st.size());
            
        }
        return maxLen;
    }
}