class Solution {
    public int[] findErrorNums(int[] nums) {

        int i = 0, n = nums.length;
        while (i < n) {
            int correctIdx = nums[i] - 1;
            if (nums[i] != nums[correctIdx]) {
                int temp = nums[i];
                nums[i] = nums[correctIdx];
                nums[correctIdx] = temp;
            }
            else {
                i++;
            }
        }

        for (int j = 0; j < n; j++) {
            if (nums[j] != j + 1) {
                return new int[] {nums[j], j + 1};
            }
        }

        return null;
    }
}