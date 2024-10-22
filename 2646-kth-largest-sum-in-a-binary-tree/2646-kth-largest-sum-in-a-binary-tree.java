import java.util.*;

public class Solution {
    public long kthLargestLevelSum(TreeNode root, int k) {
        if (root == null) {
            return -1; // If the tree is empty
        }

        // List to store sums of each level
        List<Long> levelSums = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        // Perform level order traversal
        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            long levelSum = 0;

            for (int i = 0; i < levelSize; i++) {
                TreeNode node = queue.poll();
                levelSum += node.val;

                // Add child nodes to the queue for the next level
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
            levelSums.add(levelSum); // Store the sum of the current level
        }

        // Sort the level sums in descending order
        Collections.sort(levelSums, Collections.reverseOrder());

        // Check if we have enough levels
        if (k > levelSums.size()) {
            return -1; // Not enough levels
        }

        // Return the kth largest level sum
        return levelSums.get(k - 1); // k is 1-indexed
    }
}
