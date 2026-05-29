class Solution {
    public int[] getSneakyNumbers(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        int[] res = new int[2]; int k = 0;
        for (int i = 0 ; i < nums.length; i++) map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int key = entry.getKey();
            int value = entry.getValue();
            if (value == 2) {
                res[k++] = key;
            }
        }
        return res;
    }
}