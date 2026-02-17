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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        List<List<Integer>> result = new ArrayList<>();
        q.offer(root);
        q.offer(null);
        zigTrav(false, q, result);
        return result;
    }

    private void zigTrav(boolean flag, Queue<TreeNode> q, List<List<Integer>> result) {
        if (q.peek() == null) {
            return;
        }
        List<Integer> level = new ArrayList<>();

        while (q.peek() != null) {
            TreeNode node = q.poll();
            level.add(node.val);
            if (node.left != null) {
                q.offer(node.left);
            }
            if (node.right != null) {
                q.offer(node.right);
            }
        }
        q.poll();
        q.offer(null);

        if (flag) {
            Collections.reverse(level);
        }

        result.add(level);

        zigTrav(!flag, q, result);
    }
}