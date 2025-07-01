class Solution {
    public boolean rotateString(String s, String goal) {
        // Any rotation of s will be a substring of s + s.

        if(s.length() != goal.length()) return false;
       
        return (s+s).contains(goal);
    }
}