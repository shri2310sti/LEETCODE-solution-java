import java.util.HashMap;

class Solution {
    private int preIndex = 0;
    private HashMap<Integer, Integer> postIndexMap = new HashMap<>();
    
    public TreeNode constructFromPrePost(int[] preorder, int[] postorder) {
        for (int i = 0; i < postorder.length; i++) {
            postIndexMap.put(postorder[i], i);
        }
        return construct(preorder, postorder, 0, postorder.length - 1);
    }
    
    private TreeNode construct(int[] preorder, int[] postorder, int left, int right) {
        if (left > right || preIndex >= preorder.length) return null;

        TreeNode root = new TreeNode(preorder[preIndex++]);

        if (left < right) {
            int leftSubRootIndex = postIndexMap.get(preorder[preIndex]);
            
            root.left = construct(preorder, postorder, left, leftSubRootIndex);
            root.right = construct(preorder, postorder, leftSubRootIndex + 1, right - 1);
        }
        
        return root;
    }
}
