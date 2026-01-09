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
class Pairs {
    Integer height;
    TreeNode node;

    Pairs(int h, TreeNode n) {
        height = h;
        node = n;
    }
}

class Solution {
    public TreeNode subtreeWithAllDeepest(TreeNode root) {
        return dfs(root).node;
    }

    private static Pairs dfs(TreeNode node) {
        if (node == null) {
            return new Pairs(0, null);
        }
        Pairs left = dfs(node.left);
        Pairs right = dfs(node.right);
        if (left.height == right.height) {
            return new Pairs(left.height+1, node);
        }
        left.height+=1;
        right.height+=1;

        return left.height > right.height ? left : right;

    }
}