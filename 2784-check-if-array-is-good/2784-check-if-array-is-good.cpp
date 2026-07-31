class Solution {
public:
    bool isGood(vector<int>& nums) {
        sort(nums.begin(), nums.end());
        bool flag = true;
        int k = 1, n = nums.size();
        if (n == 1) {
            return false;
        }
        for (int i = 0; i < n - 1; i++) {
            if ((k++) != nums[i]) {
                flag = false;
                break;
            }
        }
        if (nums[n - 2] != nums[n - 1]) {
            flag = false;
        }
        return flag;
    }
};