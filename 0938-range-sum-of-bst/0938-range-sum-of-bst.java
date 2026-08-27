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
    public int rangeSumBST(TreeNode root, int low, int high) {
        //if the value is not less than low and is neither greater than high at the same time, it lies in between them
        if (root == null) {
            return 0;
        }
        if (root.val < low) {
            //recurse right (it has greater values than root.val)
            int right = rangeSumBST(root.right, low, high);
            return right;
        }
        if (root.val > high) {
            //recurse left (it has lesser values than root.val)
            int left = rangeSumBST(root.left, low, high);
            return left;
        }
        //root.val lies in range if it has not been satisfied by the above two conditions, so we add its contribution but cannot directly return because there are possibilities for its subtrees to contribute to the answer, so we will explore them too
        int leftSum = rangeSumBST(root.left, low, high);
        int rightSum = rangeSumBST(root.right, low, high);
        return root.val + leftSum + rightSum;
    }
}