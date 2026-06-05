class Solution {
    public boolean canJump(int[] nums) {
        //Greedy approach
        int size = nums.length;
        int target_index = size - 1;
        for (int i = size - 2; i >= 0; i--) {
            if (nums[i] + i >= target_index) {
                target_index = i;
            }
        }
        return (target_index == 0);
    }
}