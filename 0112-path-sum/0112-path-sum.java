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
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if(root==null){
            return false;
        }
        return pathSum(root, targetSum);
    }

    private boolean pathSum(TreeNode node, int targetSum) {
        if(node==null){
            return false;
        }

        if(node.left==null && node.right==null){
            return targetSum-node.val==0;
        }

        boolean left = pathSum(node.left, targetSum - node.val);
        boolean right = pathSum(node.right, targetSum - node.val);

        return left || right;
    }
}