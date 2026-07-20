class Solution {
public:
    int sumOfSquares(vector<int>& nums) {
        int n = nums.size();
        int sum = 0, k = 1;
        for (int i = 0; i < n; i++) {
            if (n % (k++) == 0) {
                sum += pow(nums[i], 2);
            }
        }
        return sum;
    }
};