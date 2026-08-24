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
    /*
    public int maxLevelSum(TreeNode root) {
        Depth First Search (DFS Approach)
        Map<Integer, Integer> map = new HashMap<>();
        int max = Integer.MIN_VALUE, result = 0;
        helper(root, 1, map);
        for (int key : map.keySet()) {
            int value = map.get(key);
            if (value > max) {
                max = value;
                result = key;
            }
        }
        return result;
    }

    private void helper(TreeNode root, int depth, Map<Integer, Integer> map) {
        if (root == null) {
            return;
        }
        helper(root.left, depth + 1, map);
        helper(root.right, depth + 1, map);
        map.put(depth, map.getOrDefault(depth, 0) + root.val);
        return;
    }
    */
    //using BFS
    public int maxLevelSum(TreeNode root) {
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        int result = -1, level = 1, maxSum = Integer.MIN_VALUE;
        while(!queue.isEmpty()) {
            int size = queue.size();
            int sum = 0;
            for (int i = 0; i < size; i++) {
                TreeNode curr = queue.poll();
                sum += curr.val;
                if (curr.left != null) {
                    queue.offer(curr.left);
                }
                if (curr.right != null) {
                    queue.offer(curr.right);
                }
            }
            if (sum > maxSum) {
                maxSum = sum;
                result = level;
            }
            level++;
        }
        return result;
    }
}