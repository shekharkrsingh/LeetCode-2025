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

 class Pairs{
    Boolean flag;
    Integer height;

    Pairs(boolean flag, int height){
        this.flag=flag;
        this.height=height;
    }
 }
class Solution {
    public boolean isBalanced(TreeNode root) {
        return balance(root).flag;
    }

    private Pairs balance(TreeNode node){
        if(node==null){
            return new Pairs(true, 0);
        }

        Pairs left= balance(node.left);
        Pairs right=balance(node.right);

        if(node.val==1){
            System.out.println(left.height);
            System.out.println(right.height);
        }

        if(Math.abs(left.height-right.height)>=2 || !left.flag || !right.flag){
            return new Pairs(false, 0);
        }

        left.height=Math.max(left.height, right.height)+1;

        return left;
    }


}