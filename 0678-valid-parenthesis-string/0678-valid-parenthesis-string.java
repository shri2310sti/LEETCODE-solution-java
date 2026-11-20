class Solution {
    public boolean checkValidString(String s) {
        int n = s.length();
        int min = 0, max = 0;
        for(int idx=0; idx<n; idx++){
            if(s.charAt(idx) == '('){
                min++; max++;
            }
            else if(s.charAt(idx) == ')'){
                min--; max--;
            }
            else {
                min--; max++;
            }
            if(min < 0) min = 0;
            if(max < 0) return false;
        }
        return min == 0;
    }

}