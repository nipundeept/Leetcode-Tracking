class Solution {
public:
    vector<int> productExceptSelf(vector<int>& nums) {
        //for every element, we can compute its left product and right product and multiply them together
        //eg. for element 2, product on left is 1 and the product on right = 3 * 4 = 12, so overall product = 1 * 12 = 12
        int n = nums.size();
        vector<int> ans(n);
        vector<int> leftProduct(n);
        int runningProduct = 1;
        for (int i = 0; i < n; i++) {
            leftProduct[i] = runningProduct;
            runningProduct *= nums[i];
        }
        //leftProduct array now contains all the products to the left of that element
        //now we traverse the array backwards for the right product and simultaneously build our answer, without creating another array for right product
        runningProduct = 1;
        for (int i = n - 1; i >= 0; i--) {
            ans[i] = leftProduct[i] * runningProduct;
            runningProduct *= nums[i];
        }
        return ans;
    }
};