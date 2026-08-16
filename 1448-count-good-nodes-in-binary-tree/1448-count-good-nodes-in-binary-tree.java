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
    int count = 0;
    public int goodNodes(TreeNode root) {
        helper(root, Integer.MIN_VALUE);
        return count;
    }
    private void helper(TreeNode root, int state) {
        if (root == null) {
            return;
        }
        if (root.val >= state) {
            count++;
            state = root.val;
        }
        helper(root.left, state);
        helper(root.right, state);
        return;
    }
}