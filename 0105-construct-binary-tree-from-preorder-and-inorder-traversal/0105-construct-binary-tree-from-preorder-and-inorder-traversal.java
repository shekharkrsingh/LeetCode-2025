
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
import java.util.HashMap;
import java.util.Map;

class Solution {
    private int idx = 0;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }

        return build(preorder, 0, inorder.length - 1, map);
    }

    private TreeNode build(int[] preorder,
            int start,
            int end,
            Map<Integer, Integer> map) {

        if (start > end)
            return null;

        int rootVal = preorder[idx++];
        TreeNode root = new TreeNode(rootVal);

        int inorderIndex = map.get(rootVal);

        root.left = build(preorder, start, inorderIndex - 1, map);
        root.right = build(preorder, inorderIndex + 1, end, map);

        return root;
    }
}