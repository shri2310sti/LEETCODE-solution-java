class Solution {
    public boolean isPalindrome(int x) {
        int temp = x;
        int rev = 0;
        boolean result = false;
        while(temp>0){
            int digit = temp % 10;
            rev = rev*10 + digit;
            temp /= 10;
        }
        
        if(x == rev){
            result = true;
        }

        return result;
    }
}