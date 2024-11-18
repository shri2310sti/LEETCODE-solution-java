class Solution {
    public int[] decrypt(int[] code, int k) {
        int n = code.length;
        int[] result = new int[n];
        
        if (k == 0) {
            // Case when k == 0, all elements are replaced with 0
            return result; // An array initialized with 0 by default
        }
        
        for (int i = 0; i < n; i++) {
            int sum = 0;
            if (k > 0) {
                // Sum the next k numbers
                for (int j = 1; j <= k; j++) {
                    sum += code[(i + j) % n];
                }
            } else {
                // Sum the previous -k numbers
                for (int j = 1; j <= -k; j++) {
                    sum += code[(i - j + n) % n];
                }
            }
            result[i] = sum;
        }
        
        return result;
    }
}
