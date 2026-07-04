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
    public boolean hasPathSum(TreeNode root, int targetSum) {
        //leap of faith : root's left and right subtree tells me if they have the valid pathSum or not
        //base case 
        if (root == null) {
            return false; //null node cannot form a node to leaf path, so we return false
        }
        //special case: if we are at leaf, we are supposed to check if targetSum is equal to the current value or not
        if (root.left == null && root.right == null) {
            return (targetSum == root.val);
        }
        boolean leftSubtree = hasPathSum(root.left, targetSum - root.val);
        boolean rightSubtree = hasPathSum(root.right, targetSum - root.val);
        return leftSubtree || rightSubtree; //if either of the path is valid, it gives a valid pass to it's parent
    }
}