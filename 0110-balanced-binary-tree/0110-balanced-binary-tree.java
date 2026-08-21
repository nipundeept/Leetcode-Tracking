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
    boolean result = true;
    public boolean isBalanced(TreeNode root) {
        int val = depthHelper(root);
        return result;
    }
    private int depthHelper(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftDepth = depthHelper(root.left);
        int rightDepth = depthHelper(root.right);
        if (Math.abs(leftDepth - rightDepth) > 1) {
            result = false;
        }
        if (!result) {
            return 0;
        }
        return Math.max(leftDepth, rightDepth) + 1;
    }
}