class Solution {
public:
    vector<int> pivotArray(vector<int>& nums, int pivot) {
        int left = 0, right = nums.size() - 1; //initialising two pointers for tracking indexes
        vector<int> res(nums.size());
        for (int i = 0, j = nums.size() - 1; j >= 0; i++, j--) {
            if (nums[i] < pivot) {
                res[left++] = nums[i];
            }
            if (nums[j] > pivot) {
                res[right--] = nums[j];
            }
        }
        while (left <= right) {
            res[left++] = pivot;
        }
        return res;
    }
};