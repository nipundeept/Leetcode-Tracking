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
    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return root;
        }
        TreeNode left = invertTree(root.left); //leap of faith (trusting the recursion to give us the value of inverted left subtree)
        TreeNode right = invertTree(root.right); //trusting the recursion to give us the value of inverted right subtree
        //connecting our expectation to faith at the current node
        root.left = right;
        root.right = left;
        return root;
    }
}