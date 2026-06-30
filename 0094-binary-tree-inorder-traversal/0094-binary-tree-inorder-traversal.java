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
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        inOrderHelper(root, res);
        return res;
    }

    //helper function to traverse the tree
    private void inOrderHelper(TreeNode node, List<Integer> res) {
        if (node == null) {
            return;
        }
        inOrderHelper(node.left, res);
        res.add(node.val);
        inOrderHelper(node.right, res);
    }
}