import java.util.*;

class Solution {
    public int findChampion(int n, int[][] edges) {
        // Step 1: Build the graph and calculate in-degrees
        List<List<Integer>> graph = new ArrayList<>();
        int[] inDegree = new int[n];
        
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        
        for (int[] edge : edges) {
            int u = edge[0], v = edge[1];
            graph.get(u).add(v);
            inDegree[v]++;
        }
        
        // Step 2: Check for nodes with in-degree 0 (no incoming edges)
        int championCount = 0;
        int champion = -1;
        
        for (int i = 0; i < n; i++) {
            if (inDegree[i] == 0) {
                if (championCount == 0) {
                    champion = i;
                }
                championCount++;
            }
        }
        
        // If there's not exactly one node with no incoming edges, return -1
        if (championCount != 1) {
            return -1;
        }
        
        // Step 3: Return the champion (the node with no incoming edges)
        return champion;
    }
}
