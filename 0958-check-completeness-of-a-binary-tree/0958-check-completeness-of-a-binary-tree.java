class Solution {
    // Once a missing position is encountered during BFS,
    // no non-null node can appear after it.
    public boolean isCompleteTree(TreeNode root) { 
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        boolean seenGap = false;
        while (!queue.isEmpty()) {
            TreeNode curr = queue.poll();
            if (curr.left != null) {
                if (seenGap) {
                    return false;
                }
                queue.offer(curr.left);
            } else {
                seenGap = true;
            }
            if (curr.right != null) {
                if (seenGap) {
                    return false;
                }
                queue.offer(curr.right);
            } else {
                seenGap = true;
            }
        }
        return true;
    }
}