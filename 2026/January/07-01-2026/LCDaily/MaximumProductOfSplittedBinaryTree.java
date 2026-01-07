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

public class MaximumProductOfSplittedBinaryTree {
    private long result;
    private long fullTreeSum;
    private int mod = 1_000_000_007;
  
    /**
     * Main Function for the solution to call
     * Does 2 things to solve the question:
     * Step 1: Calculate the sum of all elements in the tree
     * Step 2: Calculate sub tree sums (somewhat similar) to
     * step 1 but we also calculate max product of sums of
     * the 2 sub trees
     * @param root: Root of the tree
     * @return max product of the sums of the 2 split sub trees
     */
    public int maxProduct(TreeNode root) {
        // Step 1: Calculate the sum of all elements in the tree
        this.fullTreeSum = fullTreeSum(root);

        
        // Step 2: Calculate sub tree sums (somewhat similar) to
        // step 1 but we also calculate max product of sums of
        // the 2 sub trees
        long _ = partitionedSumProduct(root);
        
        return (int) (result % mod);
    }

    /**
     * Calculate the full tree sum
     * @param node: Root or the intermediate node
     * @return Sum of the tree observed till now
     */
    private long fullTreeSum(TreeNode node) {
        if (node == null) return 0;

        return node.val + fullTreeSum(node.left) + fullTreeSum(node.right);
    }

    /**
     * Calculates the sum of each sub tree
     * possible and if that sum is less than
     * full tree sum, calculate the max product
     * possible
     * @param node: Root of the intermediate node 
     * @return Sum of the subtree observed till now (ignore)
     */
    private long partitionedSumProduct(TreeNode node) {
        if (node == null) return 0;

        long subTreeSum = node.val + partitionedSumProduct(node.left) + partitionedSumProduct(node.right);

        if (subTreeSum < this.fullTreeSum) this.result = Math.max(this.result, subTreeSum * (this.fullTreeSum - subTreeSum));

        return subTreeSum;
    } 
}
