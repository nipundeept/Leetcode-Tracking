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
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<Integer> tree1 = new ArrayList<>();
        List<Integer> tree2 = new ArrayList<>();
        helper(root1, tree1);
        helper(root2, tree2);
        int size1 = tree1.size();
        int size2 = tree2.size();
        if (size1 != size2) {
            return false;
        }
        for (int i = 0; i < size1; i++) {
            if (!tree1.get(i).equals(tree2.get(i))) {
                return false;
            }
        }
        return true;
    }
    //bruteforce : creating a helper that would store the leaf values in a data structure for a tree and then we compare it
    private void helper(TreeNode root, List<Integer> path) {
        if (root == null) {
            return;
        }
        if (root.left == null && root.right == null) {
            path.add(root.val);
            return;
        }
        helper(root.left, path);
        helper(root.right, path);
 
    }
}