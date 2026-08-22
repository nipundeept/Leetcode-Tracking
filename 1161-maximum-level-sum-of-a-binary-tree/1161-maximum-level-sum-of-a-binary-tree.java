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
    public int maxLevelSum(TreeNode root) {
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
}