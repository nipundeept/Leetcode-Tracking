class Solution {
    public int sortPermutation(int[] nums) {
        //take and of all the misplaced elements
        int result = 0, n = nums.length;
        for (int i = 0; i < n; i++) {
            if (nums[i] != i) {
                result = nums[i];
                break;
            }
        }
        for (int i = 0; i < n; i++) {
            if (nums[i] != i) {
                result = result & nums[i];
            }
        }

        return result;
    }
}