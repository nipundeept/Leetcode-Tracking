class Solution {
    /*
    Algorithmic intuition: 
    Let T be the total size of the array, where M is the number of target elements, N is the number of non-target elements.
    Then, T = M + N
    we are given that M > T/2
    => 2M > T
    => 2M > M + N
    => M > N
    => M - N > 0 (Number of target elements - Number of non target elements must be strictly greater than 0 in a subarray for the condition to be true)
    */
    public int countMajoritySubarrays(int[] nums, int target) {
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            int nte = 0, te = 0;
            for (int j = i; j < nums.length; j++) {
                if (nums[j] == target) {
                    te++;
                }
                else {
                    nte++;
                }
                if (te - nte > 0) {
                    count++;
                }
            }
        }
        return count;
    }
}