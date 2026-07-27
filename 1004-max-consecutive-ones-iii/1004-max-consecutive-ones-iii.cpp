class Solution {
public:
    int longestOnes(vector<int>& nums, int k) {
        //sliding window(dynamic)
        //a valid window will have at most k number of 0s, update the answer when the window is valid
        //shrink the window to make it valid again
        int n = nums.size();
        int left = 0, right, res = -1, zeroCount = 0;
        for (right = 0; right < n; right++) {
            if (nums[right] == 0) {
                zeroCount++;
            }
            while (zeroCount > k) {
                if (nums[left] == 0) {
                    zeroCount--;
                }
                left++;
            }
            //updating the answer here
            res = max(res, right - left + 1);
        }
        return res;
    }
};