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
    private Integer idx = 0;

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        int n = inorder.length;
        this.idx = n - 1;
        return build(0, n - 1, inorder, postorder);
    }

    private TreeNode build(int start, int end, int[] inorder, int[] postorder) {
        if (start > end) {
            return null;
        }

        for (int i = start; i <= end; i++) {
            if (postorder[idx] == inorder[i]) {
                TreeNode node = new TreeNode(postorder[idx]);
                idx--;
                node.right = build(i + 1, end, inorder, postorder);
                node.left = build(start, i - 1, inorder, postorder);
                return node;
            }
        }

        return null;
    }
}