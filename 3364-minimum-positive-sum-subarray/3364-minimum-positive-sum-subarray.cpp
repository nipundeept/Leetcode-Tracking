class Solution {
public:
    int minimumSumSubarray(vector<int>& nums, int l, int r) {

        //we can maintain a sliding window of size l and r and calculate the sum of all the elements inside that window
        int minSumRes = INT_MAX;
        for (int i = l; i <= r; i++) {
            int temp = minSum(nums, i);
            if (temp != -1) {
                minSumRes = min(minSumRes, temp);
            }
        }

        return (minSumRes == INT_MAX) ? -1 : minSumRes;
    }

    int minSum(vector<int>& nums, int windowSize) {
        
        int n = nums.size(), windowSum = 0, minSum = INT_MAX;
        for (int i = 0; i < windowSize; ++i) {
            windowSum += nums[i];
        }

        if (windowSum > 0) {
            minSum = windowSum;
        }

        for (int i = windowSize; i < n; i++) {
            windowSum += nums[i];
            windowSum -= nums[i - windowSize];
            minSum = (windowSum > 0) ? min(minSum, windowSum) : minSum;
        }

        return (minSum == INT_MAX) ? -1 : minSum;
    }
};