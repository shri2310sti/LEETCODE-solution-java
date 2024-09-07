/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
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
    public boolean isSubPath(ListNode head, TreeNode root) {
        if (root == null) return false;
        
        // Try to match the linked list starting from the current tree node
        if (dfs(head, root)) return true;
        
        // Otherwise, recursively check the left and right subtree
        return isSubPath(head, root.left) || isSubPath(head, root.right);
    }

    private boolean dfs(ListNode head, TreeNode root) {
        if (head == null) return true;  // If we have matched all nodes of the linked list
        if (root == null) return false; // If we reach a null node in the tree
        
        // Check if the current node in the tree matches the current node in the list
        if (head.val != root.val) return false;
        
        // Recursively check the left and right child for the next node in the list
        return dfs(head.next, root.left) || dfs(head.next, root.right);
    }
}
