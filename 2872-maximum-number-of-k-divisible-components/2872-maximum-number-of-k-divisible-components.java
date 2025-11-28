class Solution {
    private int answer;  // Renamed 'ans' to 'answer' for better readability
    private List<Integer>[] graph; // Renamed 'g' to 'graph' to clarify this represents a graph
    private int[] nodeValues; // Renamed 'values' to 'nodeValues' to avoid confusion with the method parameter 'values'
    private int divisor; // Renamed 'k' to 'divisor' for clarity

    // Method to find the maximum number of components divisible by 'k'
    public int maxKDivisibleComponents(int n, int[][] edges, int[] values, int k) {
        this.graph = new List[n]; // Initialize the graph as a list of integer lists
        Arrays.setAll(this.graph, i -> new ArrayList<>()); // Create an adjacency list for each node i
      
        // Add edges to the graph to represent the bidirectional relationships between nodes
        for (int[] edge : edges) {
            int nodeFrom = edge[0], nodeTo = edge[1];
            graph[nodeFrom].add(nodeTo);
            graph[nodeTo].add(nodeFrom);
        }

        this.nodeValues = values; // Assign the provided node values to the instance variable
        this.divisor = k; // Store the divisor as an instance variable
      
        dfs(0, -1); // Invoke the depth-first search from the root node (assuming node 0 as root)
        return answer; // Return the total number of components with sum divisible by 'k'
    }

    // Depth-first search to find the components with sum of values divisible by 'k'
    private long dfs(int nodeIndex, int parentIndex) {
        long sum = nodeValues[nodeIndex]; // Start with the node's own value
        // Recursively visit all the connected nodes (children) that are not the parent
        for (int adjacentNode : graph[nodeIndex]) {
            if (adjacentNode != parentIndex) {
                sum += dfs(adjacentNode, nodeIndex); // Add the sum of the subtree to the current node's sum
            }
        }
        // If the sum is divisible by 'k', increment the answer
        if (sum % divisor == 0) {
            answer++;
        }
        return sum; // Return the sum of the node values in the subtree rooted at this node
    }
}