import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<Boolean> checkIfPrerequisite(int numCourses, int[][] prerequisites, int[][] queries) {
        // Initialize the reachability matrix
        boolean[][] reachable = new boolean[numCourses][numCourses];
        
        // Mark direct prerequisites
        for (int[] prerequisite : prerequisites) {
            reachable[prerequisite[0]][prerequisite[1]] = true;
        }
        
        // Apply Floyd-Warshall algorithm to compute transitive closure
        for (int k = 0; k < numCourses; k++) {
            for (int i = 0; i < numCourses; i++) {
                for (int j = 0; j < numCourses; j++) {
                    reachable[i][j] = reachable[i][j] || (reachable[i][k] && reachable[k][j]);
                }
            }
        }
        
        // Prepare the result for each query
        List<Boolean> result = new ArrayList<>();
        for (int[] query : queries) {
            result.add(reachable[query[0]][query[1]]);
        }
        
        return result;
    }
}
