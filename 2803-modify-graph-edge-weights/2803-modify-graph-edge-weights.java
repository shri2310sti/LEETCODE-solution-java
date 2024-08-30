import java.util.Arrays; // Import necessary for Arrays.fill and other array operations

class Solution {
    // Use a large number to represent infinity for comparison purposes
    private static final int INFINITY = 2000000000;

    // Method to modify graph edges based on the provided conditions
    public int[][] modifiedGraphEdges(int n, int[][] edges, int source, int destination, int target) {
        // First run dijkstra to find the current shortest path distance
        long dist = dijkstra(edges, n, source, destination);
      
        // Check if the current distance is less than the target
        if (dist < target) {
            return new int[0][];
        }
      
        // Flag to indicate if the target distance has been met or surpassed
        boolean targetMet = dist == target;
      
        // Iterate through each edge to adjust weights
        for (int[] edge : edges) {
            if (edge[2] > 0) { // Skip if the weight is already positive
                continue;
            }
            if (targetMet) { // If the target distance has been met, set weight to INFINITY
                edge[2] = INFINITY;
                continue;
            }
            // Set edge weight to 1 and re-run dijkstra
            edge[2] = 1;
            dist = dijkstra(edges, n, source, destination);
          
            // Check if the updated distance meets or exceeds the target
            if (dist <= target) {
                targetMet = true; // Update the flag
                // Increase the weight to set the distance exactly to target
                edge[2] += target - dist;
            }
        }
      
        // Return the edges array if the target distance has been met, otherwise empty array
        return targetMet ? edges : new int[0][];
    }

    // Dijkstra algorithm to find the shortest path in a graph
    private long dijkstra(int[][] edges, int n, int src, int dest) {
        int[][] graph = new int[n][n]; // Representation of graph as adjacency matrix
        long[] distances = new long[n]; // Distances array to store minimum distance to each vertex
        Arrays.fill(distances, INFINITY); // Initialize distances with infinity
        distances[src] = 0; // Distance to source is 0
      
        // Initialize graph with INFINITY weights
        for (int[] row : graph) {
            Arrays.fill(row, INFINITY);
        }
      
        // Fill in edges with weights into graph matrix
        for (int[] edge : edges) {
            int from = edge[0];
            int to = edge[1];
            int weight = edge[2];
            if (weight == -1) continue; // Skip edges with weight -1
            graph[from][to] = weight; // Undirected graph: use same weight for both directions
            graph[to][from] = weight;
        }
      
        boolean[] visited = new boolean[n]; // Track visited vertices
      
        // Dijkstra's algorithm implementation to update distances
        for (int i = 0; i < n; ++i) {
            int closestVertex = -1;
            // Find the unvisited vertex with the smallest distance
            for (int j = 0; j < n; ++j) {
                if (!visited[j] && (closestVertex == -1 || distances[closestVertex] > distances[j])) {
                    closestVertex = j;
                }
            }
            // Mark the closest vertex as visited
            visited[closestVertex] = true;
            // Update distances to all unvisited vertices if a shorter path is found
            for (int j = 0; j < n; ++j) {
                distances[j] = Math.min(distances[j], distances[closestVertex] + graph[closestVertex][j]);
            }
        }
        // Return the distance to the destination vertex
        return distances[dest];
    }
}
