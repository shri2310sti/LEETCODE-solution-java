import java.util.*;

class Solution {
    public int minimumOperations(TreeNode root) {
        if (root == null) return 0;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int totalSwaps = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> level = new ArrayList<>();

            // Collect values at the current level
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                level.add(node.val);

                if (node.left != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);
            }

            // Count swaps needed to sort this level
            totalSwaps += countMinSwaps(level);
        }

        return totalSwaps;
    }

    private int countMinSwaps(List<Integer> nums) {
        int n = nums.size();
        int[] arr = nums.stream().mapToInt(i -> i).toArray();
        int[] sortedArr = arr.clone();
        Arrays.sort(sortedArr);

        Map<Integer, Integer> valueToIndex = new HashMap<>();
        for (int i = 0; i < n; i++) {
            valueToIndex.put(arr[i], i);
        }

        boolean[] visited = new boolean[n];
        int swaps = 0;

        for (int i = 0; i < n; i++) {
            if (visited[i] || arr[i] == sortedArr[i]) continue;

            int cycleSize = 0;
            int current = i;

            while (!visited[current]) {
                visited[current] = true;
                cycleSize++;

                current = valueToIndex.get(sortedArr[current]);
            }

            if (cycleSize > 1) {
                swaps += cycleSize - 1;
            }
        }

        return swaps;
    }
}
