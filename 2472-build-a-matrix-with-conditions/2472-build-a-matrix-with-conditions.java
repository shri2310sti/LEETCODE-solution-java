class Solution {
    private int size;

    // Function to construct the matrix based on given row and column conditions
    public int[][] buildMatrix(int k, int[][] rowConditions, int[][] colConditions) {
        this.size = k;
        // Determine the order of elements based on row conditions
        List<Integer> rowOrder = getOrder(rowConditions);
        // Determine the order of elements based on column conditions
        List<Integer> colOrder = getOrder(colConditions);
      
        // If we cannot satisfy either row or column conditions, return an empty matrix
        if (rowOrder == null || colOrder == null) {
            return new int[0][0];
        }
      
        // Initialize the answer matrix with zeroes
        int[][] matrix = new int[size][size];
        // Array to store the column indices for the elements in the matrix
        int[] columnMapping = new int[size + 1];
        // Map the value to its corresponding column index
        for (int i = 0; i < size; ++i) {
            columnMapping[colOrder.get(i)] = i;
        }
        // Fill the matrix with the correct values at the right positions
        for (int i = 0; i < size; ++i) {
            matrix[i][columnMapping[rowOrder.get(i)]] = rowOrder.get(i);
        }
        // Return the fully constructed matrix
        return matrix;
    }

    // Function to determine the order of elements based on conditions (edges of a directed graph)
    private List<Integer> getOrder(int[][] conditions) {
        // Graph to represent conditions
        List<Integer>[] graph = new List[size + 1];
        // Initialize lists for all vertices in the graph
        Arrays.setAll(graph, element -> new ArrayList<>());
        // Array to store the number of incoming edges (in-degree) for each vertex
        int[] incomingEdges = new int[size + 1];
      
        // Build the graph based on the conditions
        for (var edge : conditions) {
            int from = edge[0], to = edge[1];
            graph[from].add(to);
            ++incomingEdges[to];
        }
      
        // Queue to store the vertices with no incoming edges
        Deque<Integer> queue = new ArrayDeque<>();
        for (int i = 1; i <= size; ++i) {
            if (incomingEdges[i] == 0) {
                queue.offer(i);
            }
        }
      
        List<Integer> order = new ArrayList<>();
        // Process vertices in topological order
        while (!queue.isEmpty()) {
            int vertex = queue.pollFirst();
            order.add(vertex);
            // Decrease the in-degree of neighboring vertices and add to queue if they have no incoming edges left
            for (int neighbour : graph[vertex]) {
                if (--incomingEdges[neighbour] == 0) {
                    queue.offer(neighbour);
                }
            }
        }
      
        // If the size of the order list equals the size k, we successfully found an order, otherwise return null
        return order.size() == size ? order : null;
    }
}
