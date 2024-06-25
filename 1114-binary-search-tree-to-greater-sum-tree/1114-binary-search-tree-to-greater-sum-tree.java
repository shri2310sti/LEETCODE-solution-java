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
    public TreeNode bstToGst(TreeNode root) {
        // Initialize the sum to 0
        int[] sum = new int[1];
        // Perform the reverse in-order traversal and update the tree
        reverseInOrderTraversal(root, sum);
        return root;
    }
    
    private void reverseInOrderTraversal(TreeNode node, int[] sum) {
        if (node == null) {
            return;
        }
        
        // Traverse the right subtree
        reverseInOrderTraversal(node.right, sum);
        
        // Update the current node's value
        sum[0] += node.val;
        node.val = sum[0];
        
        // Traverse the left subtree
        reverseInOrderTraversal(node.left, sum);
    }
}
