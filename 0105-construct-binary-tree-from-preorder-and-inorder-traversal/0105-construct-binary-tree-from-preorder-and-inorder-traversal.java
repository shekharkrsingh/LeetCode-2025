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

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return buildActualTree(0, inorder.length - 1, preorder, inorder);
    }

    private TreeNode buildActualTree(int start, int end, int[] preorder, int[] inorder) {
        int validx = -1;
        for (int i = start; i <= end; i++) {
            if (inorder[i] == preorder[idx]) {
                validx = i;
                break;
            }
        }
        if (validx == -1) {
            return null;
        }

        TreeNode node = new TreeNode(preorder[idx]);
        idx++;
        node.left = buildActualTree(start, validx - 1, preorder, inorder);
        node.right = buildActualTree(validx + 1, end, preorder, inorder);

        return node;
    }
}