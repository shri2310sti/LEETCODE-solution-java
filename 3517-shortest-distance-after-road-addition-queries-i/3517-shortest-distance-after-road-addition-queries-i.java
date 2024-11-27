import java.util.*;

class Solution {
    public int[] shortestDistanceAfterQueries(int n, int[][] queries) {
        // Initialize the adjacency list
        List<List<int[]>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        
        // Add initial roads (from city i to city i+1)
        for (int i = 0; i < n - 1; i++) {
            graph.get(i).add(new int[]{i + 1, 1});
        }
        
        // Result array
        int[] answer = new int[queries.length];
        
        // Process each query
        for (int q = 0; q < queries.length; q++) {
            int u = queries[q][0];
            int v = queries[q][1];
            
            // Add the new road to the graph
            graph.get(u).add(new int[]{v, 1});
            
            // Find the shortest path from 0 to n-1
            answer[q] = dijkstra(graph, n, 0, n - 1);
        }
        
        return answer;
    }
    
    private int dijkstra(List<List<int[]>> graph, int n, int start, int end) {
        // Min-heap priority queue for Dijkstra's algorithm
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(a[1], b[1]));
        pq.offer(new int[]{start, 0});
        
        // Distance array
        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[start] = 0;
        
        // Dijkstra's algorithm
        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            int node = curr[0];
            int currDist = curr[1];
            
            if (node == end) {
                return currDist;
            }
            
            for (int[] neighbor : graph.get(node)) {
                int nextNode = neighbor[0];
                int weight = neighbor[1];
                if (currDist + weight < dist[nextNode]) {
                    dist[nextNode] = currDist + weight;
                    pq.offer(new int[]{nextNode, dist[nextNode]});
                }
            }
        }
        
        return dist[end];
    }
}
