class Solution {
    public int numIslands(char[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        boolean[][] visited = new boolean[rows][cols];
        int result = 0;
        //storing possible grid directions in an array
        int[][]direction = {{-1,0}, {1,0}, {0,-1}, {0,1}};
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (!visited[r][c]) { //new component found
                    if (grid[r][c] == '1') {
                        result++;
                        Queue<int[]> queue = new LinkedList<>();
                        queue.offer(new int[]{r,c});
                        visited[r][c] = true; //set it as visited after adding it to the queue
                        //BFS
                        while(!queue.isEmpty()) {
                            int[] curr = queue.poll();
                            int row = curr[0], col = curr[1];
                            for (int[] dir : direction) {
                                int newRow = row + dir[0];
                                int newCol = col + dir[1];
                                //check boundaries
                                if (newRow < 0 || newRow >= rows || newCol < 0 || newCol >=  cols) {
                                    continue;
                                }
                                if (visited[newRow][newCol]) {
                                    continue;
                                }
                                if (grid[newRow][newCol] == '0') {
                                    continue;
                                }
                                visited[newRow][newCol] = true;
                                queue.offer(new int[] {newRow, newCol});
                            }
                        }
                    }
                }
            }
        }

        return result;
    }
}