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
    public int findSecondMinimumValue(TreeNode root) {
        //using BFS
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        long smallest = Long.MAX_VALUE, secSmallest = Long.MAX_VALUE;
        while (!queue.isEmpty()) {
            TreeNode curr = queue.poll();
            int value = curr.val;
            if (value < smallest) {
                secSmallest = smallest;
                smallest = value;
            }
            if (value > smallest && value < secSmallest) {
                secSmallest = value;
            }
            if (curr.left != null) {
                queue.offer(curr.left);
            }
            if (curr.right != null) {
                queue.offer(curr.right);
            }
        }
        if (secSmallest == Long.MAX_VALUE) {
            return -1;
        }
        return (int)secSmallest;
    }
}