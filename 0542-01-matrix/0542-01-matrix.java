class Solution {
    public int[][] updateMatrix(int[][] mat) {
        //here we will be adding all the indices of 0s to the queue and mark all the ones (1s) as unvisited [-1], we poll the queue, and check if its neighbor is unvisited, if it is so, we replace the value of neighbor to current cell value + 1, and add that member to the queue
        Queue<int[]> queue = new LinkedList<>();

        int gridRow = mat.length, gridCol = mat[0].length;

        for (int i = 0; i < gridRow; ++i) {
            for (int j = 0; j < gridCol; ++j) {
                if (mat[i][j] == 0) {
                    queue.offer(new int[] {i, j});
                }
                else {
                    mat[i][j] = -1; //unvisited
                }
            }
        }

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

                if (mat[newRow][newCol] == -1) {
                    mat[newRow][newCol] = mat[row][col] + 1;
                    queue.offer(new int[] {newRow, newCol});
                }
            }
        }

        return mat;
    }
}