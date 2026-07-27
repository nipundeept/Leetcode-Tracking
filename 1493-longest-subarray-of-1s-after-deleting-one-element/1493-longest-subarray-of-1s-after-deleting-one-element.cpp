class Solution {
public:
    int longestSubarray(vector<int>& nums) {
        //a valid window can have at most 1 0s
        int n = nums.size();
        int left = 0, right, zeroCount = 0, res = -1;
        for (right = 0; right < n; right++) {
            if (nums[right] == 0) {
                zeroCount++;
            }
            while (zeroCount > 1) {
                if (nums[left] == 0) {
                    zeroCount--;
                }
                left++;
            }
            res = max(res, right - left); //(right - left + 1) - 1, we need to delete that element from the count, so the size decreases by 1
        }
        return res;
    }
};