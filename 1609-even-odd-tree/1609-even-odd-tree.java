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
    public boolean isEvenOddTree(TreeNode root) {
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        int level = 0;
        while(!queue.isEmpty()) {
            int size = queue.size();
            int mono_inc = Integer.MIN_VALUE, mono_dec = Integer.MAX_VALUE;
            for (int i = 0; i < size; i++) {
                TreeNode curr = queue.poll();
                int value = curr.val;
                if (level % 2 == 0) {
                    if (value % 2 == 1 && value > mono_inc) {
                        mono_inc = value;
                    }
                    else {
                        return false;
                    }
                }
                else {
                    if (value % 2 == 0 && value < mono_dec) {
                        mono_dec = value;
                    }
                    else {
                        return false;
                    }
                }
                if (curr.left != null) queue.offer(curr.left);
                if (curr.right != null) queue.offer(curr.right);
            }
            level++;
        }
        return true;
    }
}