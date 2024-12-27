class Solution {
    public int maxScoreSightseeingPair(int[] values) {
        int maxScore = 0;
        int maxI = values[0]; // values[i] + i for the first element

        for (int j = 1; j < values.length; j++) {
            // Calculate the score for the current pair (i, j)
            maxScore = Math.max(maxScore, maxI + values[j] - j);
            
            // Update maxI for the next iteration
            maxI = Math.max(maxI, values[j] + j);
        }

        return maxScore;
    }
}
