class Solution {
public:
    int longestSubsequence(vector<int>& nums) {
        int n = nums.size();
        bool allZeroes = true;
        if (n == 1) {
            if (nums[0] == 0) {
                return 0;
            }
            return 1;
        }
        int val = 0;
        for (int num : nums) {
            if (num != 0) {
                allZeroes = false;
            }
            val = val ^ num;
        }
        if (allZeroes) {
            return 0;
        }
        if (val != 0) {
            return n;
        }
        int count = 0;
        for (int i = 0; i < n; i++) {
            int elem = nums[i];
            if (val ^ elem != 0) {
                count++;
                break;
            }
        }
        return n - count;
    }
};