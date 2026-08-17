class Solution {
    public int countCompleteSubarrays(int[] nums) {
        int n = nums.length;
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        int k = set.size();
        return atMaxK(nums, k) - atMaxK(nums, k - 1);
    }

    private int atMaxK(int[] nums, int k) {
        int n = nums.length;
        Map<Integer, Integer> map = new HashMap<>();
        int left = 0, count = 0;
        for (int right = 0; right < n; right++) {
            map.put(nums[right], map.getOrDefault(nums[right], 0) + 1);
            while (map.size() > k) {
                int value = nums[left];
                map.put(value, map.get(value) - 1);
                if(map.get(value) == 0) {
                    map.remove(value);
                }
                left++;
            }
            count += (right - left + 1);
        }

        return count;
    }
}