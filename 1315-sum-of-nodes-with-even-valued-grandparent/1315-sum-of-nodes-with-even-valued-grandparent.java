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
    int sum = 0;
    public int sumEvenGrandparent(TreeNode root) {
        helper(root, 0, 0);
        return sum;
    }
    private void helper(TreeNode root, int parent, int grandparent) {
        if (root == null) {
            return;
        }
        if (grandparent != 0 && grandparent % 2 == 0) {
            sum += root.val;
        }
        //parent will become grandparent for the upcoming child nodes and current node will become the parent
        grandparent = parent;
        parent = root.val;
        helper(root.left, parent, grandparent);
        helper(root.right, parent, grandparent);
    }
}