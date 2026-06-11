class Solution {
    public void nextPermutation(int[] nums) {
        int pivot_index = -1;
        for (int i = nums.length - 1; i > 0; i--) {
            if (nums[i - 1] < nums[i]) {
                pivot_index = i - 1;
                break;
            }
        }
        if (pivot_index == -1) {
            int left = 0, right = nums.length - 1;
            while (left < right) {
                int temp = nums[left];
                nums[left] = nums[right];
                nums[right] = temp;
                left++;
                right--;
            }
            return;
        }
        int successor_index = -1;
        for (int i = nums.length - 1; i > pivot_index; i--) {
            if (nums[i] > nums[pivot_index]) {
                successor_index = i;
                break;
            }
        }
        int temp = nums[pivot_index];
        nums[pivot_index] = nums[successor_index];
        nums[successor_index] = temp;
        int left = pivot_index + 1;
        int right = nums.length - 1;
        while (left < right) {
            temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;
            left++;
            right--;
        }
    }
}