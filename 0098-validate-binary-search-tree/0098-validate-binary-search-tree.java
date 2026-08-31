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
    //bruteforce : we traverse the nodes of the tree (in order traversal) and store it in a data structure and if the elements inside the data structure isn't sorted, it is not a binary search tree.
    public boolean isValidBST(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        helper(root, list);
        int n = list.size();
        for (int i = 0; i < n - 1; i++) {
            if (!(list.get(i) < list.get(i + 1))) {
                return false;
            }
        }
        return true;
    }
    private void helper(TreeNode root, List<Integer> list) {
        if (root == null) {
            return;
        }
        helper(root.left, list);
        list.add(root.val);
        helper(root.right, list);
    }
}