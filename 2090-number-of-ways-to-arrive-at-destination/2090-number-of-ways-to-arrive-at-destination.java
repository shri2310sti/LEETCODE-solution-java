import java.util.*;

class Solution {
    public int countPaths(int n, int[][] roads) {
        final int MOD = 1_000_000_007;
        
        // Adjacency list representation of the graph
        List<List<int[]>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        
        // Populate the graph
        for (int[] road : roads) {
            int u = road[0], v = road[1], time = road[2];
            graph.get(u).add(new int[]{v, time});
            graph.get(v).add(new int[]{u, time});
        }
        
        // Min-heap for Dijkstra's Algorithm (time, node)
        PriorityQueue<long[]> pq = new PriorityQueue<>(Comparator.comparingLong(a -> a[0]));
        pq.offer(new long[]{0, 0}); // (time, node)
        
        // Distance and ways arrays
        long[] dist = new long[n];
        Arrays.fill(dist, Long.MAX_VALUE);
        dist[0] = 0;
        
        int[] ways = new int[n];
        ways[0] = 1;
        
        while (!pq.isEmpty()) {
            long[] top = pq.poll();
            long time = top[0];
            int node = (int) top[1];
            
            if (time > dist[node]) continue; // Skip outdated entries
            
            for (int[] neighbor : graph.get(node)) {
                int nextNode = neighbor[0];
                long travelTime = neighbor[1];
                
                long newDist = time + travelTime;
                
                if (newDist < dist[nextNode]) {
                    dist[nextNode] = newDist;
                    ways[nextNode] = ways[node];
                    pq.offer(new long[]{newDist, nextNode});
                } else if (newDist == dist[nextNode]) {
                    ways[nextNode] = (ways[nextNode] + ways[node]) % MOD;
                }
            }
        }
        
        return ways[n - 1];
    }
}
