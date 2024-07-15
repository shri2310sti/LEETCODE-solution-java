import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Solution {
    public TreeNode createBinaryTree(int[][] descriptions) {
        Map<Integer, TreeNode> nodeMap = new HashMap<>();
        Set<Integer> childSet = new HashSet<>();

        // Create nodes and establish parent-child relationships
        for (int[] description : descriptions) {
            int parentVal = description[0];
            int childVal = description[1];
            boolean isLeft = description[2] == 1;

            // Get or create the parent node
            TreeNode parentNode = nodeMap.getOrDefault(parentVal, new TreeNode(parentVal));
            nodeMap.put(parentVal, parentNode);

            // Get or create the child node
            TreeNode childNode = nodeMap.getOrDefault(childVal, new TreeNode(childVal));
            nodeMap.put(childVal, childNode);

            // Establish the relationship
            if (isLeft) {
                parentNode.left = childNode;
            } else {
                parentNode.right = childNode;
            }

            // Track that this node is a child
            childSet.add(childVal);
        }

        // The root will be the only node that is not a child of any other node
        TreeNode root = null;
        for (int nodeVal : nodeMap.keySet()) {
            if (!childSet.contains(nodeVal)) {
                root = nodeMap.get(nodeVal);
                break;
            }
        }

        return root;
    }
}
