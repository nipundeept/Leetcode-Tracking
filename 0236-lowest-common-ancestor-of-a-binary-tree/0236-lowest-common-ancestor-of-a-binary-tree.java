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
    //deepest common ancestor using depth first search and backtracking
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        List<TreeNode> pathP = new ArrayList<>();
        List<TreeNode> pathQ = new ArrayList<>();
        TreeNode res = null;
        if (findPath(root, p, pathP) && findPath(root, q, pathQ)) {
            int min = Math.min(pathP.size(), pathQ.size());
            for (int i = 0; i < min; i++) {
                if (pathP.get(i) == pathQ.get(i)) {
                    res = pathP.get(i);
                }
            }
        }
        return res;
    }
    //helper function to obtain the paths of p and q, using those paths we could find the deeper common ancestor(node) appearing in both of them
    private boolean findPath(TreeNode root, TreeNode target, List<TreeNode> path) {
        if (root == null) {
            return false;
        }
        path.add(root);
        if (root == target) {
            return true;
        }
        boolean leftCheck = findPath(root.left, target, path);
        if (leftCheck) {
            return true;
        }
        boolean rightCheck = findPath(root.right, target, path);
        if (rightCheck) {
            return true;
        }
        path.removeLast(); 
        return false;
    }
}