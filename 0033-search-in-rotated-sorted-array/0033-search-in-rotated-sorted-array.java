class Solution {
    public int search(int[] nums, int target) {
        //Core idea : one of the two split arrays will always be sorted
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] == target) {
                return mid; //target is found and returned
            }
            if (nums[left] <= nums[mid]) { //left half is strictly sorted
                if (nums[left] <= target && target < nums[mid]) {//is the target within the boundaries of the left half?
                right = mid - 1;
                }
                else {
                    left = mid + 1;
                }
            }
            else { //right half is strictly sorted
                if (nums[mid] < target && target <= nums[right]) {
                    left = mid + 1;  // Discard left half
                } else {
                    right = mid - 1; // Discard right half
                }
            }
        }
        return -1;       
    }
}