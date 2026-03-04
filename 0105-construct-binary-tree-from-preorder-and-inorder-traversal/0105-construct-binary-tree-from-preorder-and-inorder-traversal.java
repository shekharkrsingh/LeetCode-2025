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
    private int idx=0;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int n=preorder.length;
        return buildTree(preorder, inorder, 0, n-1);
    }

    private TreeNode buildTree (int[] preorder, int[] inorder, int start, int end){
        if(start>end ){
            return null;
        }
        System.out.println(start+ " "+ end+" "+idx);

        if(start==end && preorder[idx]==inorder[start]){
            idx++;
            return new TreeNode(inorder[start]);
        }

        TreeNode node=null;
        for(int i=start; i<=end; i++){
            if(preorder[idx]==inorder[i]){
                node= new TreeNode(preorder[idx]);
                idx++;
                node.left=buildTree(preorder, inorder, start, i-1);
                node.right=buildTree(preorder, inorder, i+1, end);
                break;
            }
        }

        return node;


    }
}