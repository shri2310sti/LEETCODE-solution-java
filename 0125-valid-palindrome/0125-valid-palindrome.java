class Solution {
    public boolean isPalindrome(String s) {
        // Whenever you adjust pointers to skip characters, you must continue so comparison happens only after skipping is complete.
        int i=0, j=s.length()-1;
        while(i<j){
            if(!Character.isLetterOrDigit(s.charAt(i))){
                i++;
                continue;
            }
            if(!Character.isLetterOrDigit(s.charAt(j))) {
                j--;
                continue;
            }
            if(Character.toLowerCase(s.charAt(i)) != Character.toLowerCase(s.charAt(j))) return false;
            i++;
            j--;
        }
        return true;
    }
}