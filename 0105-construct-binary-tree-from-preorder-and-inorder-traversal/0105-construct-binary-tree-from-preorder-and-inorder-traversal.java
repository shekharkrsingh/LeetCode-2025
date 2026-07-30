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
        return treeGeneration(0, preorder.length - 1, preorder, inorder);
    }

    private TreeNode treeGeneration(int start, int end, int[] preorder, int[] inorder) {
        if (start > end) {
            return null;
        }
        for (int i = start; i <= end; i++) {
            if (inorder[i] == preorder[idx]) {
                TreeNode newNode = new TreeNode(preorder[idx]);
                idx++;
                newNode.left = treeGeneration(start, i - 1, preorder, inorder);
                newNode.right = treeGeneration(i + 1, end, preorder, inorder);
                return newNode;
            }
        }
        return null;
    }
}