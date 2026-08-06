class Solution {
    public int firstUniqueFreq(int[] nums) {
        Map<Integer, Integer> freq_map = new LinkedHashMap<>();
        Map<Integer, Integer> freq_count = new HashMap<>();
        for (int num : nums) {
            freq_map.put(num, freq_map.getOrDefault(num, 0) + 1);
        }
        for (int freq : freq_map.values()) {
            freq_count.put(freq, freq_count.getOrDefault(freq, 0) + 1);
        }
        for (int key : freq_map.keySet()) {
            if (freq_count.get(freq_map.get(key)) == 1) {
                return key;
            }
        }
        return -1;
    }
}