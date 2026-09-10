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
    class Pair {
        int sumSubtree;
        int countSubtree;
        Pair(int sumSubtree, int countSubtree) {
            this.sumSubtree = sumSubtree;
            this.countSubtree = countSubtree;
        }
    }
    int result = 0;
    public int averageOfSubtree(TreeNode root) {
        helper(root);
        return result;
    }
    private Pair helper(TreeNode root) {
        if (root == null) {
            return new Pair(0, 0);
        }
        Pair left = helper(root.left);
        Pair right = helper(root.right);
        int sum = left.sumSubtree + right.sumSubtree + root.val;
        int count = left.countSubtree + right.countSubtree + 1;
        if (sum / count == root.val) {
            result++;
        }
        return new Pair(sum, count);
    }
}