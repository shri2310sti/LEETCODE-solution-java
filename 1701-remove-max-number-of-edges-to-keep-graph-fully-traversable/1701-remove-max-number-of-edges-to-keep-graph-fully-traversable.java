class Solution {
    public int maxNumEdgesToRemove(int n, int[][] edges) {
        UnionFind alice = new UnionFind(n);
        UnionFind bob = new UnionFind(n);
        UnionFind common = new UnionFind(n);
        
        int removableEdges = 0;
        
        // First, use all type 3 edges (usable by both Alice and Bob)
        for (int[] edge : edges) {
            if (edge[0] == 3) {
                if (common.union(edge[1] - 1, edge[2] - 1)) {
                    alice.union(edge[1] - 1, edge[2] - 1);
                    bob.union(edge[1] - 1, edge[2] - 1);
                } else {
                    removableEdges++;
                }
            }
        }
        
        // Use type 1 edges (usable by Alice only)
        for (int[] edge : edges) {
            if (edge[0] == 1) {
                if (!alice.union(edge[1] - 1, edge[2] - 1)) {
                    removableEdges++;
                }
            }
        }
        
        // Use type 2 edges (usable by Bob only)
        for (int[] edge : edges) {
            if (edge[0] == 2) {
                if (!bob.union(edge[1] - 1, edge[2] - 1)) {
                    removableEdges++;
                }
            }
        }
        
        // Check if Alice and Bob can fully traverse the graph
        if (alice.getComponentCount() > 1 || bob.getComponentCount() > 1) {
            return -1;
        }
        
        return removableEdges;
    }
}

class UnionFind {
    private int[] parent;
    private int[] rank;
    private int componentCount;
    
    public UnionFind(int n) {
        parent = new int[n];
        rank = new int[n];
        componentCount = n;
        for (int i = 0; i < n; i++) {
            parent[i] = i;
            rank[i] = 0;
        }
    }
    
    public int find(int x) {
        if (parent[x] != x) {
            parent[x] = find(parent[x]);
        }
        return parent[x];
    }
    
    public boolean union(int x, int y) {
        int rootX = find(x);
        int rootY = find(y);
        
        if (rootX != rootY) {
            if (rank[rootX] > rank[rootY]) {
                parent[rootY] = rootX;
            } else if (rank[rootX] < rank[rootY]) {
                parent[rootX] = rootY;
            } else {
                parent[rootY] = rootX;
                rank[rootX]++;
            }
            componentCount--;
            return true;
        }
        return false;
    }
    
    public int getComponentCount() {
        return componentCount;
    }
}
