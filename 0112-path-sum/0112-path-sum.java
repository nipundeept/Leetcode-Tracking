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
    public boolean hasPathSum(TreeNode root, int targetSum) {
        boolean res = helper(root, targetSum, 0);
        return res;
    }
    private boolean helper(TreeNode root, int target, int current) {
        if (root == null) {
            return false;
        }
        current = current + (root.val);
        if (root.right == null && root.left == null) {
            if (current == target) {
                return true;
            }
            return false;
        }
        boolean left = helper(root.left, target, current);
        if (left == true) {
            return true;
        }
        boolean right = helper(root.right, target, current);
        if (right == true) {
            return true;
        }
        return false;
    }
}