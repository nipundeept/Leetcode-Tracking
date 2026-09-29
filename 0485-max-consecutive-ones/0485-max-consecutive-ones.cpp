class Solution {
public:
    int findMaxConsecutiveOnes(vector<int>& nums) {
        int curr = 0, max_ones = 0;
        for (int num : nums) {
            if (num == 1) {
                curr++;
            }
            else {
                max_ones = max(max_ones, curr);
                curr = 0;
            }
        }
        return max(curr, max_ones);
    }
};