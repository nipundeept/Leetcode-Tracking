class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int top = 0, bottom = matrix.length - 1;
        while (top <= bottom) {
            int mid = (top + bottom) / 2;
            if (matrix[mid][0] == target) {
                return true;
            }
            else if (matrix[mid][0] > target) {
                bottom = mid - 1;
            }
            else {
                top = mid + 1;
            }
        }
        if (bottom < 0) {
            return false;
        }
        //bottom now points to the row which will contain the key, now we apply binary search in that row
        int left = 0, right = matrix[0].length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (matrix[bottom][mid] == target) {
                return true;
            }
            else if (matrix[bottom][mid] < target) {
                left = mid + 1;
            }
            else {
                right = mid - 1;
            }
        }
        return false;
    }
}