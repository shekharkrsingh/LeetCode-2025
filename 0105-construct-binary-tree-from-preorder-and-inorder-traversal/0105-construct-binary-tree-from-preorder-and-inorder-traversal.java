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
        int n=inorder.length;
        Map<Integer,Integer> map= new HashMap<>();
        for(int i=0;i<n;i++){
            map.put(inorder[i], i);
        }
        return buildActualTree(0, n-1, preorder, inorder, map);
    }

    private TreeNode buildActualTree(int start, int end, int[] preorder, int[] inorder, Map<Integer, Integer> map) {
        if(idx>=preorder.length){
            return null;
        }
        int validx=map.get(preorder[idx]);
        if(validx<start || validx>end){
            return null;
        }

        TreeNode node = new TreeNode(preorder[idx]);
        idx++;
        node.left = buildActualTree(start, validx - 1, preorder, inorder, map);
        node.right = buildActualTree(validx + 1, end, preorder, inorder, map);

        return node;
    }
}