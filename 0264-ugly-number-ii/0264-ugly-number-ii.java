class Solution {
    public int nthUglyNumber(int n) {
        int[] ugly = new int[n];
        ugly[0] = 1; // The first ugly number is 1
        
        int i2 = 0, i3 = 0, i5 = 0;
        int next_ugly_2 = 2;
        int next_ugly_3 = 3;
        int next_ugly_5 = 5;
        
        for (int i = 1; i < n; i++) {
            int nextUgly = Math.min(next_ugly_2, Math.min(next_ugly_3, next_ugly_5));
            ugly[i] = nextUgly;
            
            if (nextUgly == next_ugly_2) {
                i2++;
                next_ugly_2 = ugly[i2] * 2;
            }
            if (nextUgly == next_ugly_3) {
                i3++;
                next_ugly_3 = ugly[i3] * 3;
            }
            if (nextUgly == next_ugly_5) {
                i5++;
                next_ugly_5 = ugly[i5] * 5;
            }
        }
        
        return ugly[n - 1]; // The nth ugly number
    }
}
