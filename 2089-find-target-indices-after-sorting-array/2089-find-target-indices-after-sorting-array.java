class Solution {
    public List<Integer> targetIndices(int[] nums, int target) {
        List<Integer> result = new ArrayList<>();
        int n = nums.length;
        int countTarget = 0, countLessThanTarget = 0;
        for (int i = 0; i < n; i++) {
            if (nums[i] == target) {
                countTarget++;
            }
            else if (nums[i] < target) {
                countLessThanTarget++;
            }
        }

        for (int i = countLessThanTarget; i < countTarget + countLessThanTarget; i++) {
            result.add(i);
        }

        return result;
    }
}