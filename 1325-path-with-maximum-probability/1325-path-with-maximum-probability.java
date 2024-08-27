import java.util.*;

class Solution {
    public double maxProbability(int n, int[][] edges, double[] succProb, int start, int end) {
        // Create adjacency list
        Map<Integer, List<Pair>> graph = new HashMap<>();
        for (int i = 0; i < n; i++) {
            graph.put(i, new ArrayList<>());
        }
        for (int i = 0; i < edges.length; i++) {
            int u = edges[i][0];
            int v = edges[i][1];
            double prob = succProb[i];
            graph.get(u).add(new Pair(v, prob));
            graph.get(v).add(new Pair(u, prob));
        }

        // Max-heap to store the probability of reaching each node
        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> Double.compare(b.prob, a.prob));
        pq.offer(new Pair(start, 1.0));
        
        // Probability array to keep track of max probability to reach each node
        double[] maxProb = new double[n];
        maxProb[start] = 1.0;
        
        while (!pq.isEmpty()) {
            Pair current = pq.poll();
            int node = current.node;
            double prob = current.prob;
            
            if (node == end) {
                return prob;
            }
            
            // Explore neighbors
            for (Pair neighbor : graph.get(node)) {
                int nextNode = neighbor.node;
                double nextProb = neighbor.prob;
                // If we found a higher probability to reach nextNode
                if (maxProb[nextNode] < prob * nextProb) {
                    maxProb[nextNode] = prob * nextProb;
                    pq.offer(new Pair(nextNode, maxProb[nextNode]));
                }
            }
        }
        
        return 0.0; // If we don't reach the end node
    }
    
    // Helper class to represent a node and its probability
    class Pair {
        int node;
        double prob;
        
        Pair(int node, double prob) {
            this.node = node;
            this.prob = prob;
        }
    }
}
