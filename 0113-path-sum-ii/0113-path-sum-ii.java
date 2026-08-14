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
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        helper(root, 0, targetSum, new ArrayList<>());
        return res;
    }
    private void helper(TreeNode root, int currentSum, int targetSum, List<Integer> path) {
        if (root == null) {
            return;
        }
        path.add(root.val);
        currentSum = currentSum + (root.val);
        if (root.left == null && root.right == null) {
            if (currentSum == targetSum) {
                List<Integer> curr_path = new ArrayList<>(path);
                res.add(curr_path);
            }
            path.remove(path.size() - 1);
            return;
        }
        helper(root.left, currentSum, targetSum, path);
        helper(root.right, currentSum, targetSum, path);
        path.remove(path.size() - 1);
        return;
    }
}