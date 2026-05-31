class Solution {
    public int subarraySum(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();

        map.put (0,1); //default value of the map
        int current = 0;
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            current += nums[i];

            int toFind = current - k;
            if (map.containsKey(toFind)) {
                count += map.get(toFind);
            }
            map.put(current, map.getOrDefault(current, 0) + 1);
        }
        return count;
    }
}