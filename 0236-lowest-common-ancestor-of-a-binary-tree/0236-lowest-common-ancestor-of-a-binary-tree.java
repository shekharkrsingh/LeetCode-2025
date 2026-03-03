/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {

    private TreeNode lca;

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        treeTrav(root, p, q);
        return this.lca;
    }

    private Boolean treeTrav(TreeNode node, TreeNode p, TreeNode q) {
        if (node == null) {
            return false;
        }

        boolean curr = node == p || node == q;

        boolean left = treeTrav(node.left, p, q);
        boolean right = treeTrav(node.right, p, q);

        if ((left && right) || ((left || right) && curr)) {
            lca = node;
            return false;
        } else {
            return left || right || curr;
        }
    }
}