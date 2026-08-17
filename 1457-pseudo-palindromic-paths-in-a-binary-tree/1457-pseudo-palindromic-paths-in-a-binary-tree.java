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
    int count = 0;
    public int pseudoPalindromicPaths (TreeNode root) {
        int[] freq = new int[10];
        helper(root, freq);
        return count;
    }

    private void helper(TreeNode root, int[] freq) {
        if(root == null) {
            return;
        }
        freq[root.val]++;
        if (root.left == null && root.right == null) {
            if (palindromicPermutation(freq)) {
                count++;
            }
            freq[root.val]--;
            return;
        }
        helper(root.left, freq);
        helper(root.right, freq);
        freq[root.val]--;
        return;
    }
    private boolean palindromicPermutation(int[] freq) { //freq is an array of frequency of the digits
        int odd = 0, n = freq.length;
        for (int i = 1; i < n; i++) {
            if (freq[i] % 2 != 0) {
                odd++;
            }
        }
        if (odd == 0 || odd == 1) {
            return true;
        }
        return false;
    }
}