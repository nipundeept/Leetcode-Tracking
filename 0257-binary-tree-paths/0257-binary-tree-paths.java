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
    List<String> res = new ArrayList<>(); 
    public List<String> binaryTreePaths(TreeNode root) {
        helper(root, new ArrayList<>());
        return res;
    }
    private void helper(TreeNode root, List<Integer> path) {
        if (root == null) {
            return;
        }
        path.add(root.val);
        if (root.left == null && root.right == null) {
            //reached the end of a subtree (at a leaf node)
            StringBuilder sb = new StringBuilder();
            int pathsize = path.size();
            for (int i = 0; i < pathsize; i++) {
                if (i > 0) {
                    sb.append("->");
                }
                sb.append(path.get(i));
            }
            res.add(sb.toString());
            path.remove(path.size() - 1);
            return;
        }
        helper(root.left, path);
        helper(root.right, path);
        path.remove(path.size() - 1);
        return;
    }
}