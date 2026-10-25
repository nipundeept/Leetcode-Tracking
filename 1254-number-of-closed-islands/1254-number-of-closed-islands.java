class Solution {
    public int closedIsland(int[][] grid) {
        int gridRow = grid.length;
        int gridCol = grid[0].length;
        int result = 0;
        for (int i = 0; i < gridRow; i++) {
            for (int j = 0; j < gridCol; j++) {
                if (grid[i][j] == 0) {
                    if (bfs(new int[]{i, j}, grid, gridRow, gridCol)) {
                        result++;
                    }
                }
            }
        }
        return result;
    }

    private boolean bfs(int[] cell, int[][] grid, int gridRow, int gridCol) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{cell[0], cell[1]});
        grid[cell[0]][cell[1]] = 1;
        int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

        boolean isClosed = true;

        while (!queue.isEmpty()) {
            int[] curr = queue.poll();

            int row = curr[0];
            int col = curr[1];
            
            if (row == 0 || row == gridRow - 1 ||
                col == 0 || col == gridCol - 1) {
                isClosed = false;
            }

            for (int[] direction : directions) {
                int newRow = row + direction[0];
                int newCol = col + direction[1];

                if (newRow < 0 || newRow >= gridRow ||
                    newCol < 0 || newCol >= gridCol) {
                    continue;
                }

                if (grid[newRow][newCol] == 1) {
                    continue;
                }

                grid[newRow][newCol] = 1;

                queue.offer(new int[]{newRow, newCol});
            }
        }

        return isClosed;
    }
}