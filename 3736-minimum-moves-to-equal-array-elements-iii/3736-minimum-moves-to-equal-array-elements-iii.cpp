class Solution {
public:
    int minMoves(vector<int>& nums) {
        // since we cannot decrease an element to make all elements in the array as equal, we have to select the largest one in the array as the target

        int target = 0, n = nums.size(), moves = 0;
        for (int i = 0; i < n; ++i) {
            target = max(target, nums[i]);
        }

        for (int i = 0; i < n; i++) {
            moves += (target - nums[i]);
        }

        return moves;
    }
};