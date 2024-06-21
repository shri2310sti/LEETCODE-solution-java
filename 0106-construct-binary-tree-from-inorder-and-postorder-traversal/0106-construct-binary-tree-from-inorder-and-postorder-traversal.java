import java.util.HashMap;
import java.util.Map;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

class Solution {
    private int postorderIndex;
    private Map<Integer, Integer> inorderIndexMap;

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        postorderIndex = postorder.length - 1;
        inorderIndexMap = new HashMap<>();

        // Build a map to store value -> index relations
        for (int i = 0; i < inorder.length; i++) {
            inorderIndexMap.put(inorder[i], i);
        }

        return buildTreeRecursive(postorder, 0, inorder.length - 1);
    }

    private TreeNode buildTreeRecursive(int[] postorder, int left, int right) {
        // Base case
        if (left > right) {
            return null;
        }

        // Get the current root value from postorder traversal
        int rootValue = postorder[postorderIndex--];
        TreeNode root = new TreeNode(rootValue);

        // Recursively build the right and left subtrees
        root.right = buildTreeRecursive(postorder, inorderIndexMap.get(rootValue) + 1, right);
        root.left = buildTreeRecursive(postorder, left, inorderIndexMap.get(rootValue) - 1);

        return root;
    }
}
