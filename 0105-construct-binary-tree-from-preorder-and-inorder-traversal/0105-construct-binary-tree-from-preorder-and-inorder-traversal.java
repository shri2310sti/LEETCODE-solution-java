import java.util.HashMap;
import java.util.Map;

class Solution {
    private int preorderIndex;
    private Map<Integer, Integer> inorderIndexMap;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        preorderIndex = 0;
        inorderIndexMap = new HashMap<>();

        // Build a map to store value -> index relations
        for (int i = 0; i < inorder.length; i++) {
            inorderIndexMap.put(inorder[i], i);
        }

        return buildTreeRecursive(preorder, 0, inorder.length - 1);
    }

    private TreeNode buildTreeRecursive(int[] preorder, int left, int right) {
        // Base case
        if (left > right) {
            return null;
        }

        // Get the current root value from preorder traversal
        int rootValue = preorder[preorderIndex++];
        TreeNode root = new TreeNode(rootValue);

        // Recursively build the left and right subtrees
        root.left = buildTreeRecursive(preorder, left, inorderIndexMap.get(rootValue) - 1);
        root.right = buildTreeRecursive(preorder, inorderIndexMap.get(rootValue) + 1, right);

        return root;
    }
}
