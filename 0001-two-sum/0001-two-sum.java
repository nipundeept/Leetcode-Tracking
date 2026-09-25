class Solution {
    public int[] twoSum(int[] nums, int target) {
        int n = nums.length;
        int[] result = new int[2];
        Map<Integer, Integer> map = new HashMap<>(); //a map consisting of value, index pair
        for (int i = 0; i < n; i++) {
            int comp = target - nums[i];
            if (map.containsKey(comp)) {
                result[0] = map.get(comp);
                result[1] = i;
                return result;
            }
            map.put(nums[i], i);
        }
        return result;
    }
}