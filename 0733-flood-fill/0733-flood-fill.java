class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        boolean[][] visited = new boolean[image.length][image[0].length];
        helper(image, sr, sc, visited, color);
        return image;
    }

    private void helper(int[][] grid, int sr, int sc, boolean[][] visited, int color) {
        int[][] directions = {
            {-1, 0},
            {1, 0},
            {0, -1},
            {0, 1}
        };
        int rows = grid.length;
        int column = grid[0].length;
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[] {sr, sc});
        int value = grid[sr][sc];
        grid[sr][sc] = color;
        visited[sr][sc] = true;

        while(!queue.isEmpty()) {
            int[] current = queue.poll();
            int row = current[0];
            int col = current[1];

            for (int[] dir : directions) {
                int newRow = row + dir[0];
                int newCol = col + dir[1];

                if (newRow < 0 || newRow >= rows || newCol < 0 || newCol >= column) {
                    continue;
                }

                if (visited[newRow][newCol]) {
                    continue;
                }

                if (grid[newRow][newCol] != value) {
                    continue;
                }

                visited[newRow][newCol] = true;
                grid[newRow][newCol] = color;

                queue.offer(new int[] {newRow, newCol});

            }
        }
    }

}