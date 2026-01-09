import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

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

public class SmallestSubtreeWithAllTheDeepestNodes {
    public TreeNode subtreeWithAllDeepest(TreeNode root) {
        if (root == null)
            return null;

        // We are going to keep track of parents of nodes
        // we encounter to find the deepest level
        HashMap<TreeNode, TreeNode> parents = new HashMap<>();
        parents.put(root, null);

        // Level Order Traversal to reach the deepest level
        Queue<TreeNode> nodesQueue = new LinkedList<>();
        nodesQueue.offer(root);

        // Keeping track of the deepest nodes here
        LinkedList<TreeNode> deepestNodes = new LinkedList<>();

        // Level Order Traversal Start
        while (!nodesQueue.isEmpty()) {
            int queueSize = nodesQueue.size();

            // Recording the freshest possible nodes for the current level
            deepestNodes.clear();

            for (int i = 0; i < queueSize; i++) {
                TreeNode node = nodesQueue.poll();

                // Record the node on the current level
                deepestNodes.add(node);

                // Add next level nodes on the queue
                if (node.left != null) {
                    parents.put(node.left, node);
                    nodesQueue.offer(node.left);
                }

                // Add next level nodes on the queue
                if (node.right != null) {
                    parents.put(node.right, node);
                    nodesQueue.offer(node.right);
                }
            }
        }

        Set<TreeNode> nodeSet = new HashSet<>(deepestNodes);

        // Converge on the parent of the deepest level
        // if there are multiple deep nodes
        while (nodeSet.size() > 1) {
            Set<TreeNode> parentSet = new HashSet<>();
            for (TreeNode treeNode : nodeSet)
                parentSet.add(parents.get(treeNode));
            nodeSet = parentSet;
        }

        // Return the first element on the parent set
        return nodeSet.iterator().next();
    }
}
