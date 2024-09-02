class Solution {
    public int chalkReplacer(int[] chalk, int k) {
        // Step 1: Calculate the total chalk required in one complete round.
        long totalChalk = 0;
        for (int c : chalk) {
            totalChalk += c;
        }
        
        // Step 2: Reduce k using modulus to find the remainder after full rounds.
        k %= totalChalk;
        
        // Step 3: Find the student who will replace the chalk.
        for (int i = 0; i < chalk.length; i++) {
            if (k < chalk[i]) {
                return i;
            }
            k -= chalk[i];
        }
        
        // The function should always return within the loop, but we return -1 as a fallback.
        return -1;
    }
}
