class Solution {
    public int findCenter(int[][] edges) {
        // Check the first two edges and find the common node
        if (edges[0][0] == edges[1][0] || edges[0][0] == edges[1][1]) {
            return edges[0][0];
        } else {
            return edges[0][1];
        }
    }
}
