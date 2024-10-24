class Solution {
    public boolean flipEquiv(TreeNode root1, TreeNode root2) {
        // Base cases
        if (root1 == null && root2 == null) {
            return true; // Both are null, so they are equivalent
        }
        if (root1 == null || root2 == null || root1.val != root2.val) {
            return false; // One is null or the values are different
        }
        
        // Recursive check: Either no flip, or flip the children
        boolean noFlip = flipEquiv(root1.left, root2.left) && flipEquiv(root1.right, root2.right);
        boolean flip = flipEquiv(root1.left, root2.right) && flipEquiv(root1.right, root2.left);
        
        return noFlip || flip;
    }
}
