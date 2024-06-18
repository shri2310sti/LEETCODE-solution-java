import java.util.Arrays;

class Solution {
    public int maxProfitAssignment(int[] difficulty, int[] profit, int[] worker) {
        int n = difficulty.length;
        int[][] jobs = new int[n][2];
        
        // Combine difficulty and profit into jobs array
        for (int i = 0; i < n; i++) {
            jobs[i][0] = difficulty[i];
            jobs[i][1] = profit[i];
        }
        
        // Sort jobs by difficulty
        Arrays.sort(jobs, (a, b) -> a[0] - b[0]);
        
        // Sort workers by their ability
        Arrays.sort(worker);
        
        int maxProfit = 0;
        int totalProfit = 0;
        int jobIndex = 0;
        
        for (int ability : worker) {
            // While current job difficulty is less than or equal to worker's ability
            while (jobIndex < n && jobs[jobIndex][0] <= ability) {
                maxProfit = Math.max(maxProfit, jobs[jobIndex][1]);
                jobIndex++;
            }
            // Add the maximum profit possible for this worker
            totalProfit += maxProfit;
        }
        
        return totalProfit;
    }
}
