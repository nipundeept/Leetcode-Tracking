class Solution {
    public int subarraySum(int[] nums) {
        int n = nums.length;
        int[] prefixSum = new int[n];
        int curr = 0;
        for (int i = 0; i < n; i++) {
            curr += nums[i];
            prefixSum[i] = curr;
        }

        int sum = 0;
        for (int i = 0; i < n; i++) {
            int start = Math.max(0, i - nums[i]);
            if (start == 0) {
                sum += prefixSum[i];
            }
            else {
                sum += prefixSum[i] - prefixSum[(start - 1)];
            }
        }

        return sum;
    }
}