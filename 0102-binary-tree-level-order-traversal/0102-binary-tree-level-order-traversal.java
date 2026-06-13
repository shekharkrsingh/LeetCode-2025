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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> lvlTrav=new ArrayList<>();
        if(root==null){
            return lvlTrav;
        }

        List<Integer> list= new ArrayList<>();

        Queue<TreeNode> q= new LinkedList<>();
        q.offer(root);
        q.offer(null);
        while(q.size()>1){
            TreeNode node=q.poll();
            if(node==null){
                lvlTrav.add(list);
                list=new ArrayList<>();
                q.offer(null);
            }else{
                list.add(node.val);
                if(node.left!=null){
                    q.offer(node.left);
                }
                if(node.right!=null){
                    q.offer(node.right);
                }
            }
        }
        lvlTrav.add(list);
        return lvlTrav;
    }
}