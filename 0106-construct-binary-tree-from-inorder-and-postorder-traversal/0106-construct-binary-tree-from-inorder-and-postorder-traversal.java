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
    private int idx;
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        int n=inorder.length;
        idx=n-1;
        Map<Integer, Integer> map=new HashMap<>();
        for(int i=0;i<n;i++){
            map.put(inorder[i], i);
        }

        return buildTree(postorder, 0, n-1, map);
    }

    private TreeNode buildTree(int[] postorder, int start, int end, Map<Integer, Integer> map){
        if(start>end){
            return null;
        }

        int rootVal= postorder[idx--];
        TreeNode node= new TreeNode(rootVal);
        int inorderIndex=map.get(rootVal);
        node.right=buildTree(postorder, inorderIndex+1, end, map);
        node.left=buildTree(postorder, start, inorderIndex-1, map);

        return node;

    }
}