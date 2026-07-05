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
    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }
        int leftHeight = maxHeight (root.left);
        int rightHeight = maxHeight(root.right);
        if (Math.abs(leftHeight - rightHeight) > 1)
            return false;
        boolean left = isBalanced(root.left);
        boolean right = isBalanced(root.right);
        if (!left || !right) return false;
        return true;
    }
    private int maxHeight(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftSubtree = maxHeight (root.left);
        int rightSubtree = maxHeight (root.right);
        return (Math.max(leftSubtree, rightSubtree) + 1);
    }
}