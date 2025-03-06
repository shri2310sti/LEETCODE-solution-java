class Solution {
    public int[] findMissingAndRepeatedValues(int[][] grid) {
        int n = grid.length;
        int N = n * n;
        
        long expectedSum = (long) N * (N + 1) / 2;
        long expectedSquareSum = (long) N * (N + 1) * (2 * N + 1) / 6;
        
        long actualSum = 0, actualSquareSum = 0;
        int repeated = -1;
        HashSet<Integer> seen = new HashSet<>();
        
        // Traverse the grid
        for (int[] row : grid) {
            for (int num : row) {
                actualSum += num;
                actualSquareSum += (long) num * num;
                if (!seen.add(num)) {
                    repeated = num; // Found the repeated number
                }
            }
        }

        // Compute missing number using equations
        long diff = actualSum - expectedSum; // a - b
        long squareDiff = actualSquareSum - expectedSquareSum; // a² - b²

        int missing = (int) ((squareDiff / diff - diff) / 2);

        return new int[]{repeated, missing};
    }
}
