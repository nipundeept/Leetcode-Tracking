class Solution {
    public int maxSubarrayLength(int[] nums, int k) {
        int n = nums.length;
        Map<Integer, Integer> map = new HashMap<>(); //frequency map
        int left = 0, res = 0;
        for (int right = 0; right < n; right++) {
            int elem_right = nums[right];
            map.put(elem_right, map.getOrDefault(elem_right, 0) + 1);
            //shrinking window when it's invalid to make it valid again
            while (map.get(elem_right) > k) {
                int elem_left = nums[left];
                map.put(elem_left, map.get(elem_left) - 1);
                left++;
            }
            //updating the answer when the window is valid again
            res = Math.max(res, right - left + 1);
        }
        return res;
    }
}