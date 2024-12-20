class Solution {
    public TreeNode reverseOddLevels(TreeNode root) {
        if (root == null) return null;

        // Initialize a queue for BFS traversal
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        boolean isOddLevel = false; // Start with level 0 (not odd)

        while (!queue.isEmpty()) {
            int size = queue.size();
            List<TreeNode> levelNodes = new ArrayList<>(); // Store nodes at the current level

            // Collect all nodes at the current level
            for (int i = 0; i < size; i++) {
                TreeNode currentNode = queue.poll();
                levelNodes.add(currentNode);

                // Add child nodes to the queue
                if (currentNode.left != null) queue.offer(currentNode.left);
                if (currentNode.right != null) queue.offer(currentNode.right);
            }

            // If it's an odd level, reverse the values
            if (isOddLevel) {
                int left = 0, right = levelNodes.size() - 1;
                while (left < right) {
                    // Swap values between the left and right nodes
                    int temp = levelNodes.get(left).val;
                    levelNodes.get(left).val = levelNodes.get(right).val;
                    levelNodes.get(right).val = temp;

                    left++;
                    right--;
                }
            }

            // Toggle the level flag for the next level
            isOddLevel = !isOddLevel;
        }

        return root;
    }
}
