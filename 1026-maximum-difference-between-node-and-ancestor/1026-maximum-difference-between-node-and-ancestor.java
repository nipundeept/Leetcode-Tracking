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
    public int maxAncestorDiff(TreeNode root) {
        return helper(root, Integer.MAX_VALUE, Integer.MIN_VALUE);
    }
    private int helper(TreeNode root, int min, int max) {
        if (root == null) {
            return 0;
        }
        min = Math.min(root.val, min);
        max = Math.max(root.val, max);
        int left = helper(root.left, min, max);
        int right = helper(root.right, min, max);
        int diff = max - min;
        return Math.max(left, Math.max(diff, right));
    }
}