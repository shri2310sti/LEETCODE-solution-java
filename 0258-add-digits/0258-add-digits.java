class Solution {
    public int addDigits(int num) {

        if(num < 10) return num;
        
        int temp = num;
        int sum = 0;

        while (temp > 0){
            int digit = temp % 10;
            sum += digit;
            temp /= 10;
        }
        num = sum;
        return addDigits(num);
        
    }
}