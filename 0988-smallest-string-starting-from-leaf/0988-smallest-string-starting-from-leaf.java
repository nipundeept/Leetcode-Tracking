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
    String state = "";
    public String smallestFromLeaf(TreeNode root) {
        helper(root, new StringBuilder(""));
        return state;
    }
    private void helper(TreeNode root, StringBuilder path) {
        if (root == null) {
            return;
        }
        path.append((char)('a' + root.val));
        if (root.left == null && root.right == null) {
            String sb = path.reverse().toString();
            if (state.length() == 0) {
                state = sb;
            }
            else {
                if ((sb.compareTo(state) < 0)) {
                    state = sb;
                }
            }
            path.reverse();
            path.deleteCharAt(path.length() - 1);
            return;
        }
        helper(root.left, path);
        helper(root.right, path);
        path.deleteCharAt(path.length() - 1);
        return;
    }
}