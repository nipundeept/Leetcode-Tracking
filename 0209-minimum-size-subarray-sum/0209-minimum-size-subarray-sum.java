class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int n = nums.length;
        //Dynamic size sliding window, allocate two pointers and shrink and expand the window size
        int j = 0, i = 0, sum = 0; //initialsing the pointers
        int min = Integer.MAX_VALUE;
        while (j < n) {
            sum = sum + nums[j];
            while (sum >= target) {
                //updating the new window length
                min = Math.min(min, j - i + 1);
                //decreasing the sum
                sum = sum - nums[i];
                //shrinking the size to find a better subarray (that may be shorter in size)
                i++;
            }
            j++;
        }
        return (min == Integer.MAX_VALUE) ? 0 : min;
    }
}