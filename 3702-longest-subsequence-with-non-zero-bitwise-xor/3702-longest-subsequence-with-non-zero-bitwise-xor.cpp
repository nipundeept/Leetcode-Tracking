class Solution {
public:
    int longestSubsequence(vector<int>& nums) {
        int n = nums.size();
        int val = 0;
        bool allZeroes = true;
        for (int num : nums) {
            val = val ^ num;
            if (num != 0) {
                allZeroes = false;
            }
        }
        if (allZeroes) {
            return 0;
        }
        if (val != 0) {
            return n;
        }
        return n - 1;
    }
};