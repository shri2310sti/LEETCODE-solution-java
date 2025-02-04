class Solution {
    public int fib(int n) {
        int a = 1, b = 1;
        int next = 0;

        if(n == 1 || n ==2){
            return 1;
        }
        for(int i = 3; i<=n; i++){
            next = a + b;
            a = b;
            b = next;
        }
        return next;
    }
}