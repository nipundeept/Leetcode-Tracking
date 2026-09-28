class Solution {
    public int pivotIndex(int[] nums) {
        int n = nums.length, runningSum = 0, total = 0;
        for (int num : nums) total += num;
        for (int i = 0; i < n; i++) {
            runningSum += nums[i];
            int rightSum = total - runningSum;
            int leftSum = runningSum - nums[i];
            if (leftSum == rightSum) {
                return i;
            }
        }
        
        return -1;
    }
}