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
        //since we require 2 informations: i) location of the intersection ii) how deep that path went
        //so we create a data structure which will give us these information
    class Pair {
            TreeNode node; //stores the intersection
            int depth;
            Pair(TreeNode node, int depth) {
                this.node = node;
                this.depth = depth;
            }
        }
    public TreeNode lcaDeepestLeaves(TreeNode root) {
        Pair value = dfs(root, 0);
        return value.node;
    }

    //helper function to obtain lca of the deepest leaves
    private Pair dfs(TreeNode node, int depth) {
        if (node == null) {
            Pair p = new Pair(null, depth - 1);
            return p;
        }
        Pair left = dfs(node.left, depth + 1);
        Pair right = dfs(node.right, depth + 1);
        if (left.depth == right.depth) {
            Pair p = new Pair(node, left.depth); //current node will be the lca
            return p;
        }
        else if (left.depth > right.depth) {
            return left;
        }
        else {
            return right;
        }
    }
}