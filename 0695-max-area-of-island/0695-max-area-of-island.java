class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int max = 0;
        int gridRow = grid.length, gridCol = grid[0].length;
        for (int i = 0; i < gridRow; ++i) {
            for (int j = 0; j < gridCol; j++) {
                if (grid[i][j] == 1) {
                    int terms = termsInComponents(grid, i, j, gridRow, gridCol);
                    max = Math.max(max, terms);
                }
            }
        }

        return max;
    }

    private int termsInComponents(int[][] grid, int sr, int sc, int gridRow, int gridCol) {

        int terms = 1;
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[] {sr, sc});
        grid[sr][sc] = 0;

        int[][] directions = {{-1,0}, {1,0}, {0,-1}, {0,1}};
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

                if (grid[newRow][newCol] == 1) {
                    queue.offer(new int[] {newRow, newCol});
                    grid[newRow][newCol] = 0;
                    terms++;
                }
            }
        }

        return terms;
    }
}