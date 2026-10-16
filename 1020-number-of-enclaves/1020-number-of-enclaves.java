class Solution {
    public int numEnclaves(int[][] grid) {
        int gridRow = grid.length, gridCol = grid[0].length;
        for (int i = 0; i < gridRow; i++) {
            for (int j = 0; j < gridCol; j++) {
                if ((i == 0 || i == gridRow - 1 || j == 0 || j == gridCol - 1) && grid[i][j] == 1) {
                    dfs(new int[] {i, j}, grid, gridRow, gridCol);
                }
            }
        }
        
        int result = 0;
        for (int i = 0; i < gridRow; i++) {
            for (int j = 0; j < gridCol; j++) {
                if (grid[i][j] == 1) {
                    result++;
                }
            }
        }

        return result;
    }

    private void dfs(int[] node, int[][] grid, int gridRow, int gridCol) {
        Queue<int[]> queue = new LinkedList<>();
        int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

        queue.offer(new int[] {node[0], node[1]});
        grid[node[0]][node[1]] = 0;

        while (!queue.isEmpty()) {

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

                grid[newRow][newCol] = 0;
                queue.offer(new int[]{newRow, newCol});
            }
        }

    }
}