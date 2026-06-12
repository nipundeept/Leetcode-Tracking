class Solution {
    public void rotate(int[][] matrix) {
        //core idea : take transpose of the matrix and then reverse every elements of each row
        for (int i = 0; i < matrix.length - 1; i++) {
            for (int j = i + 1; j < matrix[i].length; j++) {
                //taking the upper half of the matrix (from the diagonal) and swapping with their corresponding rows and columns
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
        //reversing each rows in a matrix
        for (int i = 0; i < matrix.length; i++) {
            int left = 0, right = matrix[i].length - 1;
            while (left < right) {
                int temp = matrix[i][left];
                matrix[i][left] = matrix[i][right];
                matrix[i][right] = temp;
                left++;
                right--;
            }
        }
    }
}