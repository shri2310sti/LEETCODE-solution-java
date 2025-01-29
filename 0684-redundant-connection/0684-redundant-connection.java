class Solution {
    private int[] parent;

    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;
        parent = new int[n + 1];

        // Initialize each node as its own parent
        for (int i = 1; i <= n; i++) {
            parent[i] = i;
        }

        // Process edges
        for (int[] edge : edges) {
            if (!union(edge[0], edge[1])) {
                return edge; // The redundant edge forming a cycle
            }
        }

        return new int[0]; // Should never reach here as per constraints
    }

    // Find function with path compression
    private int find(int node) {
        if (parent[node] != node) {
            parent[node] = find(parent[node]); // Path compression
        }
        return parent[node];
    }

    // Union function
    private boolean union(int u, int v) {
        int rootU = find(u);
        int rootV = find(v);
        if (rootU == rootV) {
            return false; // Cycle detected
        }
        parent[rootU] = rootV; // Merge sets
        return true;
    }
}
