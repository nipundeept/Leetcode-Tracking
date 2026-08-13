class Solution {
    public long countSubarrays(int[] nums, long k) {
        int n = nums.length;
        long[] prefix = new long[n];
        prefix[0] = (long)nums[0];
        for (int i = 1; i < n; i++) {
            prefix[i] = prefix[i - 1] + ((long)nums[i]);
        }
        long count = 0;
        int left = 0;
        for (int right = 0; right < n; right++) {
            long sub_size = right - left + 1;
            long sum_query = (left != 0) ? (prefix[right] - prefix[left - 1]) : prefix[right];
            while((sum_query * sub_size) >= k) {
                sum_query = sum_query - nums[left];
                sub_size--;
                left++;
            }
            count += (right - left + 1);
        }
        return count;
    }
}