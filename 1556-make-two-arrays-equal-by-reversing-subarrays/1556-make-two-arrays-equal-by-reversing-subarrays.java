class Solution {
    public boolean canBeEqual(int[] target, int[] arr) {
        int[] freqTarget = new int[1001];
        int[] freqArr = new int[1001];
        
        // Count frequencies in target
        for (int num : target) {
            freqTarget[num]++;
        }
        
        // Count frequencies in arr
        for (int num : arr) {
            freqArr[num]++;
        }
        
        // Compare frequencies
        for (int i = 1; i <= 1000; i++) {
            if (freqTarget[i] != freqArr[i]) {
                return false;
            }
        }
        
        return true;
    }
}
