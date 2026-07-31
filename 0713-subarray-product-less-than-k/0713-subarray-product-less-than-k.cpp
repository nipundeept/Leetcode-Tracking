class Solution {
public:
    int numSubarrayProductLessThanK(vector<int>& nums, int k) {
        int n = nums.size();
        //edge case
        if (k <= 1) {
            return 0;
        }
        int left = 0, product = 1, count = 0;
        for (int right = 0; right < n; right++) {
            int num = nums[right];
            product = product * num;
            while (product >= k) { //window becomes invalid then shrink it
                product /= nums[left];
                left++;
            }
            //window here is valid, so we update 
            count += (right - left + 1); //length of valid subarray is the count of the possible subarrays

        }
        return count;
    }
};