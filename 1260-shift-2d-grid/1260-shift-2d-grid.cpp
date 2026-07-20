class Solution {
public:
    vector<vector<int>> shiftGrid(vector<vector<int>>& grid, int k) {
        //bruteforce : copying all elements of grid in a linear array and then rotating the linear array to the right by k, copying all the elements of the linear array back into the grid.
        vector<int>linear;
        for (int i = 0; i < grid.size(); i++) {
            for (int j = 0; j < grid[i].size(); j++) {
                linear.push_back(grid[i][j]);
            }
        }
        k = k % linear.size();
        int x = 0;
        rotate(linear.begin(), linear.end() - k, linear.end());
        for (int i = 0; i < grid.size(); i++) {
            for (int j = 0; j < grid[i].size(); j++) {
                grid[i][j] = linear[x++];
            }
        }
        return grid;
    }
};