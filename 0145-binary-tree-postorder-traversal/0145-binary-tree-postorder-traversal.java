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

import java.util.*;

class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) return result;

        Deque<TreeNode> stack = new ArrayDeque<>();
        TreeNode current = root;
        TreeNode lastVisited = null;

        while (current != null || !stack.isEmpty()) {
            // Traverse to the leftmost node
            while (current != null) {
                stack.push(current);
                current = current.left;
            }

            // Peek the node at the top of the stack
            current = stack.peek();

            // If the right child is null or already processed, process the current node
            if (current.right == null || current.right == lastVisited) {
                result.add(current.val);
                stack.pop();
                lastVisited = current;
                current = null; // set current to null to avoid revisiting
            } else {
                // Otherwise, traverse the right subtree
                current = current.right;
            }
        }

        return result;
    }
}
