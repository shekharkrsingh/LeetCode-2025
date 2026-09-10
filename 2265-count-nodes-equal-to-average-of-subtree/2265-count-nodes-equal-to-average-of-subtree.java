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
    private Integer noOfNodes;

    public int averageOfSubtree(TreeNode root) {
        this.noOfNodes = 0;
        treeTrav(root);
        return this.noOfNodes;
    }

    private int[] treeTrav(TreeNode node) {
        if (node == null) {
            return new int[] { 0, 0 };
        }

        int[] left = treeTrav(node.left);
        int[] right = treeTrav(node.right);

        int sum = left[0] + right[0] + node.val;
        int subNodeCnt = left[1] + right[1] + 1;

        if (subNodeCnt != 0 && node.val == sum / subNodeCnt) {
            this.noOfNodes++;
        }

        return new int[] { sum, subNodeCnt };
    }
}