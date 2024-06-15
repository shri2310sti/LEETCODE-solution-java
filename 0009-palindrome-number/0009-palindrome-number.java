class Solution {
    public boolean isPalindrome(int x) {
        int a = 0;
        int b = x;

        while(x>0){
            int c = x%10;
            a = a*10 + c;
            x = x/10;
        }

        if(a == b){
            return true;
        }

        return false;
        
    }
}