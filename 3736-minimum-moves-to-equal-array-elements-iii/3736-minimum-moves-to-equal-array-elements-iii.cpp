class Solution {
public:
    int minMoves(vector<int>& nums) {
        // since we cannot decrease an element to make all elements in the array as equal, we have to select the largest one in the array as the target

        int target = 0, n = nums.size(), moves = 0;
        for (int num : nums) {
            target = max(target, num);
        }

        for (int num : nums) {
            moves += (target - num);
        }

        return moves;
    }
};