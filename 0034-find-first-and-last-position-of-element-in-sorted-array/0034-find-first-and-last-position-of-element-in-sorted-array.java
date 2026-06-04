class Solution {
    public int[] searchRange(int[] nums, int target) {
        int []result = {-1,-1};
        int low = 0, high = nums.length - 1, i = 0;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] == target) {
                result[0] = mid;
                high = mid - 1; //search towards the extreme left
            }
            else if (nums[mid] < target) {
                low = mid + 1;
            }
            else {
                high = mid - 1;
            }
        }
        low = 0; high = nums.length - 1;
         while (low <= high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] == target) {
                result[1] = mid;
                low = mid + 1; //search towards the extreme left
            }
            else if (nums[mid] < target) {
                low = mid + 1;
            }
            else {
                high = mid - 1;
            }
        }
        return result;
    }
}