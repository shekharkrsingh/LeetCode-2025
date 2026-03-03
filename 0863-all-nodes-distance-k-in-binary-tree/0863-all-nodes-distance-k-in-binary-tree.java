/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Pairs {
    TreeNode node;
    int dis;

    Pairs(TreeNode node, int dis) {
        this.node = node;
        this.dis = dis;
    }
}

class Solution {
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        Map<TreeNode, TreeNode> parent = new HashMap<>();
        List<Integer> result = new ArrayList<>();
        Set<TreeNode> visited = new HashSet<>();
        treeTrav(root, parent);
        Queue<Pairs> q = new LinkedList<>();
        q.offer(new Pairs(target, 0));
        visited.add(target);
        bfs(q, result, visited, k, parent);
        return result;
    }

    private void bfs(Queue<Pairs> q, List<Integer> result, Set<TreeNode> visited, int k,
            Map<TreeNode, TreeNode> parent) {
        while (!q.isEmpty()) {
            Pairs p = q.poll();
            TreeNode node = p.node;
            int dis = p.dis;
            if (dis == k) {
                result.add(node.val);
                continue;
            }
            if (node.left != null && !visited.contains(node.left)) {
                visited.add(node.left);
                q.offer(new Pairs(node.left, dis + 1));
            }
            if (node.right != null && !visited.contains(node.right)) {
                visited.add(node.right);
                q.offer(new Pairs(node.right, dis + 1));
            }
            if (parent.containsKey(node) && !visited.contains(parent.get(node))) {
                visited.add(parent.get(node));
                q.offer(new Pairs(parent.get(node), dis + 1));
            }
        }
    }

    private void treeTrav(TreeNode node, Map<TreeNode, TreeNode> map) {
        if (node == null) {
            return;
        }
        if (node.left != null) {
            map.put(node.left, node);
        }
        if (node.right != null) {
            map.put(node.right, node);
        }
        treeTrav(node.left, map);
        treeTrav(node.right, map);
    }
}