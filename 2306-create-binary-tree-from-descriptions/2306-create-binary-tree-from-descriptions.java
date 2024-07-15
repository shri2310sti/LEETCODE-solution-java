import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Solution {
    public TreeNode createBinaryTree(int [][] descriptions) {
        Map<Integer, TreeNode> nodeMap = new HashMap<>();
        Set<Integer> childSet = new HashSet<>();

        for(int [] description : descriptions) {
            int parentVal = description[0];
            int childVal = description[1];
            boolean isLeft = description[2] == 1;

            TreeNode parentNode = nodeMap.getOrDefault(parentVal, new TreeNode(parentVal));

            nodeMap.put(parentVal, parentNode);

            TreeNode childNode = nodeMap.getOrDefault(childVal, new TreeNode(childVal));
            nodeMap.put(childVal, childNode);

            if(isLeft){
                parentNode.left = childNode;

            } else {
                parentNode.right = childNode;
            }

            childSet.add(childVal);
        }

        TreeNode root = null;
        for(int nodeVal : nodeMap.keySet()){
            if(!childSet.contains(nodeVal)){
                root = nodeMap.get(nodeVal);
                break;
            }
        }
        return root;
    }
}