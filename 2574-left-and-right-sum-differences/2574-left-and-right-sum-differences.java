class Solution {
    public int[] leftRightDifference(int[] nums) {
        int total_sum = 0;
        for (int x : nums) total_sum += x;
        int[] right_sum = new int[nums.length]; int right_track = 0;
        for (int i = 0; i < nums.length; i++) {
            right_track += nums[i];
            right_sum[i] = total_sum - right_track;
        }
        int[] left_sum = new int[nums.length]; int left_track = 0;
        for(int i = nums.length - 1; i >=0; i--) {
            left_track += nums[i];
            left_sum[i] = total_sum - left_track;
        }
        int[] result = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            result[i] = Math.abs(left_sum[i] - right_sum[i]);
        }
        return result;
    }
}