import java.util.*;

class Solution {
    public int countCompleteComponents(int n, int[][] edges) {
        // Adjacency list representation of the graph
        Map<Integer, Set<Integer>> graph = new HashMap<>();
        for (int i = 0; i < n; i++) {
            graph.put(i, new HashSet<>());
        }
        
        // Populate the graph with edges
        for (int[] edge : edges) {
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }

        boolean[] visited = new boolean[n];
        int completeComponents = 0;
        
        // Traverse each node
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                List<Integer> component = new ArrayList<>();
                dfs(i, graph, visited, component);
                
                // Check if the component is complete
                if (isComplete(component, graph)) {
                    completeComponents++;
                }
            }
        }
        
        return completeComponents;
    }

    private void dfs(int node, Map<Integer, Set<Integer>> graph, boolean[] visited, List<Integer> component) {
        visited[node] = true;
        component.add(node);
        
        for (int neighbor : graph.get(node)) {
            if (!visited[neighbor]) {
                dfs(neighbor, graph, visited, component);
            }
        }
    }

    private boolean isComplete(List<Integer> component, Map<Integer, Set<Integer>> graph) {
        int size = component.size();
        int expectedEdges = size * (size - 1) / 2;
        int actualEdges = 0;

        // Count edges within this component
        for (int node : component) {
            actualEdges += graph.get(node).size();
        }
        
        // Each edge is counted twice in the adjacency list
        return actualEdges / 2 == expectedEdges;
    }
}
