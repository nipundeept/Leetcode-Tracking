class Solution {
    public int countIslands(int[][] grid, int k) {
        int gridRow = grid.length, gridCol = grid[0].length;
        int result = 0;

        for (int i = 0; i < gridRow; i++) {
            for (int j = 0; j < gridCol; j++) {
                if (grid[i][j] != 0) {
                    long sumComponents = bfs(grid, new int[]{i, j}, gridRow, gridCol);
                    if (sumComponents % k == 0) {
                        result++;
                    }
                }
            }
        }

        return result;
    }

    private long bfs(int[][] grid, int[] cell, int gridRow, int gridCol) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[] {cell[0], cell[1]});

        long sum = 0;
        sum += grid[cell[0]][cell[1]];
        grid[cell[0]][cell[1]] = 0;

        int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

        while(!queue.isEmpty()) {
            int[] curr = queue.poll();
            int row = curr[0], col = curr[1];

            for (int[] direction : directions) {
                int newRow = row + direction[0];
                int newCol = col + direction[1];

                if (newRow < 0 || newRow >= gridRow || newCol < 0 || newCol >= gridCol) {
                    continue;
                }

                if (grid[newRow][newCol] == 0) {
                    continue;
                }

                sum += grid[newRow][newCol];
                queue.offer(new int[] {newRow, newCol});
                grid[newRow][newCol] = 0;
            }
        }

        return sum;
    }
}