/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public TreeNode balanceBST(TreeNode root) {
        // Step 1: Perform inorder traversal to get a sorted array of node values
        List<Integer> sortedValues = new ArrayList<>();
        inorderTraversal(root, sortedValues);
        
        // Step 2: Use the sorted array to build a balanced BST
        return buildBalancedBST(sortedValues, 0, sortedValues.size() - 1);
    }
    
    private void inorderTraversal(TreeNode root, List<Integer> sortedValues) {
        if (root == null) {
            return;
        }
        inorderTraversal(root.left, sortedValues);
        sortedValues.add(root.val);
        inorderTraversal(root.right, sortedValues);
    }
    
    private TreeNode buildBalancedBST(List<Integer> sortedValues, int start, int end) {
        if (start > end) {
            return null;
        }
        
        // Choose the middle element as the root
        int mid = start + (end - start) / 2;
        TreeNode node = new TreeNode(sortedValues.get(mid));
        
        // Recursively build the left and right subtrees
        node.left = buildBalancedBST(sortedValues, start, mid - 1);
        node.right = buildBalancedBST(sortedValues, mid + 1, end);
        
        return node;
    }
}
