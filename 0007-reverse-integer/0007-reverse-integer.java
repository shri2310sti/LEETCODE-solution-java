class Solution {
    public int reverse(int x) {
        int a = 0;
        while(x != 0){
            int c = x % 10;
            int b = a*10 + c;

            if(a != (b-c)/10){
                return 0;
            }

            a = b;
            x/=10;
        }
        return a;
    }
}