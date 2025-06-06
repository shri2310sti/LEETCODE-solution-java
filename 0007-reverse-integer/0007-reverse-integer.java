class Solution {
    public int reverse(int x) {
        int temp = x;
        int rev = 0;

        while (temp != 0){
            int digit = temp % 10;
            if(rev < Integer.MIN_VALUE/10 || rev > Integer.MAX_VALUE/10) return 0;
            rev = 10 * rev + digit;
            temp /= 10;
            
        }
        return rev;
    }
}