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
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        preOrderHelper(root, res);
        return res;
    }
    //helper function for Preorder traversal
    private void preOrderHelper(TreeNode node, List<Integer> res) {
        if (node == null) {
            return;
        }
        res.add(node.val);
        preOrderHelper(node.left, res);
        preOrderHelper(node.right, res);
        return;
    }
}