import java.util.Queue;
import java.util.LinkedList;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

public class MaximumLevelSumOfABinaryTree {
    public int maxLevelSum(TreeNode root) {
        int levelResult = Integer.MAX_VALUE;
        int maxSum = Integer.MIN_VALUE;
        int level = 0;

        // Logic is to perform Level Order
        // Traversal and calculate sums of
        // each level and keep the levelResult
        // updated
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        // Level order traversal
        while(!queue.isEmpty()) {
            int tempSum = 0;
            level += 1;

            // Calculate sum of the current level
            // and add next level elements
            for (int i = queue.size(); i > 0; i--) {
                TreeNode node = queue.poll();
                tempSum += node.val;

                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
            }

            // Compare and record max sum
            // and level result variables
            if (tempSum > maxSum) {
                maxSum = tempSum;
                levelResult = level;
            }
        }

        return levelResult;
    }
}
