class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        int n = nums.length;
        boolean[] found = new boolean[n + 1];
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (found[nums[i]]) {
                result.add(nums[i]);
            }
            else {
                found[nums[i]] = true;
            }
        }
        return result;
    }
}