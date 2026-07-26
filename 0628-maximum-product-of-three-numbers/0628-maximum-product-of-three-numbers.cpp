class Solution {
public:
    int maximumProduct(vector<int>& nums) {
        sort(nums.begin(), nums.end());
        int n = nums.size();
        //after sorting, if there are multiple negative values, the product of first two numbers (in negative), will be a positive, and on the other side, the positive highest numbers (n-1) and (n-2)th, (n-3) element can have largest product(if all are positive)
        int firstThree = nums[0] * nums[1] * nums[n - 1]; //-ve X -ve X +ve = +ve
        int lastThree = nums[n - 1] * nums[n - 2] * nums[n - 3];
        return max(firstThree, lastThree);
    }
};