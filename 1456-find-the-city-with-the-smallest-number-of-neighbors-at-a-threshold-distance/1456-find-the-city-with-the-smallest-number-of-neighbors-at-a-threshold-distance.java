class Solution {
    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        // Initialize the graph as an adjacency matrix
        int[][] graph = new int[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(graph[i], 10001); // Use 10001 as a large number (greater than max weight)
            graph[i][i] = 0;
        }
        
        // Populate the graph with edges
        for (int[] edge : edges) {
            int from = edge[0], to = edge[1], weight = edge[2];
            graph[from][to] = weight;
            graph[to][from] = weight;
        }
        
        // Apply Floyd-Warshall algorithm
        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (graph[i][k] + graph[k][j] < graph[i][j]) {
                        graph[i][j] = graph[i][k] + graph[k][j];
                    }
                }
            }
        }
        
        // Find the city with the smallest number of reachable cities within distanceThreshold
        int cityWithFewestReachable = -1;
        int minReachableCities = Integer.MAX_VALUE;
        
        for (int i = 0; i < n; i++) {
            int reachableCount = 0;
            for (int j = 0; j < n; j++) {
                if (i != j && graph[i][j] <= distanceThreshold) {
                    reachableCount++;
                }
            }
            if (reachableCount <= minReachableCities) {
                if (reachableCount == minReachableCities && i > cityWithFewestReachable) {
                    cityWithFewestReachable = i;
                } else if (reachableCount < minReachableCities) {
                    cityWithFewestReachable = i;
                    minReachableCities = reachableCount;
                }
            }
        }
        
        return cityWithFewestReachable;
    }
}
