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
    int diameter = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        int h = heightHelper(root);
        return diameter;
    }
    
    private int heightHelper(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftHeight = heightHelper(root.left);
        int rightHeight = heightHelper(root.right);
        diameter = Math.max(leftHeight + rightHeight, diameter);
        return 1 + Math.max(leftHeight, rightHeight);
    }
}