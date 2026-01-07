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
    long totalsum = 0;
    long maxProduct = 0;
    long mod = 1000000007;

    public int maxProduct(TreeNode root) {
        totalsum = dfssum(root);
        dfsProduct(root);

        return (int) (maxProduct % mod);
    }

    public long dfssum(TreeNode root) {
        if (root == null)
            return 0;

        return root.val + dfssum(root.left) + dfssum(root.right);
    }

    public long dfsProduct(TreeNode root) {
        if (root == null)
            return 0;

        long left = dfsProduct(root.left);
        long right = dfsProduct(root.right);

        long subtreeSum = root.val + left + right;
        long product = subtreeSum * (totalsum - subtreeSum);
        maxProduct = Math.max(maxProduct, product);
        return subtreeSum;
    }
}