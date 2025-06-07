class Solution {
    public int climbStairs(int n) {
        if (n <= 2) return n; 
        
        int prev1 = 1; // Ways to climb 1 step
        int prev2 = 2; // Ways to climb 2 steps
        int current = 0;
        
        for (int i = 3; i <= n; i++) {
            current = prev1 + prev2; // Ways to climb i steps
            prev1 = prev2;           // Shift prev2 to prev1
            prev2 = current;         // Shift current to prev2
        }
        
        return current;
    }
}