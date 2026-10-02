class Solution {
public:
    int findMaxConsecutiveOnes(vector<int>& nums) {
        int curr = 0, maxStreak = 0;
        for (int num : nums) {
            if (num != 0) {
                curr++;
            }
            else {
                maxStreak = max(maxStreak, curr);
                curr = 0;
            }
        }

        return max(maxStreak, curr);
    }
};