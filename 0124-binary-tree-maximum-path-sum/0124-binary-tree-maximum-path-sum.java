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
    private Integer result;

    public int maxPathSum(TreeNode root) {
        this.result = Integer.MIN_VALUE;
        computeMaxPathSum(root);
        return result;
    }

    private int computeMaxPathSum(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int left = computeMaxPathSum(node.left);
        int right = computeMaxPathSum(node.right);
        if (left < 0)
            left = 0;
        if (right < 0)
            right = 0;
        int pathSum = left + right + node.val;
        this.result = Math.max(this.result, pathSum);
        return Math.max(left, right) + node.val;

    }
}