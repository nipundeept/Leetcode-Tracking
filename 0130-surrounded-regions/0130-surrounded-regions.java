class Solution {
    public void solve(char[][] board) {
        int gridRow = board.length;
        int gridCol = board[0].length;
        boolean[][] visited = new boolean[gridRow][gridCol];
        for (int i = 0; i < gridRow; i++) {
            for (int j = 0; j < gridCol; j++) {
                if (i == 0 || i == gridRow - 1 || j == 0 || j == gridCol - 1) {
                    if (board[i][j] == 'O' && !visited[i][j]) {
                        bfs(new int[] {i, j}, board, visited, gridRow, gridCol);
                    }
                }
            }
        }

        for (int i = 0; i < gridRow; i++) {
            for (int j = 0; j < gridCol; j++) {
                if (board[i][j] == 'O' && !visited[i][j]) {
                    board[i][j] = 'X';
                }
            }
        }
    }

    private void bfs(int[] node, char[][] board, boolean[][] visited, int gridRow, int gridCol) {
        
        int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(node);
        visited[node[0]][node[1]] = true;

        while(!queue.isEmpty()) {
            int[] curr = queue.poll();
            int row = curr[0], col = curr[1];

            for(int[] direction : directions) {
                int newRow = row + direction[0];
                int newCol = col + direction[1];

                if (newRow < 0 || newRow >= gridRow || newCol < 0 || newCol >= gridCol) {
                    continue;
                }

                if (board[newRow][newCol] == 'X') {
                    continue;
                }

                if (visited[newRow][newCol]) {
                    continue;
                }
            
                if (board[newRow][newCol] == 'O') {
                    visited[newRow][newCol] = true;
                    queue.offer(new int[] {newRow, newCol});
                }
            }
        }
    }
}