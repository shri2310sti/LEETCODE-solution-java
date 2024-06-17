class Solution {
    public int lengthOfLastWord(String s) {
        int count = 1;
        int a = s.length()-1;
        while(s.charAt(a) == ' '){
            a--;
        }
        for(int i=a-1; i>=0; i--){
            if(s.charAt(i) != ' '){
                count++;
            }
            else{
                break;
            }
        }
        return count;
    }
}