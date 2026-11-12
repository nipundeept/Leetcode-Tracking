class Solution {
public:
    int longestMonotonicSubarray(vector<int>& nums) {
        int n = nums.size(), incMax = -1, decMax= -1;
        for (int i = 0; i < n; i++) {
            
            int curr_length = 0, temp = nums[i];
            for (int j = i; j < n; ++j) {
                if (nums[j] > temp || j == i) {
                    curr_length++;
                }
                else {
                    break;
                }
                temp = nums[j];
            }
            incMax = max(incMax, curr_length);
        }

        for (int i = 0; i < n; i++) {
            
            int curr_length = 0, temp = nums[i];
            for (int j = i; j < n; ++j) {
                if (nums[j] < temp || j == i) {
                    curr_length++;
                }
                else {
                    break;
                }
                temp = nums[j];
            }
            decMax = max(decMax, curr_length);
        }

        return max(decMax, incMax);
    }
};