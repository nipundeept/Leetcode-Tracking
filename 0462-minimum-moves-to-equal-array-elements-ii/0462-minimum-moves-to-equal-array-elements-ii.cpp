class Solution {
public:
    int minMoves2(vector<int>& nums) {
        // brute : try making every element equal to every possible integer target and calculate total number of moves (On2)
        // instead we select the median (after sorting), the numbers in between those medians will give us the minimum moves everytime
        sort(nums.begin(), nums.end());
        int median = nums[nums.size() / 2]; //so we select only one
        int moves = 0;
        for (auto num : nums) {
            moves += abs(num - median);
        }

        return moves;
    }
};