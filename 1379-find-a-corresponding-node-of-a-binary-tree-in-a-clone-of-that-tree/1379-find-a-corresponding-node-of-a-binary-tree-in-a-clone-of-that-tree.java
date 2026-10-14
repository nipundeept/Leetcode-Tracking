/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class Solution {
    public final TreeNode getTargetCopy(final TreeNode original, final TreeNode cloned, final TreeNode target) {
        if (cloned == null) {
            return null;
        }

        if (cloned.val == target.val) {
            return cloned;
        }

        TreeNode leftCall = getTargetCopy(original, cloned.left, target);
        if (leftCall != null) {
            return leftCall;
        }

        TreeNode rightCall = getTargetCopy(original, cloned.right, target);
        if (rightCall != null) {
            return rightCall;
        }

        return null;
    }
}