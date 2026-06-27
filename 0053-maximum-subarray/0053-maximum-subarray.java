class Solution {
    public int maxSubArray(int[] nums) {
        //Kadane's algorithm : At every new index, we have two possibilities (i. To start afresh from the current element or append the current element with the previous best sum)
        int max_sum = nums[0];
        int curr_sum = nums[0];
        for (int i = 1; i < nums.length; i++) {
            curr_sum = Math.max(nums[i], curr_sum + nums[i]);
            max_sum = Math.max(max_sum, curr_sum);
        }
        return max_sum;
    }
}