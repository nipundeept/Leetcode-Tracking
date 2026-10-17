class Solution {
    public int islandPerimeter(int[][] grid) {
        int perimeter = 0;
        int gridRow = grid.length, gridCol = grid[0].length;
        int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        for (int i = 0; i < gridRow; i++) {
            for (int j = 0; j < gridCol; j++) {
                if (grid[i][j] == 1) {
                    for (int[] direction : directions) {
                        int newRow = i + direction[0];
                        int newCol = j + direction[1];
                        if (newRow < 0 || newCol < 0 || newRow >= gridRow || newCol >= gridCol || grid[newRow][newCol] == 0)
                            perimeter += 1;
                    }
                }
            }
        }

        return perimeter;
    }
}