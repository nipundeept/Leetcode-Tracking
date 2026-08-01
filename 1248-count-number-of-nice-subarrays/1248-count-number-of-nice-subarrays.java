class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        //the trick : we count number of subarrays with at most k odd numbers and k - 1 odd numbers and then return the difference of these obtained values.
        //as exactly k odd = at most(k) odd - at most (k - 1) odd
        //dynamic sliding window
        int left = 0, atMostK = 0, n = nums.length;
        int count = 0;
        for (int right = 0; right < n; right++) {
            int num = nums[right];
            if ((num & 1) == 1) {
                count++;
            }
            while (count > k) {
                if ((nums[left] & 1) == 1) {
                    count--;
                }
                left++;
            }
            atMostK += right - left + 1;
        }
        left = 0;
        int atMostKMinus1 = 0;
        count = 0;
        for (int right = 0; right < n; right++) {
            int num = nums[right];
            if ((num & 1) == 1) {
                count++;
            }
            while (count > (k - 1)) {
                if ((nums[left] & 1) == 1) {
                    count--;
                }
                left++;
            }
            atMostKMinus1 += right - left + 1;
        }
        return atMostK - atMostKMinus1;
    }
}