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
    int h=0;
    int d=0;
    Pairs(int h, int d){
        this.h=h;
        this.d=d;
    }

    Pairs(){
        this.h=0;
        this.d=0;
    }
}
class Solution {
    public int diameterOfBinaryTree(TreeNode root) {
        return height(root).d-1;
    }

    private Pairs height(TreeNode node){
        if(node==null){
            return new Pairs();
        }

        Pairs left= height(node.left);
        Pairs right= height(node.right);



        int maxH=Math.max(left.h, right.h)+1;
        int maxD=Math.max(left.h+right.h+1, Math.max(left.d, right.d));

        left.h=maxH;
        left.d=maxD;

        return left;
    }
}