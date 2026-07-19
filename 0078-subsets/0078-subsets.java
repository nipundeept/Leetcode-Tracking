class Solution {
    List<List<Integer>> result = new ArrayList<>();
    public List<List<Integer>> subsets(int[] nums) {
        helper(0, nums, new ArrayList<>());
        return result;
    }
    void helper(int start, int[] nums, List<Integer> curr) {
        result.add(new ArrayList<>(curr));
        for (int i = start; i < nums.length; i++) {
            curr.add(nums[i]);
            helper(i + 1, nums, curr);
            curr.remove(curr.size() - 1);
        }
        return;
    }
}