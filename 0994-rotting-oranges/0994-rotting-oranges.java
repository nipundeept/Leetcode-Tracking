class Solution {
    public int orangesRotting(int[][] grid) {
        int gridRow = grid.length, gridCol = grid[0].length;
        Queue<int[]> queue = new LinkedList<>();
        int freshCount = 0;

        for (int i = 0; i < gridRow; i++) {
            for (int j = 0; j < gridCol; j++) {
                if (grid[i][j] == 2) {
                    queue.offer(new int[] {i, j});
                }
                else if (grid[i][j] == 1) {
                    freshCount++;
                }
            }
        }

        if (freshCount == 0) {
            return 0;
        }

        int minute = -1;
        int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

        while(!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; ++i) {
                int[] curr = queue.poll();

                int row = curr[0], col = curr[1];

                for (int[] direction : directions) {
                    
                    int newRow = row + direction[0];
                    int newCol = col + direction[1];

                    if (newRow < 0 || newRow >= gridRow || newCol < 0 || newCol >= gridCol) {
                        continue;
                    }

                    if (grid[newRow][newCol] == 0 || grid[newRow][newCol] == 2) {
                        continue;
                    }

                    queue.offer(new int[] {newRow, newCol});
                    grid[newRow][newCol] = 2;
                }
            }

            minute++;
        }

        for (int i = 0; i < gridRow; i++) {
            for (int j = 0; j < gridCol; j++) {
                if (grid[i][j] == 1) {
                    return -1;
                }
            }
        }

        return minute;
    }
}