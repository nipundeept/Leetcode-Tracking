class Solution {
public:
    vector<vector<int>> shiftGrid(vector<vector<int>>& grid, int k) {
        //bruteforce : copying all elements of grid in a linear array and then rotating the linear array to the right by k, copying all the elements of the linear array back into the grid.
        vector<int>linear;
        linear.reserve(grid.size() * grid[0].size());
        int m = grid.size();
        int n = grid[0].size();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                linear.push_back(grid[i][j]);
            }
        }
        k = k % linear.size();
        int x = 0;
        if (k != 0)
            rotate(linear.begin(), linear.end() - k, linear.end());
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                grid[i][j] = linear[x++];
            }
        }
        return grid;
    }
};